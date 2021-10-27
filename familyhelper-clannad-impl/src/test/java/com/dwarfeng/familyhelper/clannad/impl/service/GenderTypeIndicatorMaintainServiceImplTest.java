package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.GenderTypeIndicator;
import com.dwarfeng.familyhelper.clannad.stack.service.GenderTypeIndicatorMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.IntegerIdKey;
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
public class GenderTypeIndicatorMaintainServiceImplTest {

    @Autowired
    private GenderTypeIndicatorMaintainService genderTypeIndicatorMaintainService;

    private List<GenderTypeIndicator> genderTypeIndicators;

    @Before
    public void setUp() {
        genderTypeIndicators = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            GenderTypeIndicator genderTypeIndicator = new GenderTypeIndicator(
                    new IntegerIdKey(i),
                    "label",
                    "remark"
            );
            genderTypeIndicators.add(genderTypeIndicator);
        }
    }

    @After
    public void tearDown() {
        genderTypeIndicators.clear();
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (GenderTypeIndicator genderTypeIndicator : genderTypeIndicators) {
                genderTypeIndicator.setKey(genderTypeIndicatorMaintainService.insert(genderTypeIndicator));

                GenderTypeIndicator testGenderTypeIndicator = genderTypeIndicatorMaintainService.get(
                        genderTypeIndicator.getKey());
                assertEquals(BeanUtils.describe(genderTypeIndicator), BeanUtils.describe(testGenderTypeIndicator));
                genderTypeIndicatorMaintainService.update(genderTypeIndicator);
                testGenderTypeIndicator = genderTypeIndicatorMaintainService.get(genderTypeIndicator.getKey());
                assertEquals(BeanUtils.describe(genderTypeIndicator), BeanUtils.describe(testGenderTypeIndicator));
            }
        } finally {
            for (GenderTypeIndicator genderTypeIndicator : genderTypeIndicators) {
                genderTypeIndicatorMaintainService.deleteIfExists(genderTypeIndicator.getKey());
            }
        }
    }
}
