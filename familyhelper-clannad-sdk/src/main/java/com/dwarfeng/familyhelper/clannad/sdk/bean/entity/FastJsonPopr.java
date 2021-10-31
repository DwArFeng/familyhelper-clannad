package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.FastJsonPoprKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Popr;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.Objects;

/**
 * FastJson 个人简介权限。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class FastJsonPopr implements Dto {

    private static final long serialVersionUID = -7740857792930043362L;

    public static FastJsonPopr of(Popr popr) {
        if (Objects.isNull(popr)) {
            return null;
        } else {
            return new FastJsonPopr(FastJsonPoprKey.of(popr.getKey()), popr.getRemark());
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonPoprKey key;

    @JSONField(name = "remark", ordinal = 2)
    private String remark;

    public FastJsonPopr() {
    }

    public FastJsonPopr(FastJsonPoprKey key, String remark) {
        this.key = key;
        this.remark = remark;
    }

    public FastJsonPoprKey getKey() {
        return key;
    }

    public void setKey(FastJsonPoprKey key) {
        this.key = key;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "FastJsonPopr{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
