package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.AvatarInfo;
import com.dwarfeng.familyhelper.clannad.stack.service.AvatarInfoMaintainService;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class AvatarInfoMaintainServiceImplTest {

    @Autowired
    private AvatarInfoMaintainService avatarInfoMaintainService;

    private List<AvatarInfo> avatarInfos;

    @Before
    public void setUp() {
        avatarInfos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            AvatarInfo avatarInfo = new AvatarInfo(
                    new StringIdKey("test_avatarInfo." + i), "originName", 12450L, new Date(), "remark"
            );
            avatarInfos.add(avatarInfo);
        }
    }

    @After
    public void tearDown() {
        avatarInfos.clear();
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (AvatarInfo avatarInfo : avatarInfos) {
                avatarInfoMaintainService.insertOrUpdate(avatarInfo);

                AvatarInfo testAvatarInfo = avatarInfoMaintainService.get(avatarInfo.getKey());
                assertEquals(BeanUtils.describe(avatarInfo), BeanUtils.describe(testAvatarInfo));
                avatarInfoMaintainService.update(avatarInfo);
                testAvatarInfo = avatarInfoMaintainService.get(avatarInfo.getKey());
                assertEquals(BeanUtils.describe(avatarInfo), BeanUtils.describe(testAvatarInfo));
            }
        } finally {
            for (AvatarInfo avatarInfo : avatarInfos) {
                avatarInfoMaintainService.deleteIfExists(avatarInfo.getKey());
            }
        }
    }
}
