package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.GenderTypeIndicator;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;
import org.hibernate.validator.constraints.Length;

/**
 * WebInput 性别类型指示器。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputGenderTypeIndicator implements Bean {

    private static final long serialVersionUID = 2032494518061107180L;

    public static GenderTypeIndicator toStackBean(WebInputGenderTypeIndicator webInputGenderTypeIndicator) {
        return new GenderTypeIndicator(
                WebInputStringIdKey.toStackBean(webInputGenderTypeIndicator.getKey()),
                webInputGenderTypeIndicator.getLabel(),
                webInputGenderTypeIndicator.getRemark()
        );
    }

    @JSONField(name = "key")
    private WebInputStringIdKey key;

    @JSONField(name = "label")
    @Length(max = Constraints.LENGTH_LABEL)
    private String label;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputGenderTypeIndicator() {
    }

    public WebInputStringIdKey getKey() {
        return key;
    }

    public void setKey(WebInputStringIdKey key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "WebInputGenderTypeIndicator{" +
                "key=" + key +
                ", label='" + label + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
