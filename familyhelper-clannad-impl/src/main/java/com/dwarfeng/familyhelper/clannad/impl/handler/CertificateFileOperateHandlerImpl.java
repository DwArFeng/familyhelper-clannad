package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.dutil.basic.io.IOUtil;
import com.dwarfeng.familyhelper.clannad.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateFile;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateFileUploadInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateThumbnail;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.CertificateFileInfo;
import com.dwarfeng.familyhelper.clannad.stack.handler.CertificateFileOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.CertificateFileInfoMaintainService;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.generation.KeyGenerator;
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

@Component
public class CertificateFileOperateHandlerImpl implements CertificateFileOperateHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CertificateFileOperateHandlerImpl.class);

    private final CertificateFileInfoMaintainService certificateFileInfoMaintainService;
    private final FtpHandler ftpHandler;

    private final KeyGenerator<LongIdKey> keyGenerator;

    private final OperateHandlerValidator operateHandlerValidator;

    @Value("${certificate_thumbnail.width}")
    private int thumbnailWidth;
    @Value("${certificate_thumbnail.height}")
    private int thumbnailHeight;
    @Value("${certificate_thumbnail.quality}")
    private double thumbnailQuality;
    @Value("${certificate_thumbnail.output_format}")
    private String thumbnailOutputFormat;

    public CertificateFileOperateHandlerImpl(
            CertificateFileInfoMaintainService certificateFileInfoMaintainService,
            FtpHandler ftpHandler,
            KeyGenerator<LongIdKey> keyGenerator,
            OperateHandlerValidator operateHandlerValidator
    ) {
        this.certificateFileInfoMaintainService = certificateFileInfoMaintainService;
        this.ftpHandler = ftpHandler;
        this.keyGenerator = keyGenerator;
        this.operateHandlerValidator = operateHandlerValidator;
    }

    @Override
    public CertificateFile downloadCertificateFile(StringIdKey userKey, LongIdKey certificateFileKey)
            throws HandlerException {
        try {
            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认证件文件存在。
            operateHandlerValidator.makeSureCertificateFileExists(certificateFileKey);

            // 获取证件文件对应的证件，并确认用户有权限操作证件。
            CertificateFileInfo certificateFileInfo = certificateFileInfoMaintainService.get(certificateFileKey);
            operateHandlerValidator.makeSureUserInspectPermittedForCertificate(
                    userKey, certificateFileInfo.getCertificateKey()
            );

            // 下载证件文件。
            byte[] content = ftpHandler.retrieveFile(
                    FtpConstants.PATH_CERTIFICATE_FILE, getFileName(certificateFileKey)
            );

            // 拼接 CertificateFile 并返回。
            return new CertificateFile(certificateFileInfo.getOriginName(), content);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public CertificateThumbnail downloadCertificateThumbnail(StringIdKey userKey, LongIdKey certificateFileKey)
            throws HandlerException {
        try {
            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认证件文件存在。
            operateHandlerValidator.makeSureCertificateFileExists(certificateFileKey);

            // 获取证件文件对应的证件，并确认用户有权限操作证件。
            CertificateFileInfo certificateFileInfo = certificateFileInfoMaintainService.get(certificateFileKey);
            operateHandlerValidator.makeSureUserInspectPermittedForCertificate(
                    userKey, certificateFileInfo.getCertificateKey()
            );

            // 由于缩略图功能是后期添加的，所以可能存在没有缩略图的情况。
            // 如果不存在证件的缩略图，则创建。
            boolean existsThumbnail = ftpHandler.existsFile(
                    FtpConstants.PATH_CERTIFICATE_THUMBNAIL, getFileName(certificateFileKey)
            );
            if (!existsThumbnail) {
                LOGGER.info("证件文件 {} 的缩略图不存在, 将创建缩略图...", certificateFileKey);
                createCertificateThumbnail(getFileName(certificateFileKey));
            }

            // 下载缩略图。
            byte[] content = ftpHandler.retrieveFile(
                    FtpConstants.PATH_CERTIFICATE_THUMBNAIL, getFileName(certificateFileKey)
            );

            // 拼接 CertificateThumbnail 并返回。
            return new CertificateThumbnail(certificateFileInfo.getOriginName(), content);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @SuppressWarnings("ExtractMethodRecommender")
    @Override
    public void uploadCertificateFile(StringIdKey userKey, CertificateFileUploadInfo certificateFileUploadInfo)
            throws HandlerException {
        try {
            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认证件文件所属的证件存在。
            LongIdKey certificateKey = certificateFileUploadInfo.getCertificateKey();
            operateHandlerValidator.makeSureCertificateExists(certificateKey);

            // 确认用户有权限操作证件。
            operateHandlerValidator.makeSureUserModifyPermittedForCertificate(userKey, certificateKey);

            // 分配主键。
            LongIdKey certificateFileKey = keyGenerator.generate();

            // 证件文件内容并存储（覆盖）。
            byte[] content = certificateFileUploadInfo.getContent();
            ftpHandler.storeFile(FtpConstants.PATH_CERTIFICATE_FILE, getFileName(certificateFileKey), content);

            // 生成缩略图并存储（覆盖）。
            createCertificateThumbnail(getFileName(certificateFileKey));

            // 根据 certificateFileUploadInfo 构造 CertificateFileInfo，插入或更新。
            Date currentDate = new Date();
            // 映射属性。
            CertificateFileInfo certificateFileInfo = new CertificateFileInfo();
            certificateFileInfo.setKey(certificateFileKey);
            certificateFileInfo.setCertificateKey(certificateKey);
            certificateFileInfo.setOriginName(certificateFileUploadInfo.getOriginName());
            certificateFileInfo.setLength(certificateFileUploadInfo.getContent().length);
            certificateFileInfo.setUploadDate(currentDate);
            certificateFileInfo.setRemark("通过 familyhelper-clannad 服务上传/更新证件文件");
            certificateFileInfoMaintainService.insertOrUpdate(certificateFileInfo);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void removeCertificateFile(StringIdKey userKey, LongIdKey certificateFileKey) throws HandlerException {
        try {
            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认证件文件存在。
            operateHandlerValidator.makeSureCertificateFileExists(certificateFileKey);

            // 获取证件文件对应的证件，并确认用户有权限操作证件。
            CertificateFileInfo certificateFileInfo = certificateFileInfoMaintainService.get(certificateFileKey);
            operateHandlerValidator.makeSureUserModifyPermittedForCertificate(
                    userKey, certificateFileInfo.getCertificateKey()
            );

            // 如果存在 CertificateFile 文件，则删除。
            if (ftpHandler.existsFile(FtpConstants.PATH_CERTIFICATE_FILE, getFileName(certificateFileKey))) {
                ftpHandler.deleteFile(FtpConstants.PATH_CERTIFICATE_FILE, getFileName(certificateFileKey));
            }

            // 如果存在 CertificateThumbnail 文件，则删除。
            if (ftpHandler.existsFile(FtpConstants.PATH_CERTIFICATE_THUMBNAIL, getFileName(certificateFileKey))) {
                ftpHandler.deleteFile(FtpConstants.PATH_CERTIFICATE_THUMBNAIL, getFileName(certificateFileKey));
            }

            // 如果存在 CertificateFileInfo 实体，则删除。
            certificateFileInfoMaintainService.deleteIfExists(certificateFileKey);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    private String getFileName(LongIdKey certificateFileKey) {
        return Long.toString(certificateFileKey.getLongId());
    }

    private void createCertificateThumbnail(String certificateFileName) throws Exception {
        // 定义临时变量，缩短代码长度。
        String[] pcf = FtpConstants.PATH_CERTIFICATE_FILE;
        String[] pct = FtpConstants.PATH_CERTIFICATE_THUMBNAIL;
        // 定义缩略图。
        byte[] thumbnailContent;
        // 打开原图的输入流，并在 try-with-resources 中创建缩略图。
        try (
                InputStream in = ftpHandler.openInputStream(pcf, certificateFileName);
                ByteArrayOutputStream bout = new ByteArrayOutputStream()
        ) {
            Thumbnails.of(in).size(thumbnailWidth, thumbnailHeight).outputQuality(thumbnailQuality)
                    .outputFormat(thumbnailOutputFormat).toOutputStream(bout);
            thumbnailContent = bout.toByteArray();
        }
        // 打开缩略图的输出流，并在 try-with-resources 中写入缩略图。
        try (
                InputStream in = new ByteArrayInputStream(thumbnailContent);
                OutputStream out = ftpHandler.openOutputStream(pct, certificateFileName)
        ) {
            IOUtil.trans(in, out, 4096);
        }
    }
}
