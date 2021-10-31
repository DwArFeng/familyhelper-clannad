package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.WebInputPoprKey;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Popr;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import java.util.Objects;

/**
 * FastJson 个人简介权限。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class WebInputPopr implements Dto {

    private static final long serialVersionUID = -4325350897755010502L;

    public static Popr toStackBean(WebInputPopr webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new Popr(WebInputPoprKey.toStackBean(webInput.getKey()), webInput.getRemark());
        }
    }

    @JSONField(name = "key")
    @Valid
    private WebInputPoprKey key;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputPopr() {
    }

    public WebInputPoprKey getKey() {
        return key;
    }

    public void setKey(WebInputPoprKey key) {
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
        return "WebInputPopr{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
