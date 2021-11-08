package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.WebInputNicknameKey;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Nickname;
import com.dwarfeng.subgrade.stack.bean.Bean;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 昵称。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public class WebInputNickname implements Bean {

    private static final long serialVersionUID = -6712649912156946472L;

    public static Nickname toStackBean(WebInputNickname webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new Nickname(
                    WebInputNicknameKey.toStackBean(webInput.getKey()), webInput.getCall(), webInput.getRemark()
            );
        }
    }

    @JSONField(name = "key")
    @Valid
    private WebInputNicknameKey key;

    @JSONField(name = "call")
    @NotNull
    @NotEmpty
    @Length(max = Constraints.LENGTH_NAME)
    private String call;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputNickname() {
    }

    public WebInputNicknameKey getKey() {
        return key;
    }

    public void setKey(WebInputNicknameKey key) {
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
        return "WebInputNickname{" +
                "key=" + key +
                ", call='" + call + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
