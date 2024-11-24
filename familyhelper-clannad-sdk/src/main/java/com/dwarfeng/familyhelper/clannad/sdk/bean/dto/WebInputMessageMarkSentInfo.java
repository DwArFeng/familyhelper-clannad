package com.dwarfeng.familyhelper.clannad.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageMarkSentInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 留言标记已发送信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class WebInputMessageMarkSentInfo implements Dto {

    private static final long serialVersionUID = 9000324046594293783L;

    public static MessageMarkSentInfo toStackBean(WebInputMessageMarkSentInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new MessageMarkSentInfo(
                    WebInputLongIdKey.toStackBean(webInput.getMessageKey())
            );
        }
    }

    @JSONField(name = "message_key")
    @NotNull
    @Valid
    private WebInputLongIdKey messageKey;

    public WebInputMessageMarkSentInfo() {
    }

    public WebInputLongIdKey getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(WebInputLongIdKey messageKey) {
        this.messageKey = messageKey;
    }

    @Override
    public String toString() {
        return "WebInputMessageMarkSentInfo{" +
                "messageKey=" + messageKey +
                '}';
    }
}
