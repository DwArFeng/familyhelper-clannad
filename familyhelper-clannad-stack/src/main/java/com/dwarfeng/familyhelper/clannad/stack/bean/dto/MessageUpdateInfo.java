package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 留言更新信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageUpdateInfo implements Dto {

    private static final long serialVersionUID = -7199198700816918465L;

    private LongIdKey messageKey;
    private StringIdKey receiveUserKey;
    private String subject;
    private String remark;

    public MessageUpdateInfo() {
    }

    public MessageUpdateInfo(LongIdKey messageKey, StringIdKey receiveUserKey, String subject, String remark) {
        this.messageKey = messageKey;
        this.receiveUserKey = receiveUserKey;
        this.subject = subject;
        this.remark = remark;
    }

    public LongIdKey getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(LongIdKey messageKey) {
        this.messageKey = messageKey;
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
        return "MessageUpdateInfo{" +
                "messageKey=" + messageKey +
                ", receiveUserKey=" + receiveUserKey +
                ", subject='" + subject + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
