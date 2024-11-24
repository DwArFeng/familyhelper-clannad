package com.dwarfeng.familyhelper.clannad.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageUpdateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Optional;

/**
 * WebInput 留言更新信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class WebInputMessageUpdateInfo implements Dto {

    private static final long serialVersionUID = -383261701511923472L;

    public static MessageUpdateInfo toStackBean(WebInputMessageUpdateInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new MessageUpdateInfo(
                    WebInputLongIdKey.toStackBean(webInput.getMessageKey()),
                    Optional.ofNullable(webInput.getReceiveUserKey()).map(WebInputStringIdKey::toStackBean)
                            .orElse(null),
                    webInput.getSubject(),
                    webInput.getRemark()
            );
        }
    }

    @JSONField(name = "message_key")
    @NotNull
    @Valid
    private WebInputLongIdKey messageKey;

    @JSONField(name = "receive_user_key")
    @Valid
    private WebInputStringIdKey receiveUserKey;

    @JSONField(name = "subject")
    @NotNull
    @NotEmpty
    @Length(max = Constraints.LENGTH_SUBJECT)
    private String subject;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputMessageUpdateInfo() {
    }

    public WebInputLongIdKey getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(WebInputLongIdKey messageKey) {
        this.messageKey = messageKey;
    }

    public WebInputStringIdKey getReceiveUserKey() {
        return receiveUserKey;
    }

    public void setReceiveUserKey(WebInputStringIdKey receiveUserKey) {
        this.receiveUserKey = receiveUserKey;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "WebInputMessageUpdateInfo{" +
                "messageKey=" + messageKey +
                ", receiveUserKey=" + receiveUserKey +
                ", subject='" + subject + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
