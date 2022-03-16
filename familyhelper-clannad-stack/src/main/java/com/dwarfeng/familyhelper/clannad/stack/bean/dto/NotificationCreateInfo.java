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

    private static final long serialVersionUID = 1129640692143864310L;

    private StringIdKey userKey;
    private String message;
    private String remark;

    public NotificationCreateInfo() {
    }

    public NotificationCreateInfo(StringIdKey userKey, String message, String remark) {
        this.userKey = userKey;
        this.message = message;
        this.remark = remark;
    }

    public StringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(StringIdKey userKey) {
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
        return "NotificationCreateInfo{" +
                "userKey=" + userKey +
                ", message='" + message + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
