package com.dwarfeng.familyhelper.clannad.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageRemoveInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 留言删除信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class WebInputMessageRemoveInfo implements Dto {

    private static final long serialVersionUID = -2417747473364209735L;

    public static MessageRemoveInfo toStackBean(WebInputMessageRemoveInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new MessageRemoveInfo(
                    WebInputLongIdKey.toStackBean(webInput.getMessageKey())
            );
        }
    }

    @JSONField(name = "message_key")
    @NotNull
    @Valid
    private WebInputLongIdKey messageKey;

    public WebInputMessageRemoveInfo() {
    }

    public WebInputLongIdKey getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(WebInputLongIdKey messageKey) {
        this.messageKey = messageKey;
    }

    @Override
    public String toString() {
        return "WebInputMessageRemoveInfo{" +
                "messageKey=" + messageKey +
                '}';
    }
}
