package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Notification;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.User;
import com.dwarfeng.familyhelper.clannad.stack.service.NotificationMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.UserMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class NotificationMaintainServiceImplTest {

    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private NotificationMaintainService notificationMaintainService;

    private User user;
    private List<Notification> notifications;

    @Before
    public void setUp() {
        user = new User(new StringIdKey("test_user"), "remark");
        notifications = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Notification notification = new Notification(
                    null, null, "message", "remark", new Date(), new Date(), false
            );
            notifications.add(notification);
        }
    }

    @After
    public void tearDown() {
        user = null;
        notifications.clear();
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            userMaintainService.insertOrUpdate(user);
            for (Notification notification : notifications) {
                notification.setUserKey(user.getKey());
                notification.setKey(notificationMaintainService.insert(notification));

                Notification testNotification = notificationMaintainService.get(notification.getKey());
                assertEquals(BeanUtils.describe(notification), BeanUtils.describe(testNotification));
                notificationMaintainService.update(notification);
                testNotification = notificationMaintainService.get(notification.getKey());
                assertEquals(BeanUtils.describe(notification), BeanUtils.describe(testNotification));
            }
        } finally {
            for (Notification notification : notifications) {
                notificationMaintainService.deleteIfExists(notification.getKey());
            }
            userMaintainService.deleteIfExists(user.getKey());
        }
    }

    @Test
    public void testForUserCascade() throws Exception {
        try {
            userMaintainService.insertOrUpdate(user);
            for (Notification notification : notifications) {
                notification.setUserKey(user.getKey());
                notification.setKey(notificationMaintainService.insert(notification));
            }

            List<Notification> testNotifications = notificationMaintainService.lookup(
                    NotificationMaintainService.CHILD_FOR_USER, new Object[]{user.getKey()}
            ).getData();
            assertEquals(notifications.size(), testNotifications.size());
            userMaintainService.deleteIfExists(user.getKey());
            testNotifications = notificationMaintainService.lookup(
                    NotificationMaintainService.CHILD_FOR_USER, new Object[]{user.getKey()}
            ).getData();
            assertTrue(testNotifications.isEmpty());
        } finally {
            for (Notification notification : notifications) {
                notificationMaintainService.deleteIfExists(notification.getKey());
            }
            userMaintainService.deleteIfExists(user.getKey());
        }
    }
}
