package com.dwarfeng.familyhelper.clannad.impl.dao.preset;

import com.dwarfeng.familyhelper.clannad.stack.service.NotifyPreferenceMaintainService;
import com.dwarfeng.subgrade.sdk.hibernate.criteria.PresetCriteriaMaker;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class NotifyPreferencePresetCriteriaMaker implements PresetCriteriaMaker {

    @Override
    public void makeCriteria(DetachedCriteria detachedCriteria, String s, Object[] objects) {
        switch (s) {
            case NotifyPreferenceMaintainService.CHILD_FOR_NOTIFY_SETTING:
                childForNotifySetting(detachedCriteria, objects);
                break;
            case NotifyPreferenceMaintainService.CHILD_FOR_NOTIFY_TOPIC:
                childForNotifyTopic(detachedCriteria, objects);
                break;
            case NotifyPreferenceMaintainService.CHILD_FOR_USER:
                childForUser(detachedCriteria, objects);
                break;
            case NotifyPreferenceMaintainService.CHILD_FOR_NOTIFY_SETTING_USER:
                childForNotifySettingUser(detachedCriteria, objects);
                break;
            default:
                throw new IllegalArgumentException("无法识别的预设: " + s);
        }
    }

    private void childForNotifySetting(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("notifySettingId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("notifySettingId", longIdKey.getLongId())
                );
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForNotifyTopic(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("notifyTopicId"));
            } else {
                StringIdKey stringIdKey = (StringIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("notifyTopicId", stringIdKey.getStringId())
                );
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private void childForUser(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("userId"));
            } else {
                StringIdKey stringIdKey = (StringIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("userId", stringIdKey.getStringId())
                );
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForNotifySettingUser(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("notifySettingId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("notifySettingId", longIdKey.getLongId())
                );
            }
            if (Objects.isNull(objects[1])) {
                detachedCriteria.add(Restrictions.isNull("userId"));
            } else {
                StringIdKey stringIdKey = (StringIdKey) objects[1];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("userId", stringIdKey.getStringId())
                );
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }
}
