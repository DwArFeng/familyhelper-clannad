package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Certificate;
import com.dwarfeng.familyhelper.clannad.stack.service.CertificateMaintainService;
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
public class CertificateMaintainServiceImplTest {

    @Autowired
    private CertificateMaintainService certificateMaintainService;

    private List<Certificate> certificates;

    @Before
    public void setUp() {
        certificates = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Certificate certificate = new Certificate(null, "name", "remark");
            certificates.add(certificate);
        }
    }

    @After
    public void tearDown() {
        certificates.clear();
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (Certificate certificate : certificates) {
                certificate.setKey(certificateMaintainService.insert(certificate));

                Certificate testCertificate = certificateMaintainService.get(certificate.getKey());
                assertEquals(BeanUtils.describe(certificate), BeanUtils.describe(testCertificate));
                certificateMaintainService.update(certificate);
                testCertificate = certificateMaintainService.get(certificate.getKey());
                assertEquals(BeanUtils.describe(certificate), BeanUtils.describe(testCertificate));
            }
        } finally {
            for (Certificate certificate : certificates) {
                certificateMaintainService.deleteIfExists(certificate.getKey());
            }
        }
    }
}
