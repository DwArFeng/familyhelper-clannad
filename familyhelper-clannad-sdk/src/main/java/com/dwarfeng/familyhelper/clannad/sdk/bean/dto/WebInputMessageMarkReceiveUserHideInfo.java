package com.dwarfeng.familyhelper.clannad.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageMarkReceiveUserHideInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 消息标记接收用户隐藏信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class WebInputMessageMarkReceiveUserHideInfo implements Dto {

    private static final long serialVersionUID = 6294407001152096916L;

    public static MessageMarkReceiveUserHideInfo toStackBean(WebInputMessageMarkReceiveUserHideInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new MessageMarkReceiveUserHideInfo(
                    WebInputLongIdKey.toStackBean(webInput.getMessageKey())
            );
        }
    }

    @JSONField(name = "message_key")
    @NotNull
    @Valid
    private WebInputLongIdKey messageKey;

    public WebInputMessageMarkReceiveUserHideInfo() {
    }

    public WebInputLongIdKey getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(WebInputLongIdKey messageKey) {
        this.messageKey = messageKey;
    }

    @Override
    public String toString() {
        return "WebInputMessageMarkReceiveUserHideInfo{" +
                "messageKey=" + messageKey +
                '}';
    }
}
