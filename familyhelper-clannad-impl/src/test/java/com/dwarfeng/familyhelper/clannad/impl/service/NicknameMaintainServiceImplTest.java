package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Nickname;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.User;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NicknameKey;
import com.dwarfeng.familyhelper.clannad.stack.service.NicknameMaintainService;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class NicknameMaintainServiceImplTest {

    private static final String USER_ID_1 = "test.user1.1";
    private static final String USER_ID_2 = "test.user1.2";

    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private NicknameMaintainService nicknameMaintainService;

    private User user1;
    private User user2;
    private Nickname nickname;

    @Before
    public void setUp() {
        user1 = new User(new StringIdKey(USER_ID_1), "remark");
        user2 = new User(new StringIdKey(USER_ID_2), "remark");
        nickname = new Nickname(new NicknameKey(USER_ID_1, USER_ID_2), "call", "remark");
    }

    @After
    public void tearDown() {
        user1 = null;
        user2 = null;
        nickname = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            userMaintainService.insertOrUpdate(user1);
            userMaintainService.insertOrUpdate(user2);
            nicknameMaintainService.insert(nickname);
            nicknameMaintainService.update(nickname);

            Nickname testNickname = nicknameMaintainService.get(nickname.getKey());
            assertEquals(BeanUtils.describe(nickname), BeanUtils.describe(testNickname));
            testNickname = nicknameMaintainService.get(nickname.getKey());
            assertEquals(BeanUtils.describe(nickname), BeanUtils.describe(testNickname));
        } finally {
            userMaintainService.deleteIfExists(user1.getKey());
            userMaintainService.deleteIfExists(user2.getKey());
            nicknameMaintainService.deleteIfExists(nickname.getKey());
        }
    }

    @Test
    public void testForSubjectUserCascade() throws Exception {
        try {
            userMaintainService.insertOrUpdate(user1);
            userMaintainService.insertOrUpdate(user2);
            nicknameMaintainService.insert(nickname);

            userMaintainService.deleteIfExists(user1.getKey());
            assertFalse(nicknameMaintainService.exists(nickname.getKey()));
        } finally {
            userMaintainService.deleteIfExists(user1.getKey());
            userMaintainService.deleteIfExists(user2.getKey());
            nicknameMaintainService.deleteIfExists(nickname.getKey());
        }
    }

    @Test
    public void testForObjectUserCascade() throws Exception {
        try {
            userMaintainService.insertOrUpdate(user1);
            userMaintainService.insertOrUpdate(user2);
            nicknameMaintainService.insert(nickname);

            userMaintainService.deleteIfExists(user2.getKey());
            assertFalse(nicknameMaintainService.exists(nickname.getKey()));
        } finally {
            userMaintainService.deleteIfExists(user1.getKey());
            userMaintainService.deleteIfExists(user2.getKey());
            nicknameMaintainService.deleteIfExists(nickname.getKey());
        }
    }
}
