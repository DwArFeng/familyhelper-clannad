package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.FastJsonNicknameKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Nickname;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 昵称。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public class FastJsonNickname implements Bean {

    private static final long serialVersionUID = -3369529967115745784L;

    public static FastJsonNickname of(Nickname nickname) {
        if (Objects.isNull(nickname)) {
            return null;
        } else {
            return new FastJsonNickname(
                    FastJsonNicknameKey.of(nickname.getKey()), nickname.getCall(), nickname.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonNicknameKey key;

    @JSONField(name = "call", ordinal = 2)
    private String call;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public FastJsonNickname() {
    }

    public FastJsonNickname(FastJsonNicknameKey key, String call, String remark) {
        this.key = key;
        this.call = call;
        this.remark = remark;
    }

    public FastJsonNicknameKey getKey() {
        return key;
    }

    public void setKey(FastJsonNicknameKey key) {
        this.key = key;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "FastJsonNickname{" +
                "key=" + key +
                ", call='" + call + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
