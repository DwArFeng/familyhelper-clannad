package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifySetting;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 通知设置。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class WebInputNotifySetting implements Bean {

    private static final long serialVersionUID = 8057511661163145407L;

    public static NotifySetting toStackBean(WebInputNotifySetting webInputNotifySetting) {
        if (Objects.isNull(webInputNotifySetting)) {
            return null;
        } else {
            return new NotifySetting(
                    WebInputLongIdKey.toStackBean(webInputNotifySetting.getKey()),
                    webInputNotifySetting.getRemark()
            );
        }
    }

    @JSONField(name = "key")
    @Valid
    private WebInputLongIdKey key;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputNotifySetting() {
    }

    public WebInputLongIdKey getKey() {
        return key;
    }

    public void setKey(WebInputLongIdKey key) {
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
        return "WebInputNotifySetting{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
