package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Message;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageAttachmentInfo;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageAttachmentInfoMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageMaintainService;
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
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class MessageAttachmentInfoMaintainServiceImplTest {

    @Autowired
    private MessageMaintainService messageMaintainService;
    @Autowired
    private MessageAttachmentInfoMaintainService messageAttachmentInfoMaintainService;

    private Message message;
    private List<MessageAttachmentInfo> messageAttachmentInfos;

    @Before
    public void setUp() {
        message = new Message(
                null, null, null, "subject", "remark", 12450, new Date(), new Date(), 12450, new Date(), true
        );
        messageAttachmentInfos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MessageAttachmentInfo messageAttachmentInfo = new MessageAttachmentInfo(
                    null, null, "originName", 12450L, new Date(), "remark"
            );
            messageAttachmentInfos.add(messageAttachmentInfo);
        }
    }

    @After
    public void tearDown() {
        message = null;
        messageAttachmentInfos.clear();
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            message.setKey(messageMaintainService.insert(message));
            for (MessageAttachmentInfo messageAttachmentInfo : messageAttachmentInfos) {
                messageAttachmentInfo.setMessageKey(message.getKey());
                messageAttachmentInfo.setKey(messageAttachmentInfoMaintainService.insert(messageAttachmentInfo));

                MessageAttachmentInfo testMessageAttachmentInfo = messageAttachmentInfoMaintainService.get(
                        messageAttachmentInfo.getKey()
                );
                assertEquals(BeanUtils.describe(messageAttachmentInfo), BeanUtils.describe(testMessageAttachmentInfo));
                messageAttachmentInfoMaintainService.update(messageAttachmentInfo);
                testMessageAttachmentInfo = messageAttachmentInfoMaintainService.get(messageAttachmentInfo.getKey());
                assertEquals(BeanUtils.describe(messageAttachmentInfo), BeanUtils.describe(testMessageAttachmentInfo));
            }
        } finally {
            for (MessageAttachmentInfo messageAttachmentInfo : messageAttachmentInfos) {
                messageAttachmentInfoMaintainService.deleteIfExists(messageAttachmentInfo.getKey());
            }
            messageMaintainService.deleteIfExists(message.getKey());
        }
    }

    @Test
    public void testForMessageCascade() throws Exception {
        try {
            message.setKey(messageMaintainService.insert(message));
            for (MessageAttachmentInfo messageAttachmentInfo : messageAttachmentInfos) {
                messageAttachmentInfo.setMessageKey(message.getKey());
                messageAttachmentInfo.setKey(messageAttachmentInfoMaintainService.insert(messageAttachmentInfo));
            }

            messageMaintainService.deleteIfExists(message.getKey());

            assertTrue(messageAttachmentInfoMaintainService.nonExists(
                    messageAttachmentInfos.stream().map(MessageAttachmentInfo::getKey).collect(Collectors.toList()))
            );
        } finally {
            for (MessageAttachmentInfo messageAttachmentInfo : messageAttachmentInfos) {
                messageAttachmentInfoMaintainService.deleteIfExists(messageAttachmentInfo.getKey());
            }
            messageMaintainService.deleteIfExists(message.getKey());
        }
    }
}
