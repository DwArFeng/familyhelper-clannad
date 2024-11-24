package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.dutil.basic.io.IOUtil;
import com.dwarfeng.familyhelper.clannad.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constants;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Message;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageAttachmentInfo;
import com.dwarfeng.familyhelper.clannad.stack.handler.MessageAttachmentOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageAttachmentInfoMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageMaintainService;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.generation.KeyGenerator;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

@Component
public class MessageAttachmentOperateHandlerImpl implements MessageAttachmentOperateHandler {

    private static final Set<Integer> VALID_MESSAGE_STATUS_SET_DOWNLOAD;
    private static final Set<Integer> VALID_MESSAGE_STATUS_SET_UPLOAD;
    private static final Set<Integer> VALID_MESSAGE_STATUS_SET_UPDATE;
    private static final Set<Integer> VALID_MESSAGE_STATUS_SET_REMOVE;

    static {
        Set<Integer> VALID_MESSAGE_STATUS_SET_DOWNLOAD_DEJA_VU = new HashSet<>();
        VALID_MESSAGE_STATUS_SET_DOWNLOAD_DEJA_VU.add(Constants.MESSAGE_STATUS_EDITING);
        VALID_MESSAGE_STATUS_SET_DOWNLOAD_DEJA_VU.add(Constants.MESSAGE_STATUS_SENT);
        VALID_MESSAGE_STATUS_SET_DOWNLOAD_DEJA_VU.add(Constants.MESSAGE_STATUS_RECEIVED);
        VALID_MESSAGE_STATUS_SET_DOWNLOAD = Collections.unmodifiableSet(VALID_MESSAGE_STATUS_SET_DOWNLOAD_DEJA_VU);

        Set<Integer> VALID_MESSAGE_STATUS_SET_UPLOAD_DEJA_VU = new HashSet<>();
        VALID_MESSAGE_STATUS_SET_UPLOAD_DEJA_VU.add(Constants.MESSAGE_STATUS_EDITING);
        VALID_MESSAGE_STATUS_SET_UPLOAD = Collections.unmodifiableSet(VALID_MESSAGE_STATUS_SET_UPLOAD_DEJA_VU);

        Set<Integer> VALID_MESSAGE_STATUS_SET_UPDATE_DEJA_VU = new HashSet<>();
        VALID_MESSAGE_STATUS_SET_UPDATE_DEJA_VU.add(Constants.MESSAGE_STATUS_EDITING);
        VALID_MESSAGE_STATUS_SET_UPDATE = Collections.unmodifiableSet(VALID_MESSAGE_STATUS_SET_UPDATE_DEJA_VU);

        Set<Integer> VALID_MESSAGE_STATUS_SET_REMOVE_DEJA_VU = new HashSet<>();
        VALID_MESSAGE_STATUS_SET_REMOVE_DEJA_VU.add(Constants.MESSAGE_STATUS_EDITING);
        VALID_MESSAGE_STATUS_SET_REMOVE = Collections.unmodifiableSet(VALID_MESSAGE_STATUS_SET_REMOVE_DEJA_VU);
    }

    private final MessageAttachmentInfoMaintainService messageAttachmentInfoMaintainService;
    private final MessageMaintainService messageMaintainService;

    private final FtpHandler ftpHandler;

    private final KeyGenerator<LongIdKey> keyGenerator;

    private final OperateHandlerValidator operateHandlerValidator;

    public MessageAttachmentOperateHandlerImpl(
            MessageAttachmentInfoMaintainService messageAttachmentInfoMaintainService,
            MessageMaintainService messageMaintainService,
            FtpHandler ftpHandler,
            KeyGenerator<LongIdKey> keyGenerator,
            OperateHandlerValidator operateHandlerValidator
    ) {
        this.messageAttachmentInfoMaintainService = messageAttachmentInfoMaintainService;
        this.messageMaintainService = messageMaintainService;
        this.ftpHandler = ftpHandler;
        this.keyGenerator = keyGenerator;
        this.operateHandlerValidator = operateHandlerValidator;
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public MessageAttachment download(StringIdKey userKey, LongIdKey messageAttachmentKey)
            throws HandlerException {
        try {
            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认留言附件存在。
            operateHandlerValidator.makeSureMessageAttachmentExists(messageAttachmentKey);
            // 确认留言存在。
            MessageAttachmentInfo messageAttachmentInfo = messageAttachmentInfoMaintainService.get(
                    messageAttachmentKey
            );
            LongIdKey messageKey = messageAttachmentInfo.getMessageKey();
            operateHandlerValidator.makeSureMessageExists(messageKey);
            // 确认操作用户是消息发送人或消息接收人。
            Message message = messageMaintainService.get(messageKey);
            StringIdKey sendUserKey = message.getSendUserKey();
            StringIdKey receiveUserKey = message.getReceiveUserKey();
            Set<StringIdKey> validUserKeys = new HashSet<>();
            Optional.ofNullable(sendUserKey).ifPresent(validUserKeys::add);
            Optional.ofNullable(receiveUserKey).ifPresent(validUserKeys::add);
            operateHandlerValidator.makeSureUserMatch(userKey, validUserKeys);
            // 确认消息状态合法。
            operateHandlerValidator.makeSureMessageStatusMatch(messageKey, VALID_MESSAGE_STATUS_SET_DOWNLOAD);

            // 下载留言附件。
            byte[] content = ftpHandler.retrieveFile(
                    FtpConstants.PATH_MESSAGE_ATTACHMENT, getFileName(messageAttachmentKey)
            );

            // 拼接 MessageAttachment 并返回。
            return new MessageAttachment(messageAttachmentInfo.getOriginName(), content);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public MessageAttachmentStream downloadStream(StringIdKey userKey, LongIdKey messageAttachmentKey)
            throws HandlerException {
        try {
            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认留言附件存在。
            operateHandlerValidator.makeSureMessageAttachmentExists(messageAttachmentKey);
            // 确认留言存在。
            MessageAttachmentInfo messageAttachmentInfo = messageAttachmentInfoMaintainService.get(
                    messageAttachmentKey
            );
            LongIdKey messageKey = messageAttachmentInfo.getMessageKey();
            operateHandlerValidator.makeSureMessageExists(messageKey);
            // 确认操作用户是消息发送人或消息接收人。
            Message message = messageMaintainService.get(messageKey);
            StringIdKey sendUserKey = message.getSendUserKey();
            StringIdKey receiveUserKey = message.getReceiveUserKey();
            Set<StringIdKey> validUserKeys = new HashSet<>();
            Optional.ofNullable(sendUserKey).ifPresent(validUserKeys::add);
            Optional.ofNullable(receiveUserKey).ifPresent(validUserKeys::add);
            operateHandlerValidator.makeSureUserMatch(userKey, validUserKeys);
            // 确认消息状态合法。
            operateHandlerValidator.makeSureMessageStatusMatch(messageKey, VALID_MESSAGE_STATUS_SET_DOWNLOAD);

            // 下载留言附件流。
            InputStream content = ftpHandler.openInputStream(
                    FtpConstants.PATH_MESSAGE_ATTACHMENT, getFileName(messageAttachmentKey)
            );

            // 拼接 MessageAttachmentStream 并返回。
            return new MessageAttachmentStream(
                    messageAttachmentInfo.getOriginName(), messageAttachmentInfo.getLength(), content
            );
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @SuppressWarnings({"ExtractMethodRecommender", "DuplicatedCode"})
    @Override
    public void upload(StringIdKey userKey, MessageAttachmentUploadInfo uploadInfo)
            throws HandlerException {
        try {
            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认留言附件所属的留言存在。
            LongIdKey messageKey = uploadInfo.getMessageKey();
            operateHandlerValidator.makeSureMessageExists(messageKey);
            // 确认操作用户是消息发送人。
            Message message = messageMaintainService.get(messageKey);
            StringIdKey sendUserKey = message.getSendUserKey();
            Set<StringIdKey> validUserKeys = new HashSet<>();
            Optional.ofNullable(sendUserKey).ifPresent(validUserKeys::add);
            operateHandlerValidator.makeSureUserMatch(userKey, validUserKeys);
            // 确认消息状态合法。
            operateHandlerValidator.makeSureMessageStatusMatch(messageKey, VALID_MESSAGE_STATUS_SET_UPLOAD);

            // 分配主键。
            LongIdKey messageAttachmentKey = keyGenerator.generate();

            // 留言附件内容并存储（覆盖）。
            byte[] content = uploadInfo.getContent();
            ftpHandler.storeFile(FtpConstants.PATH_MESSAGE_ATTACHMENT, getFileName(messageAttachmentKey), content);

            // 构造留言附件信息。
            Date currentDate = new Date();
            MessageAttachmentInfo messageAttachmentInfo = new MessageAttachmentInfo();
            messageAttachmentInfo.setKey(messageAttachmentKey);
            messageAttachmentInfo.setMessageKey(messageKey);
            messageAttachmentInfo.setOriginName(uploadInfo.getOriginName());
            messageAttachmentInfo.setLength(uploadInfo.getContent().length);
            messageAttachmentInfo.setUploadDate(currentDate);
            messageAttachmentInfo.setRemark("通过 familyhelper-clannad 服务上传/更新留言附件");

            // 调用维护服务插入留言附件信息。
            messageAttachmentInfoMaintainService.insert(messageAttachmentInfo);

            // 更新留言的属性。
            message.setAttachmentCount(message.getAttachmentCount() + 1);

            // 调用维护服务更新留言。
            messageMaintainService.update(message);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @SuppressWarnings({"ExtractMethodRecommender", "DuplicatedCode"})
    @Override
    public void uploadStream(StringIdKey userKey, MessageAttachmentStreamUploadInfo uploadInfo)
            throws HandlerException {
        try {
            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认留言附件所属的留言存在。
            LongIdKey messageKey = uploadInfo.getMessageKey();
            operateHandlerValidator.makeSureMessageExists(messageKey);
            // 确认操作用户是消息发送人。
            Message message = messageMaintainService.get(messageKey);
            StringIdKey sendUserKey = message.getSendUserKey();
            Set<StringIdKey> validUserKeys = new HashSet<>();
            Optional.ofNullable(sendUserKey).ifPresent(validUserKeys::add);
            operateHandlerValidator.makeSureUserMatch(userKey, validUserKeys);
            // 确认消息状态合法。
            operateHandlerValidator.makeSureMessageStatusMatch(messageKey, VALID_MESSAGE_STATUS_SET_UPLOAD);

            // 分配主键。
            LongIdKey messageAttachmentKey = keyGenerator.generate();

            // 留言附件内容并存储（覆盖）。
            InputStream cin = uploadInfo.getContent();
            try (OutputStream fout = ftpHandler.openOutputStream(
                    FtpConstants.PATH_MESSAGE_ATTACHMENT, getFileName(messageAttachmentKey)
            )) {
                IOUtil.trans(cin, fout, Constants.IO_TRANS_BUFFER_SIZE);
            }

            // 构造 MessageAttachmentInfo，插入或更新。
            Date currentDate = new Date();
            MessageAttachmentInfo messageAttachmentInfo = new MessageAttachmentInfo();
            messageAttachmentInfo.setKey(messageAttachmentKey);
            messageAttachmentInfo.setMessageKey(messageKey);
            messageAttachmentInfo.setOriginName(uploadInfo.getOriginName());
            messageAttachmentInfo.setLength(uploadInfo.getLength());
            messageAttachmentInfo.setUploadDate(currentDate);
            messageAttachmentInfo.setRemark("通过 familyhelper-clannad 服务上传/更新留言附件");

            // 调用维护服务插入留言附件信息。
            messageAttachmentInfoMaintainService.insert(messageAttachmentInfo);

            // 更新留言的属性。
            message.setAttachmentCount(message.getAttachmentCount() + 1);

            // 调用维护服务更新留言。
            messageMaintainService.update(message);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void update(StringIdKey userKey, MessageAttachmentUpdateInfo updateInfo) throws HandlerException {
        try {
            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认留言附件信息存在。
            LongIdKey messageAttachmentKey = updateInfo.getMessageAttachmentInfoKey();
            operateHandlerValidator.makeSureMessageAttachmentExists(messageAttachmentKey);
            // 确认留言存在。
            MessageAttachmentInfo messageAttachmentInfo = messageAttachmentInfoMaintainService.get(
                    messageAttachmentKey
            );
            LongIdKey messageKey = messageAttachmentInfo.getMessageKey();
            operateHandlerValidator.makeSureMessageExists(messageKey);
            // 确认操作用户是消息发送人。
            Message message = messageMaintainService.get(messageKey);
            StringIdKey sendUserKey = message.getSendUserKey();
            Set<StringIdKey> validUserKeys = new HashSet<>();
            Optional.ofNullable(sendUserKey).ifPresent(validUserKeys::add);
            operateHandlerValidator.makeSureUserMatch(userKey, validUserKeys);
            // 确认消息状态合法。
            operateHandlerValidator.makeSureMessageStatusMatch(messageKey, VALID_MESSAGE_STATUS_SET_UPDATE);

            // 留言附件内容并存储（覆盖）。
            byte[] content = updateInfo.getContent();
            ftpHandler.storeFile(FtpConstants.PATH_MESSAGE_ATTACHMENT, getFileName(messageAttachmentKey), content);

            // 更新留言附件信息。
            Date currentDate = new Date();
            messageAttachmentInfo.setOriginName(updateInfo.getOriginName());
            messageAttachmentInfo.setLength(updateInfo.getContent().length);
            messageAttachmentInfo.setUploadDate(currentDate);
            messageAttachmentInfo.setRemark("通过 familyhelper-clannad 服务上传/更新留言附件");

            // 调用维护服务更新留言附件信息。
            messageAttachmentInfoMaintainService.update(messageAttachmentInfo);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void updateStream(StringIdKey userKey, MessageAttachmentStreamUpdateInfo updateInfo)
            throws HandlerException {
        try {
            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认留言附件信息存在。
            LongIdKey messageAttachmentKey = updateInfo.getMessageAttachmentInfoKey();
            operateHandlerValidator.makeSureMessageAttachmentExists(messageAttachmentKey);
            // 确认留言存在。
            MessageAttachmentInfo messageAttachmentInfo = messageAttachmentInfoMaintainService.get(
                    messageAttachmentKey
            );
            LongIdKey messageKey = messageAttachmentInfo.getMessageKey();
            operateHandlerValidator.makeSureMessageExists(messageKey);
            // 确认操作用户是消息发送人。
            Message message = messageMaintainService.get(messageKey);
            StringIdKey sendUserKey = message.getSendUserKey();
            Set<StringIdKey> validUserKeys = new HashSet<>();
            Optional.ofNullable(sendUserKey).ifPresent(validUserKeys::add);
            operateHandlerValidator.makeSureUserMatch(userKey, validUserKeys);
            // 确认消息状态合法。
            operateHandlerValidator.makeSureMessageStatusMatch(messageKey, VALID_MESSAGE_STATUS_SET_UPDATE);

            // 留言附件内容并存储（覆盖）。
            InputStream cin = updateInfo.getContent();
            try (OutputStream fout = ftpHandler.openOutputStream(
                    FtpConstants.PATH_MESSAGE_ATTACHMENT, getFileName(messageAttachmentKey)
            )) {
                IOUtil.trans(cin, fout, Constants.IO_TRANS_BUFFER_SIZE);
            }

            // 更新留言附件信息。
            Date currentDate = new Date();
            messageAttachmentInfo.setOriginName(updateInfo.getOriginName());
            messageAttachmentInfo.setLength(updateInfo.getLength());
            messageAttachmentInfo.setUploadDate(currentDate);
            messageAttachmentInfo.setRemark("通过 familyhelper-clannad 服务上传/更新留言附件");

            // 调用维护服务更新留言附件信息。
            messageAttachmentInfoMaintainService.update(messageAttachmentInfo);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void remove(StringIdKey userKey, LongIdKey messageAttachmentKey) throws HandlerException {
        try {
            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认留言附件存在。
            operateHandlerValidator.makeSureMessageAttachmentExists(messageAttachmentKey);
            // 确认留言存在。
            MessageAttachmentInfo messageAttachmentInfo = messageAttachmentInfoMaintainService.get(
                    messageAttachmentKey
            );
            LongIdKey messageKey = messageAttachmentInfo.getMessageKey();
            operateHandlerValidator.makeSureMessageExists(messageKey);
            // 确认操作用户是消息发送人。
            Message message = messageMaintainService.get(messageKey);
            StringIdKey sendUserKey = message.getSendUserKey();
            Set<StringIdKey> validUserKeys = new HashSet<>();
            Optional.ofNullable(sendUserKey).ifPresent(validUserKeys::add);
            operateHandlerValidator.makeSureUserMatch(userKey, validUserKeys);
            // 确认消息状态合法。
            operateHandlerValidator.makeSureMessageStatusMatch(messageKey, VALID_MESSAGE_STATUS_SET_REMOVE);

            // 如果存在 MessageAttachment 文件，则删除。
            if (ftpHandler.existsFile(FtpConstants.PATH_MESSAGE_ATTACHMENT, getFileName(messageAttachmentKey))) {
                ftpHandler.deleteFile(FtpConstants.PATH_MESSAGE_ATTACHMENT, getFileName(messageAttachmentKey));
            }

            // 调用维护服务删除留言附件信息。
            messageAttachmentInfoMaintainService.delete(messageAttachmentKey);

            // 更新留言的属性。
            message.setAttachmentCount(message.getAttachmentCount() - 1);

            // 调用维护服务更新留言。
            messageMaintainService.update(message);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    private String getFileName(LongIdKey messageAttachmentKey) {
        return Long.toString(messageAttachmentKey.getLongId());
    }
}
