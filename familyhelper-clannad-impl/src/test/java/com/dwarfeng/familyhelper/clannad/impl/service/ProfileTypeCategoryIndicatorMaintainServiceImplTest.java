package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.ProfileTypeIndicator;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.ProfileTypeIndicatorKey;
import com.dwarfeng.familyhelper.clannad.stack.service.ProfileTypeIndicatorMaintainService;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class ProfileTypeCategoryIndicatorMaintainServiceImplTest {

    @Autowired
    private ProfileTypeIndicatorMaintainService profileTypeIndicatorMaintainService;

    private ProfileTypeIndicator profileTypeIndicator;

    @Before
    public void setUp() {
        profileTypeIndicator = new ProfileTypeIndicator(
                new ProfileTypeIndicatorKey("categoryId", "stringId"), "label", "remark"
        );
    }

    @After
    public void tearDown() {
        profileTypeIndicator = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            profileTypeIndicatorMaintainService.insert(profileTypeIndicator);
            profileTypeIndicatorMaintainService.update(profileTypeIndicator);
            ProfileTypeIndicator testProfileTypeIndicator = profileTypeIndicatorMaintainService.get(profileTypeIndicator.getKey());
            assertEquals(BeanUtils.describe(profileTypeIndicator), BeanUtils.describe(testProfileTypeIndicator));
            testProfileTypeIndicator = profileTypeIndicatorMaintainService.get(profileTypeIndicator.getKey());
            assertEquals(BeanUtils.describe(profileTypeIndicator), BeanUtils.describe(testProfileTypeIndicator));
        } finally {
            profileTypeIndicatorMaintainService.deleteIfExists(profileTypeIndicator.getKey());
        }
    }
}
