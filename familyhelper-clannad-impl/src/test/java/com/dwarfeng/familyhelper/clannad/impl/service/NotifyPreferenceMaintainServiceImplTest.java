package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyPreference;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifySetting;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyTopic;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.User;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyNodeKey;
import com.dwarfeng.familyhelper.clannad.stack.service.NotifyPreferenceMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.NotifySettingMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.NotifyTopicMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.UserMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class NotifyPreferenceMaintainServiceImplTest {

    private static final long NOTE_SETTING_ID = 12450;
    private static final String NOTE_TOPIC_ID = "test.topic";
    private static final String USER_ID = "test_user";

    @Autowired
    private NotifySettingMaintainService notifySettingMaintainService;
    @Autowired
    private NotifyTopicMaintainService notifyTopicMaintainService;
    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private NotifyPreferenceMaintainService notifyPreferenceMaintainService;

    private NotifySetting notifySetting;
    private NotifyTopic notifyTopic;
    private User user;
    private NotifyPreference notifyPreference;

    @Before
    public void setUp() {
        notifySetting = new NotifySetting(new LongIdKey(NOTE_SETTING_ID), "remark", "requiredPermission");
        notifyTopic = new NotifyTopic(new StringIdKey(NOTE_TOPIC_ID), "remark");
        user = new User(new StringIdKey(USER_ID), "remark");
        notifyPreference = new NotifyPreference(
                new NotifyNodeKey(NOTE_SETTING_ID, NOTE_TOPIC_ID, USER_ID), true, 12450L, "remark"
        );
    }

    @After
    public void tearDown() {
        notifySetting = null;
        notifyTopic = null;
        user = null;
        notifyPreference = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            notifySettingMaintainService.insertOrUpdate(notifySetting);
            notifyTopicMaintainService.insertOrUpdate(notifyTopic);
            userMaintainService.insertOrUpdate(user);
            notifyPreferenceMaintainService.insert(notifyPreference);
            notifyPreferenceMaintainService.update(notifyPreference);

            NotifyPreference testNotifyPreference = notifyPreferenceMaintainService.get(notifyPreference.getKey());
            assertEquals(BeanUtils.describe(notifyPreference), BeanUtils.describe(testNotifyPreference));
            testNotifyPreference = notifyPreferenceMaintainService.get(notifyPreference.getKey());
            assertEquals(BeanUtils.describe(notifyPreference), BeanUtils.describe(testNotifyPreference));
        } finally {
            notifySettingMaintainService.deleteIfExists(notifySetting.getKey());
            notifyTopicMaintainService.deleteIfExists(notifyTopic.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            notifyPreferenceMaintainService.deleteIfExists(notifyPreference.getKey());
        }
    }

    @Test
    public void testForNotifySettingCascade() throws Exception {
        try {
            notifySettingMaintainService.insertOrUpdate(notifySetting);
            notifyTopicMaintainService.insertOrUpdate(notifyTopic);
            userMaintainService.insertOrUpdate(user);
            notifyPreferenceMaintainService.insert(notifyPreference);

            notifySettingMaintainService.deleteIfExists(notifySetting.getKey());
            assertFalse(notifyPreferenceMaintainService.exists(notifyPreference.getKey()));
        } finally {
            notifySettingMaintainService.deleteIfExists(notifySetting.getKey());
            notifyTopicMaintainService.deleteIfExists(notifyTopic.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            notifyPreferenceMaintainService.deleteIfExists(notifyPreference.getKey());
        }
    }

    @Test
    public void testForNotifyTopicCascade() throws Exception {
        try {
            notifySettingMaintainService.insertOrUpdate(notifySetting);
            notifyTopicMaintainService.insertOrUpdate(notifyTopic);
            userMaintainService.insertOrUpdate(user);
            notifyPreferenceMaintainService.insert(notifyPreference);

            notifyTopicMaintainService.deleteIfExists(notifyTopic.getKey());
            assertFalse(notifyPreferenceMaintainService.exists(notifyPreference.getKey()));
        } finally {
            notifySettingMaintainService.deleteIfExists(notifySetting.getKey());
            notifyTopicMaintainService.deleteIfExists(notifyTopic.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            notifyPreferenceMaintainService.deleteIfExists(notifyPreference.getKey());
        }
    }

    @Test
    public void testForUserCascade() throws Exception {
        try {
            notifySettingMaintainService.insertOrUpdate(notifySetting);
            notifyTopicMaintainService.insertOrUpdate(notifyTopic);
            userMaintainService.insertOrUpdate(user);
            notifyPreferenceMaintainService.insert(notifyPreference);

            userMaintainService.deleteIfExists(user.getKey());
            assertFalse(notifyPreferenceMaintainService.exists(notifyPreference.getKey()));
        } finally {
            notifySettingMaintainService.deleteIfExists(notifySetting.getKey());
            notifyTopicMaintainService.deleteIfExists(notifyTopic.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            notifyPreferenceMaintainService.deleteIfExists(notifyPreference.getKey());
        }
    }
}
