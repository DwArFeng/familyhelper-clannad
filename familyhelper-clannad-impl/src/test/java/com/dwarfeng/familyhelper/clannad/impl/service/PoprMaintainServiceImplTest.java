package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Popr;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Profile;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.User;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.familyhelper.clannad.stack.service.PoprMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.ProfileMaintainService;
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
public class PoprMaintainServiceImplTest {

    private static final String PROFILE_ID = "test.profile";
    private static final String USER_ID = "test.user";

    @Autowired
    private ProfileMaintainService profileMaintainService;
    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private PoprMaintainService poprMaintainService;

    private Profile profile;
    private User user;
    private Popr popr;

    @Before
    public void setUp() {
        profile = new Profile(
                new StringIdKey(PROFILE_ID), "name", "idNumber", "idType", "birthDay", "gender",
                "bloodType", "nationality", "familyAddress", "phoneNumber", "emailAddress", "employer",
                "jobPosition", "employerAddress", "jobTitle", "latestSchoolName", "educationalLevel",
                "educationalBackground", "politicalStatus", "maritalStatus", "remark"
        );
        user = new User(new StringIdKey(USER_ID), "remark");
        popr = new Popr(new PoprKey(PROFILE_ID, USER_ID), "remark");
    }

    @After
    public void tearDown() {
        profile = null;
        user = null;
        popr = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            profileMaintainService.insertOrUpdate(profile);
            userMaintainService.insertOrUpdate(user);
            poprMaintainService.insert(popr);
            poprMaintainService.update(popr);

            Popr testPopr = poprMaintainService.get(popr.getKey());
            assertEquals(BeanUtils.describe(popr), BeanUtils.describe(testPopr));
            testPopr = poprMaintainService.get(popr.getKey());
            assertEquals(BeanUtils.describe(popr), BeanUtils.describe(testPopr));
        } finally {
            profileMaintainService.deleteIfExists(profile.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            poprMaintainService.deleteIfExists(popr.getKey());
        }
    }

    @Test
    public void testForProfileCascade() throws Exception {
        try {
            profileMaintainService.insertOrUpdate(profile);
            userMaintainService.insertOrUpdate(user);
            poprMaintainService.insert(popr);

            profileMaintainService.deleteIfExists(profile.getKey());
            assertFalse(poprMaintainService.exists(popr.getKey()));
        } finally {
            profileMaintainService.deleteIfExists(profile.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            poprMaintainService.deleteIfExists(popr.getKey());
        }
    }

    @Test
    public void testForUserCascade() throws Exception {
        try {
            profileMaintainService.insertOrUpdate(profile);
            userMaintainService.insertOrUpdate(user);
            poprMaintainService.insert(popr);

            userMaintainService.deleteIfExists(user.getKey());
            assertFalse(poprMaintainService.exists(popr.getKey()));
        } finally {
            profileMaintainService.deleteIfExists(profile.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            poprMaintainService.deleteIfExists(popr.getKey());
        }
    }
}
