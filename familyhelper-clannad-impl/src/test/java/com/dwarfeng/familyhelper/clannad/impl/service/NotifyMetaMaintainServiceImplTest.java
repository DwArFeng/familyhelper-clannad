package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyMeta;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifySetting;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyTopic;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.User;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyNodeKey;
import com.dwarfeng.familyhelper.clannad.stack.service.NotifyMetaMaintainService;
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

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class NotifyMetaMaintainServiceImplTest {

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
    private NotifyMetaMaintainService notifyMetaMaintainService;

    private NotifySetting notifySetting;
    private NotifyTopic notifyTopic;
    private User user;
    private NotifyMeta notifyMeta;

    @Before
    public void setUp() {
        notifySetting = new NotifySetting(new LongIdKey(NOTE_SETTING_ID), "remark", "requiredPermission");
        notifyTopic = new NotifyTopic(new StringIdKey(NOTE_TOPIC_ID), "remark", true, 12450);
        user = new User(new StringIdKey(USER_ID), "remark");
        notifyMeta = new NotifyMeta(
                new NotifyNodeKey(NOTE_SETTING_ID, NOTE_TOPIC_ID, USER_ID), new Date(), "remark"
        );
    }

    @After
    public void tearDown() {
        notifySetting = null;
        notifyTopic = null;
        user = null;
        notifyMeta = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            notifySettingMaintainService.insertOrUpdate(notifySetting);
            notifyTopicMaintainService.insertOrUpdate(notifyTopic);
            userMaintainService.insertOrUpdate(user);
            notifyMetaMaintainService.insert(notifyMeta);
            notifyMetaMaintainService.update(notifyMeta);

            NotifyMeta testNotifyMeta = notifyMetaMaintainService.get(notifyMeta.getKey());
            assertEquals(BeanUtils.describe(notifyMeta), BeanUtils.describe(testNotifyMeta));
            testNotifyMeta = notifyMetaMaintainService.get(notifyMeta.getKey());
            assertEquals(BeanUtils.describe(notifyMeta), BeanUtils.describe(testNotifyMeta));
        } finally {
            notifySettingMaintainService.deleteIfExists(notifySetting.getKey());
            notifyTopicMaintainService.deleteIfExists(notifyTopic.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            notifyMetaMaintainService.deleteIfExists(notifyMeta.getKey());
        }
    }

    @Test
    public void testForNotifySettingCascade() throws Exception {
        try {
            notifySettingMaintainService.insertOrUpdate(notifySetting);
            notifyTopicMaintainService.insertOrUpdate(notifyTopic);
            userMaintainService.insertOrUpdate(user);
            notifyMetaMaintainService.insert(notifyMeta);

            notifySettingMaintainService.deleteIfExists(notifySetting.getKey());
            assertFalse(notifyMetaMaintainService.exists(notifyMeta.getKey()));
        } finally {
            notifySettingMaintainService.deleteIfExists(notifySetting.getKey());
            notifyTopicMaintainService.deleteIfExists(notifyTopic.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            notifyMetaMaintainService.deleteIfExists(notifyMeta.getKey());
        }
    }

    @Test
    public void testForNotifyTopicCascade() throws Exception {
        try {
            notifySettingMaintainService.insertOrUpdate(notifySetting);
            notifyTopicMaintainService.insertOrUpdate(notifyTopic);
            userMaintainService.insertOrUpdate(user);
            notifyMetaMaintainService.insert(notifyMeta);

            notifyTopicMaintainService.deleteIfExists(notifyTopic.getKey());
            assertFalse(notifyMetaMaintainService.exists(notifyMeta.getKey()));
        } finally {
            notifySettingMaintainService.deleteIfExists(notifySetting.getKey());
            notifyTopicMaintainService.deleteIfExists(notifyTopic.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            notifyMetaMaintainService.deleteIfExists(notifyMeta.getKey());
        }
    }

    @Test
    public void testForUserCascade() throws Exception {
        try {
            notifySettingMaintainService.insertOrUpdate(notifySetting);
            notifyTopicMaintainService.insertOrUpdate(notifyTopic);
            userMaintainService.insertOrUpdate(user);
            notifyMetaMaintainService.insert(notifyMeta);

            userMaintainService.deleteIfExists(user.getKey());
            assertFalse(notifyMetaMaintainService.exists(notifyMeta.getKey()));
        } finally {
            notifySettingMaintainService.deleteIfExists(notifySetting.getKey());
            notifyTopicMaintainService.deleteIfExists(notifyTopic.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            notifyMetaMaintainService.deleteIfExists(notifyMeta.getKey());
        }
    }
}
