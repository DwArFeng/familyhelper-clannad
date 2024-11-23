package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageAuthorization;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.User;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageAuthorizationMaintainService;
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

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class MessageAuthorizationMaintainServiceImplTest {

    private static final String RECEIVE_USER_ID = "test.receive_user";
    private static final String AUTHORIZED_SEND_USER_ID = "test.authorized_send_user";

    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private MessageAuthorizationMaintainService messageAuthorizationMaintainService;

    private User receiveUser;
    private User authorizedSendUser;
    private MessageAuthorization messageAuthorization;

    @Before
    public void setUp() {
        receiveUser = new User(new StringIdKey(RECEIVE_USER_ID), "remark");
        authorizedSendUser = new User(new StringIdKey(AUTHORIZED_SEND_USER_ID), "remark");
        messageAuthorization = new MessageAuthorization(
                new MessageAuthorizationKey(
                        receiveUser.getKey().getStringId(), authorizedSendUser.getKey().getStringId()
                ),
                true, "remark", new Date()
        );
    }

    @After
    public void tearDown() {
        receiveUser = null;
        authorizedSendUser = null;
        messageAuthorization = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            userMaintainService.insertOrUpdate(receiveUser);
            userMaintainService.insertOrUpdate(authorizedSendUser);
            messageAuthorizationMaintainService.insertOrUpdate(messageAuthorization);
            // 第一次读取，测试数据库。
            MessageAuthorization testMessageAuthorization = messageAuthorizationMaintainService.get(
                    messageAuthorization.getKey()
            );
            assertEquals(BeanUtils.describe(messageAuthorization), BeanUtils.describe(testMessageAuthorization));
            // 第二次读取，测试缓存。
            testMessageAuthorization = messageAuthorizationMaintainService.get(messageAuthorization.getKey());
            assertEquals(BeanUtils.describe(messageAuthorization), BeanUtils.describe(testMessageAuthorization));
            // 更新测试。
            messageAuthorizationMaintainService.update(messageAuthorization);
            testMessageAuthorization = messageAuthorizationMaintainService.get(messageAuthorization.getKey());
            assertEquals(BeanUtils.describe(messageAuthorization), BeanUtils.describe(testMessageAuthorization));
        } finally {
            messageAuthorizationMaintainService.deleteIfExists(messageAuthorization.getKey());
            userMaintainService.deleteIfExists(authorizedSendUser.getKey());
            userMaintainService.deleteIfExists(receiveUser.getKey());
        }
    }

    @Test
    public void testForReceiveUserCascade() throws Exception {
        try {
            userMaintainService.insertOrUpdate(receiveUser);
            userMaintainService.insertOrUpdate(authorizedSendUser);
            messageAuthorizationMaintainService.insertOrUpdate(messageAuthorization);

            assertFalse(
                    messageAuthorizationMaintainService.lookupAsList(
                            MessageAuthorizationMaintainService.CHILD_FOR_RECEIVE_USER,
                            new Object[]{receiveUser.getKey()}
                    ).isEmpty()
            );

            userMaintainService.deleteIfExists(receiveUser.getKey());

            assertTrue(
                    messageAuthorizationMaintainService.lookupAsList(
                            MessageAuthorizationMaintainService.CHILD_FOR_RECEIVE_USER,
                            new Object[]{receiveUser.getKey()}
                    ).isEmpty()
            );

            assertFalse(messageAuthorizationMaintainService.exists(messageAuthorization.getKey()));
        } finally {
            messageAuthorizationMaintainService.deleteIfExists(messageAuthorization.getKey());
            userMaintainService.deleteIfExists(authorizedSendUser.getKey());
            userMaintainService.deleteIfExists(receiveUser.getKey());
        }
    }

    @Test
    public void testForAuthorizedSendUserCascade() throws Exception {
        try {
            userMaintainService.insertOrUpdate(receiveUser);
            userMaintainService.insertOrUpdate(authorizedSendUser);
            messageAuthorizationMaintainService.insertOrUpdate(messageAuthorization);

            assertFalse(
                    messageAuthorizationMaintainService.lookupAsList(
                            MessageAuthorizationMaintainService.CHILD_FOR_AUTHORIZED_SEND_USER,
                            new Object[]{authorizedSendUser.getKey()}
                    ).isEmpty()
            );

            userMaintainService.deleteIfExists(authorizedSendUser.getKey());

            assertTrue(
                    messageAuthorizationMaintainService.lookupAsList(
                            MessageAuthorizationMaintainService.CHILD_FOR_AUTHORIZED_SEND_USER,
                            new Object[]{authorizedSendUser.getKey()}
                    ).isEmpty()
            );

            assertFalse(messageAuthorizationMaintainService.exists(messageAuthorization.getKey()));
        } finally {
            messageAuthorizationMaintainService.deleteIfExists(messageAuthorization.getKey());
            userMaintainService.deleteIfExists(authorizedSendUser.getKey());
            userMaintainService.deleteIfExists(receiveUser.getKey());
        }
    }
}
