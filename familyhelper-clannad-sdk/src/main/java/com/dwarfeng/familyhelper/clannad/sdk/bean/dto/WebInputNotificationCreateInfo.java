package com.dwarfeng.familyhelper.clannad.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.NotificationCreateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 通知创建信息。
 *
 * @author DwArFeng
 * @since 1.2.2
 */
public class WebInputNotificationCreateInfo implements Dto {

    private static final long serialVersionUID = -3275872095989262076L;

    public static NotificationCreateInfo toStackBean(WebInputNotificationCreateInfo webInputNotificationCreateInfo) {
        if (Objects.isNull(webInputNotificationCreateInfo)) {
            return null;
        } else {
            return new NotificationCreateInfo(
                    WebInputStringIdKey.toStackBean(webInputNotificationCreateInfo.getUserKey()),
                    webInputNotificationCreateInfo.getRemark(), webInputNotificationCreateInfo.getSubject(),
                    webInputNotificationCreateInfo.getBody()
            );
        }
    }

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    @JSONField(name = "subject")
    @Length(max = Constraints.LENGTH_SUBJECT)
    private String subject;

    @JSONField(name = "body")
    private String body;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputNotificationCreateInfo() {
    }

    public WebInputNotificationCreateInfo(WebInputStringIdKey userKey, String subject, String body, String remark) {
        this.userKey = userKey;
        this.subject = subject;
        this.body = body;
        this.remark = remark;
    }

    public WebInputStringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(WebInputStringIdKey userKey) {
        this.userKey = userKey;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "WebInputNotificationCreateInfo{" +
                "userKey=" + userKey +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
