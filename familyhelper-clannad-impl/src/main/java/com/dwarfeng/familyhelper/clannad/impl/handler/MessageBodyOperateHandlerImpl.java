package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.familyhelper.clannad.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constants;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageBody;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageBodyUpdateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Message;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageBodyInfo;
import com.dwarfeng.familyhelper.clannad.stack.handler.MessageBodyOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageBodyInfoMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageMaintainService;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MessageBodyOperateHandlerImpl implements MessageBodyOperateHandler {

    private static final Set<Integer> VALID_MESSAGE_STATUS_SET_DOWNLOAD;
    private static final Set<Integer> VALID_MESSAGE_STATUS_SET_UPDATE;

    static {
        Set<Integer> VALID_MESSAGE_STATUS_SET_DOWNLOAD_DEJA_VU = new HashSet<>();
        VALID_MESSAGE_STATUS_SET_DOWNLOAD_DEJA_VU.add(Constants.MESSAGE_STATUS_EDITING);
        VALID_MESSAGE_STATUS_SET_DOWNLOAD_DEJA_VU.add(Constants.MESSAGE_STATUS_SENT);
        VALID_MESSAGE_STATUS_SET_DOWNLOAD_DEJA_VU.add(Constants.MESSAGE_STATUS_RECEIVED);
        VALID_MESSAGE_STATUS_SET_DOWNLOAD = Collections.unmodifiableSet(VALID_MESSAGE_STATUS_SET_DOWNLOAD_DEJA_VU);

        Set<Integer> VALID_MESSAGE_STATUS_SET_UPDATE_DEJA_VU = new HashSet<>();
        VALID_MESSAGE_STATUS_SET_UPDATE_DEJA_VU.add(Constants.MESSAGE_STATUS_EDITING);
        VALID_MESSAGE_STATUS_SET_UPDATE = Collections.unmodifiableSet(VALID_MESSAGE_STATUS_SET_UPDATE_DEJA_VU);
    }

    private final MessageBodyInfoMaintainService messageBodyInfoMaintainService;
    private final MessageMaintainService messageMaintainService;

    private final FtpHandler ftpHandler;

    private final OperateHandlerValidator operateHandlerValidator;

    public MessageBodyOperateHandlerImpl(
            MessageBodyInfoMaintainService messageBodyInfoMaintainService,
            MessageMaintainService messageMaintainService,
            FtpHandler ftpHandler,
            OperateHandlerValidator operateHandlerValidator
    ) {
        this.messageBodyInfoMaintainService = messageBodyInfoMaintainService;
        this.messageMaintainService = messageMaintainService;
        this.ftpHandler = ftpHandler;
        this.operateHandlerValidator = operateHandlerValidator;
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public MessageBody download(StringIdKey userKey, LongIdKey messageBodyKey)
            throws HandlerException {
        try {
            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认留言正文存在。
            operateHandlerValidator.makeSureMessageBodyExists(messageBodyKey);
            // 确认留言存在。
            operateHandlerValidator.makeSureMessageExists(messageBodyKey);
            // 确认操作用户是消息发送人或消息接收人。
            Message message = messageMaintainService.get(messageBodyKey);
            StringIdKey sendUserKey = message.getSendUserKey();
            StringIdKey receiveUserKey = message.getReceiveUserKey();
            Set<StringIdKey> validUserKeys = new HashSet<>();
            Optional.ofNullable(sendUserKey).ifPresent(validUserKeys::add);
            Optional.ofNullable(receiveUserKey).ifPresent(validUserKeys::add);
            operateHandlerValidator.makeSureUserMatch(userKey, validUserKeys);
            // 确认消息状态合法。
            LongIdKey messageKey = message.getKey();
            operateHandlerValidator.makeSureMessageStatusMatch(messageKey, VALID_MESSAGE_STATUS_SET_DOWNLOAD);

            // 下载留言正文。
            byte[] content = ftpHandler.retrieveFile(
                    FtpConstants.PATH_MESSAGE_BODY, getFileName(messageBodyKey)
            );

            // 拼接 MessageBody 并返回。
            return new MessageBody(messageBodyKey, content);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void update(StringIdKey userKey, MessageBodyUpdateInfo updateInfo) throws HandlerException {
        try {
            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认留言正文信息存在。
            LongIdKey messageBodyKey = updateInfo.getMessageBodyKey();
            operateHandlerValidator.makeSureMessageBodyExists(messageBodyKey);
            // 确认留言存在。
            operateHandlerValidator.makeSureMessageExists(messageBodyKey);
            // 确认操作用户是消息发送人。
            Message message = messageMaintainService.get(messageBodyKey);
            StringIdKey sendUserKey = message.getSendUserKey();
            Set<StringIdKey> validUserKeys = new HashSet<>();
            Optional.ofNullable(sendUserKey).ifPresent(validUserKeys::add);
            operateHandlerValidator.makeSureUserMatch(userKey, validUserKeys);
            // 确认消息状态合法。
            LongIdKey messageKey = message.getKey();
            operateHandlerValidator.makeSureMessageStatusMatch(messageKey, VALID_MESSAGE_STATUS_SET_UPDATE);

            // 留言正文内容并存储（覆盖）。
            byte[] content = updateInfo.getContent();
            ftpHandler.storeFile(FtpConstants.PATH_MESSAGE_BODY, getFileName(messageBodyKey), content);

            // 更新留言正文信息。
            Date currentDate = new Date();
            MessageBodyInfo messageBodyInfo = messageBodyInfoMaintainService.get(messageBodyKey);
            messageBodyInfo.setLength(updateInfo.getContent().length);
            messageBodyInfo.setUploadDate(currentDate);
            messageBodyInfo.setRemark("通过 familyhelper-clannad 服务上传/更新留言正文");

            // 调用维护服务更新留言正文信息。
            messageBodyInfoMaintainService.update(messageBodyInfo);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    private String getFileName(LongIdKey messageBodyKey) {
        return Long.toString(messageBodyKey.getLongId());
    }
}
