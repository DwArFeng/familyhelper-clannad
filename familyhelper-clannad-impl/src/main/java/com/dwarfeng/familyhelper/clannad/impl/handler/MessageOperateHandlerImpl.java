package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.familyhelper.clannad.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constants;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Message;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageBodyInfo;
import com.dwarfeng.familyhelper.clannad.stack.handler.MessageOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageBodyInfoMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageMaintainService;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.generation.KeyGenerator;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MessageOperateHandlerImpl implements MessageOperateHandler {

    private static final Set<Integer> VALID_MESSAGE_STATUS_SET_UPDATE;
    private static final Set<Integer> VALID_MESSAGE_STATUS_SET_REMOVE;
    private static final Set<Integer> VALID_MESSAGE_STATUS_SET_MARK_SENT;
    private static final Set<Integer> VALID_MESSAGE_STATUS_SET_MARK_RECEIVED;
    private static final Set<Integer> VALID_MESSAGE_STATUS_SET_MARK_RECEIVE_USER_HIDE;

    static {
        Set<Integer> VALID_MESSAGE_STATUS_SET_UPDATE_DEJA_VU = new HashSet<>();
        VALID_MESSAGE_STATUS_SET_UPDATE_DEJA_VU.add(Constants.MESSAGE_STATUS_EDITING);
        VALID_MESSAGE_STATUS_SET_UPDATE = Collections.unmodifiableSet(VALID_MESSAGE_STATUS_SET_UPDATE_DEJA_VU);

        Set<Integer> VALID_MESSAGE_STATUS_SET_REMOVE_DEJA_VU = new HashSet<>();
        VALID_MESSAGE_STATUS_SET_REMOVE_DEJA_VU.add(Constants.MESSAGE_STATUS_EDITING);
        VALID_MESSAGE_STATUS_SET_REMOVE_DEJA_VU.add(Constants.MESSAGE_STATUS_SENT);
        VALID_MESSAGE_STATUS_SET_REMOVE_DEJA_VU.add(Constants.MESSAGE_STATUS_RECEIVED);
        VALID_MESSAGE_STATUS_SET_REMOVE = Collections.unmodifiableSet(VALID_MESSAGE_STATUS_SET_REMOVE_DEJA_VU);

        Set<Integer> VALID_MESSAGE_STATUS_SET_MARK_SENT_DEJA_VU = new HashSet<>();
        VALID_MESSAGE_STATUS_SET_MARK_SENT_DEJA_VU.add(Constants.MESSAGE_STATUS_EDITING);
        VALID_MESSAGE_STATUS_SET_MARK_SENT = Collections.unmodifiableSet(VALID_MESSAGE_STATUS_SET_MARK_SENT_DEJA_VU);

        Set<Integer> VALID_MESSAGE_STATUS_SET_MARK_RECEIVED_DEJA_VU = new HashSet<>();
        VALID_MESSAGE_STATUS_SET_MARK_RECEIVED_DEJA_VU.add(Constants.MESSAGE_STATUS_SENT);
        VALID_MESSAGE_STATUS_SET_MARK_RECEIVED = Collections.unmodifiableSet(
                VALID_MESSAGE_STATUS_SET_MARK_RECEIVED_DEJA_VU
        );

        Set<Integer> VALID_MESSAGE_STATUS_SET_MARK_RECEIVE_USER_HIDE_DEJA_VU = new HashSet<>();
        VALID_MESSAGE_STATUS_SET_MARK_RECEIVE_USER_HIDE_DEJA_VU.add(Constants.MESSAGE_STATUS_SENT);
        VALID_MESSAGE_STATUS_SET_MARK_RECEIVE_USER_HIDE_DEJA_VU.add(Constants.MESSAGE_STATUS_RECEIVED);
        VALID_MESSAGE_STATUS_SET_MARK_RECEIVE_USER_HIDE = Collections.unmodifiableSet(
                VALID_MESSAGE_STATUS_SET_MARK_RECEIVE_USER_HIDE_DEJA_VU
        );
    }

    private final MessageMaintainService messageMaintainService;
    private final MessageBodyInfoMaintainService messageBodyInfoMaintainService;

    private final FtpHandler ftpHandler;

    private final KeyGenerator<LongIdKey> keyGenerator;

    private final OperateHandlerValidator operateHandlerValidator;

    public MessageOperateHandlerImpl(
            MessageMaintainService messageMaintainService,
            MessageBodyInfoMaintainService messageBodyInfoMaintainService,
            FtpHandler ftpHandler,
            KeyGenerator<LongIdKey> keyGenerator,
            OperateHandlerValidator operateHandlerValidator
    ) {
        this.messageMaintainService = messageMaintainService;
        this.messageBodyInfoMaintainService = messageBodyInfoMaintainService;
        this.ftpHandler = ftpHandler;
        this.keyGenerator = keyGenerator;
        this.operateHandlerValidator = operateHandlerValidator;
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public LongIdKey create(MessageCreateInfo info, StringIdKey operateUserKey) throws HandlerException {
        try {
            // 展开参数。
            StringIdKey receiveUserKey = info.getReceiveUserKey();
            String subject = info.getSubject();
            String remark = info.getRemark();

            // 确认用户存在。
            if (Objects.nonNull(receiveUserKey)) {
                operateHandlerValidator.makeSureUserExists(receiveUserKey);
            }
            operateHandlerValidator.makeSureUserExists(operateUserKey);
            // 确认操作用户有权向接收用户发送消息。
            if (Objects.nonNull(receiveUserKey)) {
                operateHandlerValidator.makeSureMessageAuthorizedToSend(operateUserKey, receiveUserKey);
            }

            // 分配消息主键。
            LongIdKey messageKey = keyGenerator.generate();

            // 获取当前日期。
            Date currentDate = new Date();

            // 创建消息实体。
            Message message = new Message(
                    messageKey, operateUserKey, receiveUserKey, subject, remark, Constants.MESSAGE_STATUS_EDITING,
                    null, null, 0, new Date(), false
            );

            // 调用维护服务插入消息。
            messageMaintainService.insert(message);

            // 创建消息正文信息实体。
            MessageBodyInfo messageBodyInfo = new MessageBodyInfo(
                    messageKey, 0, currentDate, "通过 familyhelper-clannad 服务上传/更新留言正文"
            );

            // 调用维护服务插入消息正文信息。
            messageBodyInfoMaintainService.insert(messageBodyInfo);

            // 向 FTP 上传消息正文信息对应的空文件。
            ftpHandler.storeFile(FtpConstants.PATH_MESSAGE_BODY, getFileName(messageKey), new byte[0]);

            // 返回消息主键。
            return messageKey;
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    private String getFileName(LongIdKey certificateFileKey) {
        return Long.toString(certificateFileKey.getLongId());
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void update(MessageUpdateInfo info, StringIdKey operateUserKey) throws HandlerException {
        try {
            // 展开参数。
            LongIdKey messageKey = info.getMessageKey();
            StringIdKey receiveUserKey = info.getReceiveUserKey();
            String subject = info.getSubject();
            String remark = info.getRemark();

            // 确认用户存在。
            if (Objects.nonNull(receiveUserKey)) {
                operateHandlerValidator.makeSureUserExists(receiveUserKey);
            }
            operateHandlerValidator.makeSureUserExists(operateUserKey);
            // 确认操作用户有权向接收用户发送消息。
            if (Objects.nonNull(receiveUserKey)) {
                operateHandlerValidator.makeSureMessageAuthorizedToSend(operateUserKey, receiveUserKey);
            }
            // 确认消息存在。
            operateHandlerValidator.makeSureMessageExists(messageKey);
            // 确认操作用户是消息发送人。
            Message message = messageMaintainService.get(messageKey);
            StringIdKey sendUserKey = message.getSendUserKey();
            Set<StringIdKey> validUserKeys = new HashSet<>();
            Optional.ofNullable(sendUserKey).ifPresent(validUserKeys::add);
            operateHandlerValidator.makeSureUserMatch(operateUserKey, validUserKeys);
            // 确认消息状态合法。
            operateHandlerValidator.makeSureMessageStatusMatch(messageKey, VALID_MESSAGE_STATUS_SET_UPDATE);

            // 获取消息实体，并更新。
            message.setReceiveUserKey(receiveUserKey);
            message.setSubject(subject);
            message.setRemark(remark);

            // 调用维护服务更新消息。
            messageMaintainService.update(message);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void remove(MessageRemoveInfo info, StringIdKey operateUserKey) throws HandlerException {
        try {
            // 展开参数。
            LongIdKey messageKey = info.getMessageKey();

            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(operateUserKey);
            // 确认消息存在。
            operateHandlerValidator.makeSureMessageExists(messageKey);
            // 确认操作用户是消息发送人。
            Message message = messageMaintainService.get(messageKey);
            StringIdKey sendUserKey = message.getSendUserKey();
            Set<StringIdKey> validUserKeys = new HashSet<>();
            Optional.ofNullable(sendUserKey).ifPresent(validUserKeys::add);
            operateHandlerValidator.makeSureUserMatch(operateUserKey, validUserKeys);
            // 确认消息状态合法。
            operateHandlerValidator.makeSureMessageStatusMatch(messageKey, VALID_MESSAGE_STATUS_SET_REMOVE);

            // 调用维护服务删除消息。
            messageMaintainService.delete(messageKey);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void markSent(MessageMarkSentInfo info, StringIdKey operateUserKey) throws HandlerException {
        try {
            // 展开参数。
            LongIdKey messageKey = info.getMessageKey();

            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(operateUserKey);
            // 确认消息存在。
            operateHandlerValidator.makeSureMessageExists(messageKey);
            // 确认操作用户是消息发送人。
            Message message = messageMaintainService.get(messageKey);
            StringIdKey sendUserKey = message.getSendUserKey();
            Set<StringIdKey> validUserKeys = new HashSet<>();
            Optional.ofNullable(sendUserKey).ifPresent(validUserKeys::add);
            operateHandlerValidator.makeSureUserMatch(operateUserKey, validUserKeys);
            // 确认消息状态合法。
            operateHandlerValidator.makeSureMessageStatusMatch(messageKey, VALID_MESSAGE_STATUS_SET_MARK_SENT);
            // 确认消息接收人存在。
            StringIdKey receiveUserKey = message.getReceiveUserKey();
            operateHandlerValidator.makeSureUserExists(receiveUserKey);
            // 确认操作用户有权向接收用户发送消息。
            operateHandlerValidator.makeSureMessageAuthorizedToSend(operateUserKey, receiveUserKey);

            // 获取当前日期。
            Date currentDate = new Date();

            // 更新消息实体。
            message.setStatus(Constants.MESSAGE_STATUS_SENT);
            message.setSentDate(currentDate);

            // 调用维护服务更新消息。
            messageMaintainService.update(message);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void markReceived(MessageMarkReceivedInfo info, StringIdKey operateUserKey) throws HandlerException {
        try {
            // 展开参数。
            LongIdKey messageKey = info.getMessageKey();

            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(operateUserKey);
            // 确认消息存在。
            operateHandlerValidator.makeSureMessageExists(messageKey);
            // 确认操作用户是消息接收人。
            Message message = messageMaintainService.get(messageKey);
            StringIdKey receiveUserKey = message.getReceiveUserKey();
            Set<StringIdKey> validUserKeys = new HashSet<>();
            Optional.ofNullable(receiveUserKey).ifPresent(validUserKeys::add);
            operateHandlerValidator.makeSureUserMatch(operateUserKey, validUserKeys);
            // 确认消息状态合法。
            operateHandlerValidator.makeSureMessageStatusMatch(messageKey, VALID_MESSAGE_STATUS_SET_MARK_RECEIVED);

            // 获取当前日期。
            Date currentDate = new Date();

            // 更新消息实体。
            message.setStatus(Constants.MESSAGE_STATUS_RECEIVED);
            message.setReceivedDate(currentDate);

            // 调用维护服务更新消息。
            messageMaintainService.update(message);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void markReceiveUserHide(MessageMarkReceiveUserHideInfo info, StringIdKey operateUserKey) throws HandlerException {
        try {
            // 展开参数。
            LongIdKey messageKey = info.getMessageKey();

            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(operateUserKey);
            // 确认消息存在。
            operateHandlerValidator.makeSureMessageExists(messageKey);
            // 确认操作用户是消息接收人。
            Message message = messageMaintainService.get(messageKey);
            StringIdKey receiveUserKey = message.getReceiveUserKey();
            Set<StringIdKey> validUserKeys = new HashSet<>();
            Optional.ofNullable(receiveUserKey).ifPresent(validUserKeys::add);
            operateHandlerValidator.makeSureUserMatch(operateUserKey, validUserKeys);
            // 确认消息状态合法。
            operateHandlerValidator.makeSureMessageStatusMatch(
                    messageKey, VALID_MESSAGE_STATUS_SET_MARK_RECEIVE_USER_HIDE
            );

            // 获取当前日期。
            Date currentDate = new Date();

            // 更新消息实体。
            message.setStatus(Constants.MESSAGE_STATUS_RECEIVED);
            if (Objects.isNull(message.getReceivedDate())) {
                message.setReceivedDate(currentDate);
            }
            message.setReceiveUserHide(true);

            // 调用维护服务更新消息。
            messageMaintainService.update(message);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }
}
