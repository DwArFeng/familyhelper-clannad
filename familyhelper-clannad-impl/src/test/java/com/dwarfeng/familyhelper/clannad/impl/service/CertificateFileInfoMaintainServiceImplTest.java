package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Certificate;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.CertificateFileInfo;
import com.dwarfeng.familyhelper.clannad.stack.service.CertificateFileInfoMaintainService;
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
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class CertificateFileInfoMaintainServiceImplTest {

    @Autowired
    private CertificateFileInfoMaintainService certificateFileInfoMaintainService;
    @Autowired
    private CertificateMaintainService certificateMaintainService;

    private List<CertificateFileInfo> certificateFileInfos;
    private Certificate certificate;

    @Before
    public void setUp() {
        certificateFileInfos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CertificateFileInfo certificateFileInfo = new CertificateFileInfo(
                    null, null, "originName", 12450L, new Date(), "remark"
            );
            certificateFileInfos.add(certificateFileInfo);
        }
        certificate = new Certificate(null, "name", "remark");
    }

    @After
    public void tearDown() {
        certificateFileInfos.clear();
        certificate = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            certificate.setKey(certificateMaintainService.insert(certificate));
            for (CertificateFileInfo certificateFileInfo : certificateFileInfos) {
                certificateFileInfo.setCertificateKey(certificate.getKey());
                certificateFileInfo.setKey(certificateFileInfoMaintainService.insert(certificateFileInfo));

                CertificateFileInfo testCertificateFileInfo = certificateFileInfoMaintainService.get(certificateFileInfo.getKey());
                assertEquals(BeanUtils.describe(certificateFileInfo), BeanUtils.describe(testCertificateFileInfo));
                certificateFileInfoMaintainService.update(certificateFileInfo);
                testCertificateFileInfo = certificateFileInfoMaintainService.get(certificateFileInfo.getKey());
                assertEquals(BeanUtils.describe(certificateFileInfo), BeanUtils.describe(testCertificateFileInfo));
            }
        } finally {
            for (CertificateFileInfo certificateFileInfo : certificateFileInfos) {
                certificateFileInfoMaintainService.deleteIfExists(certificateFileInfo.getKey());
            }
            certificateMaintainService.deleteIfExists(certificate.getKey());
        }
    }

    @Test
    public void testForCertificateCascade() throws Exception {
        try {
            certificate.setKey(certificateMaintainService.insert(certificate));
            for (CertificateFileInfo certificateFileInfo : certificateFileInfos) {
                certificateFileInfo.setCertificateKey(certificate.getKey());
                certificateFileInfo.setKey(certificateFileInfoMaintainService.insert(certificateFileInfo));
            }

            certificateMaintainService.deleteIfExists(certificate.getKey());

            assertTrue(certificateFileInfoMaintainService.nonExists(
                    certificateFileInfos.stream().map(CertificateFileInfo::getKey).collect(Collectors.toList()))
            );
        } finally {
            for (CertificateFileInfo certificateFileInfo : certificateFileInfos) {
                certificateFileInfoMaintainService.deleteIfExists(certificateFileInfo.getKey());
            }
            certificateMaintainService.deleteIfExists(certificate.getKey());
        }
    }
}
