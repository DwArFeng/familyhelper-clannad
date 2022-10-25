package com.dwarfeng.familyhelper.clannad.impl.bean.entity;

import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@IdClass(HibernateStringIdKey.class)
@Table(name = "tbl_notify_topic")
public class HibernateNotifyTopic implements Bean {

    private static final long serialVersionUID = -4534741387207823044L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true, length = Constraints.LENGTH_ID)
    private String stringId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    @Column(name = "preferred")
    private boolean preferred;

    @Column(name = "cool_down_duration")
    private long coolDownDuration;

    // -----------------------------------------------------------一对多-----------------------------------------------------------
    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateNotifyPreference.class, mappedBy = "notifyTopic")
    private Set<HibernateNotifyPreference> notifyPreferences = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateNotifyMeta.class, mappedBy = "notifyTopic")
    private Set<HibernateNotifyMeta> notifyMetas = new HashSet<>();

    public HibernateNotifyTopic() {
    }

    // -----------------------------------------------------------映射用 getter&setter-----------------------------------------------------------
    public HibernateStringIdKey getKey() {
        return Optional.ofNullable(stringId).map(HibernateStringIdKey::new).orElse(null);
    }

    public void setKey(HibernateStringIdKey key) {
        this.stringId = Optional.ofNullable(key).map(HibernateStringIdKey::getStringId).orElse(null);
    }

    // -----------------------------------------------------------常规 getter&setter-----------------------------------------------------------
    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isPreferred() {
        return preferred;
    }

    public void setPreferred(boolean preferred) {
        this.preferred = preferred;
    }

    public long getCoolDownDuration() {
        return coolDownDuration;
    }

    public void setCoolDownDuration(long coolDownDuration) {
        this.coolDownDuration = coolDownDuration;
    }

    public Set<HibernateNotifyPreference> getNotifyPreferences() {
        return notifyPreferences;
    }

    public void setNotifyPreferences(Set<HibernateNotifyPreference> notifyPreferences) {
        this.notifyPreferences = notifyPreferences;
    }

    public Set<HibernateNotifyMeta> getNotifyMetas() {
        return notifyMetas;
    }

    public void setNotifyMetas(Set<HibernateNotifyMeta> notifyMetas) {
        this.notifyMetas = notifyMetas;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "stringId = " + stringId + ", " +
                "remark = " + remark + ", " +
                "preferred = " + preferred + ", " +
                "coolDownDuration = " + coolDownDuration + ")";
    }
}
