package com.dwarfeng.familyhelper.clannad.node.configuration;

import com.alibaba.fastjson.parser.ParserConfig;
import com.dwarfeng.familyhelper.clannad.sdk.bean.entity.*;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.FastJsonNicknameKey;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.FastJsonPoprKey;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.FastJsonProfileTypeIndicatorKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FastJsonConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(FastJsonConfiguration.class);

    public FastJsonConfiguration() {
        LOGGER.info("正在配置 FastJson autotype 白名单");
        ParserConfig.getGlobalInstance().addAccept(FastJsonProfile.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonUser.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonProfileTypeIndicator.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonProfileTypeIndicatorKey.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonPopr.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonPoprKey.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonNickname.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonNicknameKey.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonAvatarInfo.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonNotification.class.getCanonicalName());
        LOGGER.debug("FastJson autotype 白名单配置完毕");
    }
}
