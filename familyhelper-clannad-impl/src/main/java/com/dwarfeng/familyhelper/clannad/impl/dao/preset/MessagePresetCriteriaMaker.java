package com.dwarfeng.familyhelper.clannad.impl.dao.preset;

import com.dwarfeng.familyhelper.clannad.sdk.util.Constants;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageMaintainService;
import com.dwarfeng.subgrade.sdk.hibernate.criteria.PresetCriteriaMaker;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MessagePresetCriteriaMaker implements PresetCriteriaMaker {

    private static final Set<Integer> CHILD_FOR_RECEIVE_USER_DISPLAY_STATUS_SET;

    static {
        Set<Integer> CHILD_FOR_RECEIVE_USER_DISPLAY_STATUS_SET_DEJA_VU = new HashSet<>();
        CHILD_FOR_RECEIVE_USER_DISPLAY_STATUS_SET_DEJA_VU.add(Constants.MESSAGE_STATUS_SENT);
        CHILD_FOR_RECEIVE_USER_DISPLAY_STATUS_SET_DEJA_VU.add(Constants.MESSAGE_STATUS_RECEIVED);
        CHILD_FOR_RECEIVE_USER_DISPLAY_STATUS_SET = Collections.unmodifiableSet(
                CHILD_FOR_RECEIVE_USER_DISPLAY_STATUS_SET_DEJA_VU
        );
    }

    @Override
    public void makeCriteria(DetachedCriteria criteria, String preset, Object[] objs) {
        switch (preset) {
            case MessageMaintainService.CHILD_FOR_SEND_USER:
                childForSendUser(criteria, objs);
                break;
            case MessageMaintainService.CHILD_FOR_RECEIVE_USER:
                childForReceiveUser(criteria, objs);
                break;
            case MessageMaintainService.CHILD_FOR_SEND_USER_DISPLAY:
                childForSendUserDisplay(criteria, objs);
                break;
            case MessageMaintainService.CHILD_FOR_SEND_USER_DISPLAY_STATUS_EQ:
                childForSendUserDisplayStatusEq(criteria, objs);
                break;
            case MessageMaintainService.CHILD_FOR_RECEIVE_USER_DISPLAY:
                childForReceiveUserDisplay(criteria, objs);
                break;
            default:
                throw new IllegalArgumentException("无法识别的预设: " + preset);
        }
    }

    private void childForSendUser(DetachedCriteria criteria, Object[] objs) {
        try {
            if (Objects.isNull(objs[0])) {
                criteria.add(Restrictions.isNull("sendUserStringId"));
            } else {
                StringIdKey stringIdKey = (StringIdKey) objs[0];
                criteria.add(Restrictions.eqOrIsNull("sendUserStringId", stringIdKey.getStringId()));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objs));
        }
    }

    private void childForReceiveUser(DetachedCriteria criteria, Object[] objs) {
        try {
            if (Objects.isNull(objs[0])) {
                criteria.add(Restrictions.isNull("receiveUserStringId"));
            } else {
                StringIdKey stringIdKey = (StringIdKey) objs[0];
                criteria.add(Restrictions.eqOrIsNull("receiveUserStringId", stringIdKey.getStringId()));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objs));
        }
    }

    private void childForSendUserDisplay(DetachedCriteria criteria, Object[] objs) {
        try {
            if (Objects.isNull(objs[0])) {
                criteria.add(Restrictions.isNull("sendUserStringId"));
            } else {
                StringIdKey stringIdKey = (StringIdKey) objs[0];
                criteria.add(Restrictions.eqOrIsNull("sendUserStringId", stringIdKey.getStringId()));
            }
            criteria.addOrder(Order.desc("createdDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objs));
        }
    }

    private void childForSendUserDisplayStatusEq(DetachedCriteria criteria, Object[] objs) {
        try {
            if (Objects.isNull(objs[0])) {
                criteria.add(Restrictions.isNull("sendUserStringId"));
            } else {
                StringIdKey stringIdKey = (StringIdKey) objs[0];
                criteria.add(Restrictions.eqOrIsNull("sendUserStringId", stringIdKey.getStringId()));
            }
            criteria.add(Restrictions.eq("status", objs[1]));
            criteria.addOrder(Order.desc("createdDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objs));
        }
    }

    private void childForReceiveUserDisplay(DetachedCriteria criteria, Object[] objs) {
        try {
            if (Objects.isNull(objs[0])) {
                criteria.add(Restrictions.isNull("receiveUserStringId"));
            } else {
                StringIdKey stringIdKey = (StringIdKey) objs[0];
                criteria.add(Restrictions.eqOrIsNull("receiveUserStringId", stringIdKey.getStringId()));
            }
            criteria.add(Restrictions.eq("receiveUserHide", false));
            criteria.add(Restrictions.in("status", CHILD_FOR_RECEIVE_USER_DISPLAY_STATUS_SET));
            criteria.addOrder(Order.desc("createdDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objs));
        }
    }
}
