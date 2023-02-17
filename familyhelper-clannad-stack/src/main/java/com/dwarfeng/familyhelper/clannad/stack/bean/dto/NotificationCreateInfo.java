package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 通知创建信息。
 *
 * @author DwArFeng
 * @since 1.2.2
 */
public class NotificationCreateInfo implements Dto {

    private static final long serialVersionUID = 5752791004646882499L;

    private StringIdKey userKey;

    /**
     * @since 1.3.0
     */
    public String subject;

    /**
     * @since 1.3.0
     */
    public String body;

    private String remark;

    public NotificationCreateInfo() {
    }

    public NotificationCreateInfo(StringIdKey userKey, String subject, String body, String remark) {
        this.userKey = userKey;
        this.subject = subject;
        this.body = body;
        this.remark = remark;
    }

    public StringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(StringIdKey userKey) {
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
        return "NotificationCreateInfo{" +
                "userKey=" + userKey +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
