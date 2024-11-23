package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Message;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageBodyInfo;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageBodyInfoMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageMaintainService;
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
public class MessageBodyInfoMaintainServiceImplTest {

    @Autowired
    private MessageMaintainService messageMaintainService;
    @Autowired
    private MessageBodyInfoMaintainService messageBodyInfoMaintainService;

    private Message message;
    private MessageBodyInfo messageBodyInfo;

    @Before
    public void setUp() {
        message = new Message(
                null, null, null, "subject", "remark", 12450, new Date(), new Date(), 12450, new Date(), true
        );
        messageBodyInfo = new MessageBodyInfo(null, 12450L, new Date(), "remark");
    }

    @After
    public void tearDown() {
        message = null;
        messageBodyInfo = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            message.setKey(messageMaintainService.insert(message));

            messageBodyInfo.setKey(message.getKey());
            messageBodyInfoMaintainService.insert(messageBodyInfo);
            MessageBodyInfo testMessageBodyInfo = messageBodyInfoMaintainService.get(
                    messageBodyInfo.getKey()
            );
            assertEquals(BeanUtils.describe(messageBodyInfo), BeanUtils.describe(testMessageBodyInfo));
            messageBodyInfoMaintainService.update(messageBodyInfo);
            testMessageBodyInfo = messageBodyInfoMaintainService.get(messageBodyInfo.getKey());
            assertEquals(BeanUtils.describe(messageBodyInfo), BeanUtils.describe(testMessageBodyInfo));
        } finally {
            messageBodyInfoMaintainService.deleteIfExists(messageBodyInfo.getKey());
            messageMaintainService.deleteIfExists(message.getKey());
        }
    }

    @Test
    public void testForMessageCascade() throws Exception {
        try {
            message.setKey(messageMaintainService.insert(message));
            messageBodyInfo.setKey(message.getKey());
            messageBodyInfoMaintainService.insert(messageBodyInfo);

            assertTrue(messageBodyInfoMaintainService.exists(messageBodyInfo.getKey()));

            messageMaintainService.deleteIfExists(message.getKey());

            assertFalse(messageBodyInfoMaintainService.exists(messageBodyInfo.getKey()));
        } finally {
            messageBodyInfoMaintainService.deleteIfExists(messageBodyInfo.getKey());
            messageMaintainService.deleteIfExists(message.getKey());
        }
    }
}
