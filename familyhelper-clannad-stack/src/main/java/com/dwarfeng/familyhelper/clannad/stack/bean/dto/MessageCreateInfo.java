package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 留言创建信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageCreateInfo implements Dto {

    private static final long serialVersionUID = -5360871151523791808L;

    private StringIdKey receiveUserKey;
    private String subject;
    private String remark;

    public MessageCreateInfo() {
    }

    public MessageCreateInfo(StringIdKey receiveUserKey, String subject, String remark) {
        this.receiveUserKey = receiveUserKey;
        this.subject = subject;
        this.remark = remark;
    }

    public StringIdKey getReceiveUserKey() {
        return receiveUserKey;
    }

    public void setReceiveUserKey(StringIdKey receiveUserKey) {
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
        return "MessageCreateInfo{" +
                "receiveUserKey=" + receiveUserKey +
                ", subject='" + subject + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
