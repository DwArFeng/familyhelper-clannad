package com.dwarfeng.familyhelper.clannad.impl.dao.preset;

import com.dwarfeng.familyhelper.clannad.stack.service.MessageAuthorizationMaintainService;
import com.dwarfeng.subgrade.sdk.hibernate.criteria.PresetCriteriaMaker;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class MessageAuthorizationPresetCriteriaMaker implements PresetCriteriaMaker {

    @Override
    public void makeCriteria(DetachedCriteria criteria, String preset, Object[] objs) {
        switch (preset) {
            case MessageAuthorizationMaintainService.CHILD_FOR_RECEIVE_USER:
                childForReceiveUser(criteria, objs);
                break;
            case MessageAuthorizationMaintainService.CHILD_FOR_AUTHORIZED_SEND_USER:
                childForAuthorizedSendUser(criteria, objs);
                break;
            case MessageAuthorizationMaintainService.CHILD_FOR_AUTHORIZED_SEND_USER_ID_LIKE:
                childForAuthorizedSendUserIdLike(criteria, objs);
                break;
            default:
                throw new IllegalArgumentException("无法识别的预设: " + preset);
        }
    }

    private void childForReceiveUser(DetachedCriteria criteria, Object[] objs) {
        try {
            if (Objects.isNull(objs[0])) {
                criteria.add(Restrictions.isNull("receiveUserId"));
            } else {
                StringIdKey stringIdKey = (StringIdKey) objs[0];
                criteria.add(Restrictions.eqOrIsNull("receiveUserId", stringIdKey.getStringId()));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objs));
        }
    }

    private void childForAuthorizedSendUser(DetachedCriteria criteria, Object[] objs) {
        try {
            if (Objects.isNull(objs[0])) {
                criteria.add(Restrictions.isNull("authorizedSendUserId"));
            } else {
                StringIdKey stringIdKey = (StringIdKey) objs[0];
                criteria.add(Restrictions.eqOrIsNull("authorizedSendUserId", stringIdKey.getStringId()));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objs));
        }
    }

    private void childForAuthorizedSendUserIdLike(DetachedCriteria criteria, Object[] objs) {
        try {
            if (Objects.isNull(objs[0])) {
                criteria.add(Restrictions.isNull("authorizedSendUserId"));
            } else {
                StringIdKey stringIdKey = (StringIdKey) objs[0];
                criteria.add(Restrictions.eqOrIsNull("authorizedSendUserId", stringIdKey.getStringId()));
            }
            String pattern = (String) objs[1];
            criteria.add(Restrictions.like("receiveUserId", pattern, MatchMode.ANYWHERE));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objs));
        }
    }
}
