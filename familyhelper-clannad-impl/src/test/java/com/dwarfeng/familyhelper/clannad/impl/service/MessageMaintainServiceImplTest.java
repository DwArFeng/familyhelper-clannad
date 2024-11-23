package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Message;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.User;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageMaintainService;
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
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class MessageMaintainServiceImplTest {

    private static final String SEND_USER_ID = "test.send_user";
    private static final String RECEIVE_USER_ID = "test.receive_user";

    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private MessageMaintainService messageMaintainService;

    private User sendUser;
    private User receiveUser;
    private List<Message> messages;

    @Before
    public void setUp() {
        sendUser = new User(new StringIdKey(SEND_USER_ID), "remark");
        receiveUser = new User(new StringIdKey(RECEIVE_USER_ID), "remark");
        messages = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Message message = new Message(
                    null, sendUser.getKey(), receiveUser.getKey(), "subject", "remark", 12450,
                    new Date(), new Date(), 12450, new Date(), true
            );
            messages.add(message);
        }
    }

    @After
    public void tearDown() {
        sendUser = null;
        receiveUser = null;
        messages.clear();
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            userMaintainService.insertOrUpdate(sendUser);
            userMaintainService.insertOrUpdate(receiveUser);
            for (Message message : messages) {
                message.setKey(messageMaintainService.insertOrUpdate(message));
                // 第一次读取，测试数据库。
                Message testMessage = messageMaintainService.get(message.getKey());
                assertEquals(BeanUtils.describe(message), BeanUtils.describe(testMessage));
                // 第二次读取，测试缓存。
                testMessage = messageMaintainService.get(message.getKey());
                assertEquals(BeanUtils.describe(message), BeanUtils.describe(testMessage));
                // 更新测试。
                messageMaintainService.update(message);
                testMessage = messageMaintainService.get(message.getKey());
                assertEquals(BeanUtils.describe(message), BeanUtils.describe(testMessage));
            }
        } finally {
            for (Message message : messages) {
                messageMaintainService.deleteIfExists(message.getKey());
            }
            userMaintainService.deleteIfExists(receiveUser.getKey());
            userMaintainService.deleteIfExists(sendUser.getKey());
        }
    }

    @Test
    public void testForSendUserCascade() throws Exception {
        try {
            userMaintainService.insertOrUpdate(sendUser);
            userMaintainService.insertOrUpdate(receiveUser);
            for (Message message : messages) {
                message.setKey(messageMaintainService.insertOrUpdate(message));
            }

            assertEquals(
                    messages.size(),
                    messageMaintainService.lookupAsList(
                            MessageMaintainService.CHILD_FOR_SEND_USER, new Object[]{sendUser.getKey()}
                    ).size()
            );

            userMaintainService.deleteIfExists(sendUser.getKey());

            assertEquals(
                    0,
                    messageMaintainService.lookupAsList(
                            MessageMaintainService.CHILD_FOR_SEND_USER, new Object[]{sendUser.getKey()}
                    ).size()
            );

            for (Message message : messages) {
                assertFalse(messageMaintainService.exists(message.getKey()));
            }
        } finally {
            for (Message message : messages) {
                messageMaintainService.deleteIfExists(message.getKey());
            }
            userMaintainService.deleteIfExists(receiveUser.getKey());
            userMaintainService.deleteIfExists(sendUser.getKey());
        }
    }

    @Test
    public void testForReceiveUserCascade() throws Exception {
        try {
            userMaintainService.insertOrUpdate(sendUser);
            userMaintainService.insertOrUpdate(receiveUser);
            for (Message message : messages) {
                message.setKey(messageMaintainService.insertOrUpdate(message));
            }

            assertEquals(
                    messages.size(),
                    messageMaintainService.lookupAsList(
                            MessageMaintainService.CHILD_FOR_RECEIVE_USER, new Object[]{receiveUser.getKey()}
                    ).size()
            );

            userMaintainService.deleteIfExists(receiveUser.getKey());

            assertEquals(
                    0,
                    messageMaintainService.lookupAsList(
                            MessageMaintainService.CHILD_FOR_RECEIVE_USER, new Object[]{receiveUser.getKey()}
                    ).size()
            );

            for (Message message : messages) {
                assertFalse(messageMaintainService.exists(message.getKey()));
            }
        } finally {
            for (Message message : messages) {
                messageMaintainService.deleteIfExists(message.getKey());
            }
            userMaintainService.deleteIfExists(receiveUser.getKey());
            userMaintainService.deleteIfExists(sendUser.getKey());
        }
    }
}
