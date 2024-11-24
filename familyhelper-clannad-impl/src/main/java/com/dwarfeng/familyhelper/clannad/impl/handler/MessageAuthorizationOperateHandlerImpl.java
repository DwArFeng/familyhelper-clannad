package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageAuthorizationCreateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageAuthorizationRemoveInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageAuthorizationUpdateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageAuthorization;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.familyhelper.clannad.stack.handler.MessageAuthorizationOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageAuthorizationMaintainService;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MessageAuthorizationOperateHandlerImpl implements MessageAuthorizationOperateHandler {

    private final MessageAuthorizationMaintainService messageAuthorizationMaintainService;

    private final OperateHandlerValidator operateHandlerValidator;

    public MessageAuthorizationOperateHandlerImpl(
            MessageAuthorizationMaintainService messageAuthorizationMaintainService,
            OperateHandlerValidator operateHandlerValidator
    ) {
        this.messageAuthorizationMaintainService = messageAuthorizationMaintainService;
        this.operateHandlerValidator = operateHandlerValidator;
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public MessageAuthorizationKey create(MessageAuthorizationCreateInfo info) throws HandlerException {
        try {
            // 展开参数。
            MessageAuthorizationKey key = info.getKey();
            boolean enabled = info.isEnabled();
            String remark = info.getRemark();

            // 确认用户存在。
            StringIdKey receiveUserKey = new StringIdKey(key.getReceiveUserId());
            operateHandlerValidator.makeSureUserExists(receiveUserKey);
            StringIdKey authorizedSendUserKey = new StringIdKey(key.getAuthorizedSendUserId());
            operateHandlerValidator.makeSureUserExists(authorizedSendUserKey);
            // 确认留言授权不存在。
            operateHandlerValidator.makeSureMessageAuthorizationNotExists(key);

            // 构造留言授权实体。
            Date currentDate = new Date();
            MessageAuthorization messageAuthorization = new MessageAuthorization(
                    key, enabled, remark, currentDate
            );

            // 调用维护服务插入实体。
            return messageAuthorizationMaintainService.insert(messageAuthorization);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void update(MessageAuthorizationUpdateInfo info) throws HandlerException {
        try {
            // 展开参数。
            MessageAuthorizationKey key = info.getKey();
            boolean enabled = info.isEnabled();
            String remark = info.getRemark();

            // 确认用户存在。
            StringIdKey receiveUserKey = new StringIdKey(key.getReceiveUserId());
            operateHandlerValidator.makeSureUserExists(receiveUserKey);
            StringIdKey authorizedSendUserKey = new StringIdKey(key.getAuthorizedSendUserId());
            operateHandlerValidator.makeSureUserExists(authorizedSendUserKey);
            // 确认留言授权存在。
            operateHandlerValidator.makeSureMessageAuthorizationExists(key);

            // 获取留言授权实体并更新。
            MessageAuthorization messageAuthorization = messageAuthorizationMaintainService.get(key);
            messageAuthorization.setEnabled(enabled);
            messageAuthorization.setRemark(remark);

            // 调用维护服务更新实体。
            messageAuthorizationMaintainService.update(messageAuthorization);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void remove(MessageAuthorizationRemoveInfo info) throws HandlerException {
        try {
            // 展开参数。
            MessageAuthorizationKey key = info.getKey();

            // 确认留言授权存在。
            operateHandlerValidator.makeSureMessageAuthorizationExists(key);

            // 调用维护服务删除实体。
            messageAuthorizationMaintainService.delete(key);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }
}
