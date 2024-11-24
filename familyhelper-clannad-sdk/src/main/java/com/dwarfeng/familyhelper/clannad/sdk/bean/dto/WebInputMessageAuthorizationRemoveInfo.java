package com.dwarfeng.familyhelper.clannad.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.WebInputMessageAuthorizationKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageAuthorizationRemoveInfo;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 留言授权移除信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class WebInputMessageAuthorizationRemoveInfo implements Dto {

    private static final long serialVersionUID = -9045018843954718296L;

    public static MessageAuthorizationRemoveInfo toStackBean(WebInputMessageAuthorizationRemoveInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new MessageAuthorizationRemoveInfo(
                    WebInputMessageAuthorizationKey.toStackBean(webInput.getKey())
            );
        }
    }

    @JSONField(name = "key")
    @NotNull
    @Valid
    private WebInputMessageAuthorizationKey key;

    public WebInputMessageAuthorizationRemoveInfo() {
    }

    public WebInputMessageAuthorizationRemoveInfo(WebInputMessageAuthorizationKey key) {
        this.key = key;
    }

    public WebInputMessageAuthorizationKey getKey() {
        return key;
    }

    public void setKey(WebInputMessageAuthorizationKey key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "WebInputMessageAuthorizationRemoveInfo{" +
                "key=" + key +
                '}';
    }
}
