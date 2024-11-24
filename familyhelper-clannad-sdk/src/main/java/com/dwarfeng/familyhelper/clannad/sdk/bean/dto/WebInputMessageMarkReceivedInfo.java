package com.dwarfeng.familyhelper.clannad.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageMarkReceivedInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 留言标记已接收信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class WebInputMessageMarkReceivedInfo implements Dto {

    private static final long serialVersionUID = 2976623103637415626L;

    public static MessageMarkReceivedInfo toStackBean(WebInputMessageMarkReceivedInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new MessageMarkReceivedInfo(
                    WebInputLongIdKey.toStackBean(webInput.getMessageKey())
            );
        }
    }

    @JSONField(name = "message_key")
    @NotNull
    @Valid
    private WebInputLongIdKey messageKey;

    public WebInputMessageMarkReceivedInfo() {
    }

    public WebInputLongIdKey getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(WebInputLongIdKey messageKey) {
        this.messageKey = messageKey;
    }

    @Override
    public String toString() {
        return "WebInputMessageMarkReceivedInfo{" +
                "messageKey=" + messageKey +
                '}';
    }
}
