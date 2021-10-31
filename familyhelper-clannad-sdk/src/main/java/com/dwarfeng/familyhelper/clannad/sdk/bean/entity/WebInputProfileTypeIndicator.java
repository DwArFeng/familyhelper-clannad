package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.WebInputProfileTypeIndicatorKey;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.ProfileTypeIndicator;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 个人简介类型指示器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class WebInputProfileTypeIndicator implements Dto {

    private static final long serialVersionUID = 7328073240436535739L;

    public static ProfileTypeIndicator toStackBean(WebInputProfileTypeIndicator webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ProfileTypeIndicator(
                    WebInputProfileTypeIndicatorKey.toStackBean(webInput.getKey()), webInput.getLabel(),
                    webInput.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    @Valid
    private WebInputProfileTypeIndicatorKey key;

    @JSONField(name = "label", ordinal = 2)
    @NotNull
    @NotEmpty
    @Length(max = Constraints.LENGTH_LABEL)
    private String label;

    @JSONField(name = "remark", ordinal = 3)
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputProfileTypeIndicator() {
    }

    public WebInputProfileTypeIndicatorKey getKey() {
        return key;
    }

    public void setKey(WebInputProfileTypeIndicatorKey key) {
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
        return "WebInputProfileTypeIndicator{" +
                "key=" + key +
                ", label='" + label + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
