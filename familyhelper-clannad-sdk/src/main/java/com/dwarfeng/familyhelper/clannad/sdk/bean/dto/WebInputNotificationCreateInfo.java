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

    private static final long serialVersionUID = 600403195325854204L;

    public static NotificationCreateInfo toStackBean(WebInputNotificationCreateInfo webInputNotificationCreateInfo) {
        if (Objects.isNull(webInputNotificationCreateInfo)) {
            return null;
        } else {
            return new NotificationCreateInfo(
                    WebInputStringIdKey.toStackBean(webInputNotificationCreateInfo.getUserKey()),
                    webInputNotificationCreateInfo.getMessage(), webInputNotificationCreateInfo.getRemark()
            );
        }
    }

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    @JSONField(name = "message")
    @Length(max = Constraints.LENGTH_MESSAGE)
    private String message;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputNotificationCreateInfo() {
    }

    public WebInputStringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(WebInputStringIdKey userKey) {
        this.userKey = userKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
                ", message='" + message + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
