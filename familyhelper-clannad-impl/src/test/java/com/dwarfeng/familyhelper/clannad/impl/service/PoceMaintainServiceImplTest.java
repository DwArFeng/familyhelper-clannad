package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Certificate;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Poce;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.User;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoceKey;
import com.dwarfeng.familyhelper.clannad.stack.service.CertificateMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.PoceMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.UserMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
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
public class PoceMaintainServiceImplTest {

    private static final long CERTIFICATE_ID = 12450;
    private static final String USER_ID = "test_user";

    @Autowired
    private CertificateMaintainService certificateMaintainService;
    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private PoceMaintainService poceMaintainService;

    private Certificate certificate;
    private User user;
    private Poce poce;

    @Before
    public void setUp() {
        certificate = new Certificate(new LongIdKey(CERTIFICATE_ID), "name", "remark");
        user = new User(new StringIdKey(USER_ID), "remark");
        poce = new Poce(new PoceKey(CERTIFICATE_ID, USER_ID), 233, "remark");
    }

    @After
    public void tearDown() {
        certificate = null;
        user = null;
        poce = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            certificateMaintainService.insertOrUpdate(certificate);
            userMaintainService.insertOrUpdate(user);
            poceMaintainService.insert(poce);
            poceMaintainService.update(poce);

            Poce testPoce = poceMaintainService.get(poce.getKey());
            assertEquals(BeanUtils.describe(poce), BeanUtils.describe(testPoce));
            testPoce = poceMaintainService.get(poce.getKey());
            assertEquals(BeanUtils.describe(poce), BeanUtils.describe(testPoce));
        } finally {
            certificateMaintainService.deleteIfExists(certificate.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            poceMaintainService.deleteIfExists(poce.getKey());
        }
    }

    @Test
    public void testForCertificateCascade() throws Exception {
        try {
            certificateMaintainService.insertOrUpdate(certificate);
            userMaintainService.insertOrUpdate(user);
            poceMaintainService.insert(poce);

            certificateMaintainService.deleteIfExists(certificate.getKey());
            assertFalse(poceMaintainService.exists(poce.getKey()));
        } finally {
            certificateMaintainService.deleteIfExists(certificate.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            poceMaintainService.deleteIfExists(poce.getKey());
        }
    }

    @Test
    public void testForUserCascade() throws Exception {
        try {
            certificateMaintainService.insertOrUpdate(certificate);
            userMaintainService.insertOrUpdate(user);
            poceMaintainService.insert(poce);

            userMaintainService.deleteIfExists(user.getKey());
            assertFalse(poceMaintainService.exists(poce.getKey()));
        } finally {
            certificateMaintainService.deleteIfExists(certificate.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            poceMaintainService.deleteIfExists(poce.getKey());
        }
    }
}
