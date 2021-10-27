package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Profile;
import com.dwarfeng.familyhelper.clannad.stack.service.ProfileMaintainService;
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
public class ProfileMaintainServiceImplTest {

    @Autowired
    private ProfileMaintainService profileMaintainService;

    private List<Profile> profiles;

    @Before
    public void setUp() {
        profiles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Profile profile = new Profile(
                    new StringIdKey("test_profile." + i), "name", "idNumber", "motd", "birthday", 0, "remark"
            );
            profiles.add(profile);
        }
    }

    @After
    public void tearDown() {
        profiles.clear();
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (Profile profile : profiles) {
                profileMaintainService.insertOrUpdate(profile);

                Profile testProfile = profileMaintainService.get(profile.getKey());
                assertEquals(BeanUtils.describe(profile), BeanUtils.describe(testProfile));
                profileMaintainService.update(profile);
                testProfile = profileMaintainService.get(profile.getKey());
                assertEquals(BeanUtils.describe(profile), BeanUtils.describe(testProfile));
            }
        } finally {
            for (Profile profile : profiles) {
                profileMaintainService.deleteIfExists(profile.getKey());
            }
        }
    }
}
