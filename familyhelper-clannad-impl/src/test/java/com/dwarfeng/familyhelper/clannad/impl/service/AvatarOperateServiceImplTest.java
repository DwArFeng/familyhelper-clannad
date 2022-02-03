package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.dutil.basic.io.IOUtil;
import com.dwarfeng.familyhelper.clannad.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.Avatar;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.AvatarUploadInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.User;
import com.dwarfeng.familyhelper.clannad.stack.service.AvatarInfoMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.AvatarOperateService;
import com.dwarfeng.familyhelper.clannad.stack.service.UserMaintainService;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class AvatarOperateServiceImplTest {

    private static final StringIdKey USER_KEY = new StringIdKey("test.user");

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private AvatarInfoMaintainService avatarInfoMaintainService;

    @Autowired
    private AvatarOperateService avatarOperateService;

    @Autowired
    private FtpHandler ftpHandler;

    private User user;

    @Before
    public void setUp() {
        user = new User(USER_KEY, "remark");
    }

    @After
    public void tearDown() {
        user = null;
    }

    @Test
    public void test() throws Exception {
        try {
            // 添加用户。
            userMaintainService.insertOrUpdate(user);

            // 拿到 test-avatar.png，获取字节数组。
            byte[] content;
            try (
                    InputStream in = ctx.getResource("classpath:ftp/test-avatar.png").getInputStream();
                    ByteArrayOutputStream out = new ByteArrayOutputStream()
            ) {
                IOUtil.trans(in, out, 4096);
                out.flush();
                content = out.toByteArray();
            }
            AvatarUploadInfo avatarUploadInfo = new AvatarUploadInfo("test-avatar.png", content);

            // 第一次保存。
            avatarOperateService.uploadAvatar(USER_KEY, avatarUploadInfo);
            // 下载头像，头像的内容应该与 content 相等。
            Avatar avatar = avatarOperateService.downloadAvatar(USER_KEY);
            assertArrayEquals(content, avatar.getContent());

            // 第二次保存。
            avatarOperateService.uploadAvatar(USER_KEY, avatarUploadInfo);
            // 下载头像，头像的内容应该与 content 相等。
            avatar = avatarOperateService.downloadAvatar(USER_KEY);
            assertArrayEquals(content, avatar.getContent());

            // 移除头像，头像文件和头像信息应该一并移除。
            avatarOperateService.removeAvatar(USER_KEY);
            assertFalse(ftpHandler.existsFile(new String[]{FtpConstants.PATH_AVATAR}, USER_KEY.getStringId()));
            assertFalse(avatarInfoMaintainService.exists(USER_KEY));
        } finally {
            userMaintainService.deleteIfExists(user.getKey());
        }
    }
}
