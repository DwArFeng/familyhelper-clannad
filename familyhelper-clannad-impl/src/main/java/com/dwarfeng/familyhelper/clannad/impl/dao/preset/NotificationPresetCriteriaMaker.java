package com.dwarfeng.familyhelper.clannad.impl.dao.preset;

import com.dwarfeng.familyhelper.clannad.stack.service.NotificationMaintainService;
import com.dwarfeng.subgrade.sdk.hibernate.criteria.PresetCriteriaMaker;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class NotificationPresetCriteriaMaker implements PresetCriteriaMaker {

    @Override
    public void makeCriteria(DetachedCriteria detachedCriteria, String s, Object[] objects) {
        switch (s) {
            case NotificationMaintainService.CHILD_FOR_USER:
                childForUser(detachedCriteria, objects);
                break;
            case NotificationMaintainService.CHILD_FOR_USER_UNREAD:
                childForUserUnread(detachedCriteria, objects);
                break;
            case NotificationMaintainService.CHILD_FOR_USER_NOTIFIED_DATE_DESC:
                childForUserNotifiedDateDesc(detachedCriteria, objects);
                break;
            case NotificationMaintainService.CHILD_FOR_USER_UNREAD_NOTIFIED_DATE_DESC:
                childForUserUnreadNotifiedDateDesc(detachedCriteria, objects);
                break;
            default:
                throw new IllegalArgumentException("无法识别的预设: " + s);
        }
    }

    private void childForUser(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("userStringId"));
            } else {
                StringIdKey stringIdKey = (StringIdKey) objects[0];
                detachedCriteria.add(Restrictions.eqOrIsNull("userStringId", stringIdKey.getStringId()));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForUserUnread(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("userStringId"));
            } else {
                StringIdKey stringIdKey = (StringIdKey) objects[0];
                detachedCriteria.add(Restrictions.eqOrIsNull("userStringId", stringIdKey.getStringId()));
            }
            detachedCriteria.add(Restrictions.eq("readFlag", false));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForUserNotifiedDateDesc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("userStringId"));
            } else {
                StringIdKey stringIdKey = (StringIdKey) objects[0];
                detachedCriteria.add(Restrictions.eqOrIsNull("userStringId", stringIdKey.getStringId()));
            }
            detachedCriteria.addOrder(Order.desc("notifiedDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForUserUnreadNotifiedDateDesc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("userStringId"));
            } else {
                StringIdKey stringIdKey = (StringIdKey) objects[0];
                detachedCriteria.add(Restrictions.eqOrIsNull("userStringId", stringIdKey.getStringId()));
            }
            detachedCriteria.add(Restrictions.eq("readFlag", false));
            detachedCriteria.addOrder(Order.desc("notifiedDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }
}
