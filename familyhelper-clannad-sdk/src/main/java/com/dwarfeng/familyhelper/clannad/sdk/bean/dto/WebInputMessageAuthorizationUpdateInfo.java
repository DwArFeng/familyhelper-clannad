package com.dwarfeng.familyhelper.clannad.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.WebInputMessageAuthorizationKey;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageAuthorizationUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 留言授权更新信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class WebInputMessageAuthorizationUpdateInfo implements Dto {

    private static final long serialVersionUID = -3327196861365198020L;

    public static MessageAuthorizationUpdateInfo toStackBean(WebInputMessageAuthorizationUpdateInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new MessageAuthorizationUpdateInfo(
                    WebInputMessageAuthorizationKey.toStackBean(webInput.getKey()),
                    webInput.isEnabled(),
                    webInput.getRemark()
            );
        }
    }

    @JSONField(name = "key")
    @NotNull
    @Valid
    private WebInputMessageAuthorizationKey key;

    @JSONField(name = "enabled")
    private boolean enabled;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputMessageAuthorizationUpdateInfo() {
    }

    public WebInputMessageAuthorizationUpdateInfo(WebInputMessageAuthorizationKey key, boolean enabled, String remark) {
        this.key = key;
        this.enabled = enabled;
        this.remark = remark;
    }

    public WebInputMessageAuthorizationKey getKey() {
        return key;
    }

    public void setKey(WebInputMessageAuthorizationKey key) {
        this.key = key;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "WebInputMessageAuthorizationUpdateInfo{" +
                "key=" + key +
                ", enabled=" + enabled +
                ", remark='" + remark + '\'' +
                '}';
    }
}
