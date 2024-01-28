package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.familyhelper.clannad.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateFile;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateFileUploadInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.CertificateFileInfo;
import com.dwarfeng.familyhelper.clannad.stack.handler.CertificateFileOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.CertificateFileInfoMaintainService;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.generation.KeyGenerator;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CertificateFileOperateHandlerImpl implements CertificateFileOperateHandler {

    private final CertificateFileInfoMaintainService certificateFileInfoMaintainService;
    private final FtpHandler ftpHandler;

    private final KeyGenerator<LongIdKey> keyGenerator;

    private final OperateHandlerValidator operateHandlerValidator;

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
    public CertificateFile downloadCertificateFile(StringIdKey userKey, LongIdKey certificateFileKey) throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 确认证件文件存在。
            operateHandlerValidator.makeSureCertificateFileExists(certificateFileKey);

            // 3. 获取证件文件对应的证件，并确认用户有权限操作证件。
            CertificateFileInfo certificateFileInfo = certificateFileInfoMaintainService.get(certificateFileKey);
            operateHandlerValidator.makeSureUserInspectPermittedForCertificate(
                    userKey, certificateFileInfo.getCertificateKey()
            );

            // 4. 下载证件文件。
            byte[] content = ftpHandler.retrieveFile(
                    new String[]{FtpConstants.PATH_CERTIFICATE_FILE}, getFileName(certificateFileKey)
            );

            // 6. 拼接 CertificateFile 并返回。
            return new CertificateFile(certificateFileInfo.getOriginName(), content);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void uploadCertificateFile(StringIdKey userKey, CertificateFileUploadInfo certificateFileUploadInfo) throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 确认证件文件所属的证件存在。
            LongIdKey certificateKey = certificateFileUploadInfo.getCertificateKey();
            operateHandlerValidator.makeSureCertificateExists(certificateKey);

            // 3. 确认用户有权限操作证件。
            operateHandlerValidator.makeSureUserModifyPermittedForCertificate(userKey, certificateKey);

            // 4. 分配主键。
            LongIdKey certificateFileKey = keyGenerator.generate();

            // 5. 证件文件内容并存储（覆盖）。
            byte[] content = certificateFileUploadInfo.getContent();
            ftpHandler.storeFile(new String[]{FtpConstants.PATH_CERTIFICATE_FILE}, getFileName(certificateFileKey), content);

            // 6. 根据 certificateFileUploadInfo 构造 CertificateFileInfo，插入或更新。
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
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 确认证件文件存在。
            operateHandlerValidator.makeSureCertificateFileExists(certificateFileKey);

            // 3. 获取证件文件对应的证件，并确认用户有权限操作证件。
            CertificateFileInfo certificateFileInfo = certificateFileInfoMaintainService.get(certificateFileKey);
            operateHandlerValidator.makeSureUserModifyPermittedForCertificate(userKey, certificateFileInfo.getCertificateKey());

            // 4. 如果存在 CertificateFile 文件，则删除。
            if (ftpHandler.existsFile(new String[]{FtpConstants.PATH_CERTIFICATE_FILE}, getFileName(certificateFileKey))) {
                ftpHandler.deleteFile(new String[]{FtpConstants.PATH_CERTIFICATE_FILE}, getFileName(certificateFileKey));
            }

            // 5. 如果存在 CertificateFileInfo 实体，则删除。
            certificateFileInfoMaintainService.deleteIfExists(certificateFileKey);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    private String getFileName(LongIdKey certificateFileKey) {
        return Long.toString(certificateFileKey.getLongId());
    }
}
