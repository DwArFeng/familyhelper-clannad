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
    private String remark;

    /**
     * @since 1.3.0
     */
    public String subject;

    /**
     * @since 1.3.0
     */
    public String body;

    public NotificationCreateInfo() {
    }

    public NotificationCreateInfo(StringIdKey userKey, String remark, String subject, String body) {
        this.userKey = userKey;
        this.remark = remark;
        this.subject = subject;
        this.body = body;
    }

    public StringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(StringIdKey userKey) {
        this.userKey = userKey;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    @Override
    public String toString() {
        return "NotificationCreateInfo{" +
                "userKey=" + userKey +
                ", remark='" + remark + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
