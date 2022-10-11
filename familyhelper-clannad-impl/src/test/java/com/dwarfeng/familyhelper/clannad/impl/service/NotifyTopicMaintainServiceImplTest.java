package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyTopic;
import com.dwarfeng.familyhelper.clannad.stack.service.NotifyTopicMaintainService;
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
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class NotifyTopicMaintainServiceImplTest {

    @Autowired
    private NotifyTopicMaintainService service;

    private final List<NotifyTopic> notifyTopics = new ArrayList<>();

    @Before
    public void setUp() {
        for (int i = 0; i < 5; i++) {
            NotifyTopic notifyTopic = new NotifyTopic(
                    new StringIdKey("test.notify_topic." + (i + 1)), "remark", true, 12450, "executorType",
                    "executorParam"
            );
            notifyTopics.add(notifyTopic);
        }
    }

    @After
    public void tearDown() {
        notifyTopics.clear();
    }

    @Test
    public void test() throws Exception {
        try {
            for (NotifyTopic notifyTopic : notifyTopics) {
                notifyTopic.setKey(service.insert(notifyTopic));
                service.update(notifyTopic);
                NotifyTopic testNotifyTopic = service.get(notifyTopic.getKey());
                assertEquals(BeanUtils.describe(notifyTopic), BeanUtils.describe(testNotifyTopic));
            }
        } finally {
            for (NotifyTopic notifyTopic : notifyTopics) {
                service.delete(notifyTopic.getKey());
            }
        }
    }
}
