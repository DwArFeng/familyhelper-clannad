# ChangeLog

### Release_1.5.0_20241121_build_A

#### 功能构建

- 依赖优化。
  - 优化部分依赖的排除项，以避免潜在的 `netty` 版本冲突问题。

- 部分 dubbo 消费者服务注册配置添加 `check="false"` 属性。
  - generateService。

- 优化配置文件。
  - 优化 `application-context-database.xml`，使得更多属性可以在配置文件中配置。

- 为部分工具类中方法的入口参数增加 `@NotNull` 注解。
  - com.dwarfeng.fdr.impl.service.telqos.CommandUtils。

- 增加推送处理器的消息类型。
  - PushHandler.messageSent。

- 实现操作服务。
  - com.dwarfeng.familyhelper.clannad.stack.service.MessageAttachmentOperateService。
  - com.dwarfeng.familyhelper.clannad.stack.service.MessageBodyOperateService。
  - com.dwarfeng.familyhelper.clannad.stack.service.MessageOperateService。
  - com.dwarfeng.familyhelper.clannad.stack.service.MessageAuthorizationOperateService。

- 新增实体。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.Message。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageBodyInfo。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageAttachmentInfo。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageAuthorization。

- 优化 `node` 模块部分服务启停脚本的注释。
  - binres/familyhelper-start.bat。
  - binres/familyhelper-start.sh。

- 优化项目启停脚本设置程序的根目录的方式。

- 优化启停脚本的目录结构。

- 依赖升级。
  - 升级 `subgrade` 依赖版本为 `1.5.7.a` 并解决兼容性问题，以应用其新功能。
  - 升级 `spring` 依赖版本为 `5.3.39` 以规避漏洞。
  - 升级 `protobuf` 依赖版本为 `3.25.5` 以规避漏洞。
  - 升级 `jetty` 依赖版本为 `9.4.55.v20240627` 以规避漏洞。
  - 升级 `netty` 依赖版本为 `4.1.115.Final` 以规避漏洞。
  - 升级 `zookeeper` 依赖版本为 `3.9.3` 以规避漏洞。
  - 升级 `snowflake` 依赖版本为 `1.5.3.a` 以规避漏洞。
  - 升级 `dwarfeng-ftp` 依赖版本为 `1.2.2.a` 以规避漏洞。
  - 升级 `spring-terminator` 依赖版本为 `1.0.14.a` 以规避漏洞。
  - 升级 `spring-telqos` 依赖版本为 `1.1.11.b` 以规避漏洞。

#### Bug修复

- 修复 telqos 工具类中部分注解不正确的 bug。
  - com.dwarfeng.fdr.impl.service.telqos.CommandUtils。

- 补充 `application-context-*.xml` 文件中缺失的配置。
  - application-context-telqos.xml

- 修正 Hibernate 实体中的注解错误。
  - com.dwarfeng.familyhelper.clannad.impl.bean.entity.HibernateCertificateFileInfo。

#### 功能移除

- (无)

---

### Release_1.4.1_20240420_build_A

#### 功能构建

- 增加服务方法。
  - com.dwarfeng.familyhelper.clannad.stack.service.CertificateFileOperateService。

- 日志功能优化。
  - 优化默认日志配置，默认配置仅向控制台输出 `INFO` 级别的日志。
  - 优化日志配置结构，提供 `conf/logging/settings.xml` 配置文件及其不同平台的参考配置文件，以供用户自定义日志配置。
  - 优化日志配置结构，提供 `confext/logging-settings.xml` 配置文件，以供外部功能自定义日志配置。
  - 优化启动脚本，使服务支持新的日志配置结构。
  - 优化 `assembly.xml`，使项目打包时输出新的日志配置结构。
  - 优化 `confext/README.md`，添加新的日志配置结构的相关说明。

- dubbo 优化。
  - 优化 `dubbo/connection.properties` 中配置的键名。

- 增加预设的运维指令。
  - com.dwarfeng.springtelqos.api.integration.log4j2.Log4j2Command。

- 依赖升级。
  - 升级 `subgrade` 依赖版本为 `1.5.2.a` 以应用其新功能。
  - 升级 `spring-telqos` 依赖版本为 `1.1.9.a` 以应用其新功能。
  - 升级 `slf4j` 依赖版本为 `1.7.36` 以规避漏洞。

#### Bug修复

- 修复项目中部分依赖的异常代码偏移未能正确设置的 bug。
  - 修复 `subgrade` 依赖的异常代码偏移未能正确设置的 bug。
  - 修复 `snowflake` 依赖的异常代码偏移未能正确设置的 bug。

- 补全部分 bean 类中缺失的方法。
  - com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateFile。

#### 功能移除

- (无)

---

### Release_1.4.0_20240129_build_A

#### 功能构建

- 增加证件文件的缩略图机制。
  - 增加依赖 `thumbnailator` 以应用其功能，版本为 `0.4.20`。
  - 增加证件文件操作服务方法 `CertificateFileOperateService.downloadCertificateThumbnail`。
  - 上传证书文件时，自动生成缩略图。
  - 下载证书缩略图时，如果缩略图不存在，则自动生成缩略图。
  - 删除证件文件时，同时删除缩略图。

- 增加 `PusherAdapter`。
  - 建议任何插件的推送器实现都继承自该适配器。
  - 适配器对所有的事件推送方法都进行了空实现。
  - 解决了增加了新的事件时，旧的推送器实现必须实现新的方法的问题。
  - 从此以后，推送器增加新的事件，将被视作兼容性更新。

- 升级 spring-telqos 并应用其新功能。
  - 使用包扫描的方式注册指令。
  - 优化 `telqos/connection.properties` 中配置的键名。

- dwarfeng-ftp 优化。
  - 优化 FtpHandler 的扫描方式，使其符合最新版本标准。
  - 优化 FtpConstants 中的常量类型，使其更加符合 dwarfeng-ftp 的接口标准。

- dubbo 优化。
  - 将文件传输的服务协议改为 `hessian` 以提高性能。
  - 微服务添加分组配置。

- 优化文件格式。
  - 优化 `application-context-*.xml` 文件的格式。
  - 优化 `*.properties` 文件的格式。

- 依赖升级。
  - 升级 `snowflake` 依赖版本为 `1.5.1.a` 并解决兼容性问题，以应用其新功能。
  - 升级 `subgrade` 依赖版本为 `1.4.8.b` 并解决兼容性问题，以应用其新功能。
  - 升级 `dwarfeng-ftp` 依赖版本为 `1.1.13.a` 并解决兼容性问题，以应用其新功能。
  - 升级 `spring` 依赖版本为 `5.3.31` 以规避漏洞。
  - 升级 `mysql` 依赖版本为 `8.2.0` 以规避漏洞。
  - 升级 `dubbo` 依赖版本为 `2.7.22` 以规避漏洞。
  - 升级 `jetty` 依赖版本为 `9.4.51.v20230217` 以规避漏洞。
  - 升级 `netty` 依赖版本为 `4.1.104.Final` 以规避漏洞。
  - 升级 `zookeeper` 依赖版本为 `3.7.2` 以规避漏洞。
  - 升级 `guava` 依赖版本为 `32.0.1-jre` 以规避漏洞。
  - 升级 `spring-terminator` 依赖版本为 `1.0.12.a` 以规避漏洞。
  - 升级 `spring-telqos` 依赖版本为 `1.1.8.a` 以规避漏洞。

#### Bug修复

- 修复配置文件中的错误。
  - `opt/opt-pusher.xml` 中 `context:include-filter` 元素的 `expression` 属性值错误。

- 修复程序启动时所有的推送器均会被加载的问题。

#### 功能移除

- (无)

---

### Release_1.3.1_20230430_build_A

#### 功能构建

- 启停脚本优化。
  - 优化 Windows 系统的启动脚本。
  - 优化 Linux 系统的启停脚本。

- 依赖升级。
  - 升级 `spring` 依赖版本为 `5.3.27` 以规避漏洞。
  - 升级 `netty` 依赖版本为 `4.1.86.Final` 以规避漏洞。
  - 升级 `dubbo` 依赖版本为 `2.7.21` 以规避漏洞。
  - 升级 `subgrade` 依赖版本为 `1.3.3.a` 以规避漏洞。
  - 升级 `snakeyaml` 依赖版本为 `2.0` 以规避漏洞。
  - 升级 `spring-terminator` 依赖版本为 `1.0.11.a` 以规避漏洞。
  - 升级 `spring-telqos` 依赖版本为 `1.1.6.a` 以规避漏洞。
  - 升级 `snowflake` 依赖版本为 `1.4.11.a` 以规避漏洞。
  - 升级 `dwarfeng-ftp` 依赖版本为 `1.1.5.a` 以规避漏洞。

#### Bug修复

- 修复 `node` 模块打包时未包含 `conf/curator` 目录的问题。

- 修正生日祝福处理器对于 3月1日 判断行为异常的 bug。

#### 功能移除

- (无)

---

### Release_1.3.0_20230227_build_A

#### 功能构建

- 优化 `MapStruct` 实体映射 `Mapper` 接口的路径。

- 优化实体字段。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.Notification。

#### Bug修复

- (无)

#### 功能移除

- (无)

---

### Release_1.2.4_20230108_build_A

#### 功能构建

- 实现推送机制，并开发预设推送器。
  - com.dwarfeng.familyhelper.clannad.impl.handler.pusher.AbstractPusher。
  - com.dwarfeng.familyhelper.clannad.impl.handler.pusher.DrainPusher。
  - com.dwarfeng.familyhelper.clannad.impl.handler.pusher.LogPusher。
  - com.dwarfeng.familyhelper.clannad.impl.handler.pusher.MultiPusher。

- 实现生日祝福服务。
  - 实现生日祝福定时判断任务及其判断逻辑。
  - 实现生日祝福的推送机制。

- 为 `Profile` 实体增加全体查询功能。

- 使用 `MapStruct` 重构 `BeanTransformer`。

- 增加依赖。
  - 增加依赖 `protobuf` 以规避漏洞，版本为 `3.19.6`。
  - 增加依赖 `guava` 以规避漏洞，版本为 `31.1-jre`。
  - 增加依赖 `gson` 以规避漏洞，版本为 `2.8.9`。
  - 增加依赖 `snakeyaml` 以规避漏洞，版本为 `1.33`。
  - 增加依赖 `jackson` 以规避漏洞，版本为 `2.14.0`。
  - 增加依赖 `javax.servlet-api` 以规避漏洞，版本为 `4.0.1`。
  - 增加依赖 `jboss-logging` 以规避漏洞，版本为 `3.4.3.Final`。

- 插件升级。
  - 升级 `maven-deploy-plugin` 插件版本为 `2.8.2`。

- 依赖升级。
  - 升级 `mysql` 依赖版本为 `8.0.31` 以规避漏洞。
  - 升级 `jedis` 依赖版本为 `3.8.0` 以规避漏洞。
  - 升级 `spring-data-redis` 依赖版本为 `2.7.5` 以规避漏洞。
  - 升级 `dubbo` 依赖版本为 `2.7.18` 以规避漏洞。
  - 升级 `zookeeper` 依赖版本为 `3.5.7` 以规避漏洞。
  - 升级 `curator` 依赖版本为 `4.3.0` 以规避漏洞。
  - 升级 `hibernate-validator` 依赖版本为 `6.2.5.Final` 以规避漏洞。
  - 升级 `dutil` 依赖版本为 `beta-0.3.2.a` 以规避漏洞。
  - 升级 `snowflake` 依赖版本为 `1.4.10.a` 以规避漏洞。
  - 升级 `subgrade` 依赖版本为 `1.3.0.a` 以规避漏洞。
  - 升级 `dwarfeng-ftp` 依赖版本为 `1.1.2.a` 以规避漏洞。
  - 升级 `spring-terminator` 依赖版本为 `1.0.10.a` 以规避漏洞。
  - 升级 `spring-telqos` 依赖版本为 `1.1.5.a` 以规避漏洞。

- 优化 pom.xml 文件格式。

#### Bug修复

- (无)

#### 功能移除

- (无)

---

### Release_1.2.3_20221025_build_A

#### 功能构建

- 插件升级。
  - 升级 `maven-deploy-plugin` 插件版本为 `2.8.2`。

- 依赖升级。
  - 升级 `junit` 依赖版本为 `4.13.2` 以规避漏洞。
  - 升级 `spring` 依赖版本为 `5.3.20` 以规避漏洞。
  - 升级 `mysql` 依赖版本为 `8.0.28` 以规避漏洞。
  - 升级 `fastjson` 依赖版本为 `1.2.83` 以规避漏洞。
  - 升级 `dubbo` 依赖版本为 `2.7.18` 以规避漏洞。
  - 升级 `netty` 依赖版本为 `4.1.77.Final` 以规避漏洞。
  - 升级 `hibernate` 依赖版本为 `5.4.24.Final` 以规避漏洞。
  - 升级 `hibernate-validator` 依赖版本为 `6.0.21.Final` 以规避漏洞。
  - 升级 `log4j2` 依赖版本为 `2.17.2` 以规避漏洞。
  - 升级 `dutil` 依赖版本为 `beta-0.3.1.a` 以规避漏洞。
  - 升级 `snowflake` 依赖版本为 `1.4.9.a` 以规避漏洞。
  - 升级 `subgrade` 依赖版本为 `1.2.10.a` 以规避漏洞。
  - 升级 `dwarfeng-ftp` 依赖版本为 `1.0.2.a` 以规避漏洞。
  - 升级 `spring-terminator` 依赖版本为 `1.0.9.a` 以规避漏洞。
  - 升级 `spring-telqos` 依赖版本为 `1.1.4.a` 以规避漏洞。

- 新增实体。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.Certificate。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.CertificateFileInfo。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.Poce。

- 优化操作服务验证环节的代码结构。

- 完成实体的操作服务。
  - com.dwarfeng.familyhelper.clannad.stack.service.CertificateFileOperateService。
  - com.dwarfeng.familyhelper.clannad.stack.service.CertificateOperateService。

#### Bug修复

- (无)

#### 功能移除

- 删除不需要的依赖。
  - 删除 `joda-time` 依赖。
  - 删除 `commons-lang3` 依赖。
  - 删除 `commons-io` 依赖。
  - 删除 `httpcomponents` 依赖。

---

### Release_1.2.2_20220323_build_A

#### 功能构建

- 升级 `log4j2` 依赖版本至 `2.17.1`。

- 新增实体。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.Notification。

- 实现操作服务。
  - com.dwarfeng.familyhelper.clannad.stack.service.NotificationOperateService。

#### Bug修复

- (无)

#### 功能移除

- 移除 `spring-webmvc` 依赖。

---

### Release_1.2.1_20220203_build_A

#### 功能构建

- 升级 ftp 方案，增加断线重连等机制。

- 为 `dubbo` 增加超时时间的配置选项。

#### Bug修复

- (无)

#### 功能移除

- (无)

---

### Release_1.2.0_20220101_build_A

#### 功能构建

- 升级 `log4j2` 依赖版本为 `2.17.0` 以规避 `CVE-2021-45105` 漏洞。
- 优化 DTO 实体的名称，以符合其功能。

#### Bug修复

- (无)

#### 功能移除

- (无)

---

### Release_1.1.5_20211212_build_A

#### 功能构建

- 升级 `log4j2` 依赖版本为 `2.15.0` 以规避 `CVE-2021-44228` 漏洞。
- 修改存放 Avatar 文件的 ftp 路径。

#### Bug修复

- (无)

#### 功能移除

- (无)

---

### Release_1.1.4_20211110_build_A

#### 功能构建

- 新增实体。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.Nickname。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.AvatarInfo。

- 新增服务。
  - com.dwarfeng.familyhelper.clannad.stack.service.AvatarOperateService。

#### Bug修复

- (无)

#### 功能移除

- (无)

---

### Release_1.1.3_20211106_build_A

#### 功能构建

- (无)

#### Bug修复

- 修改 ProfileOperateService 服务接口中错误的方法名称。

- 修改 Profile 及其相关实体的错误注释。

#### 功能移除

- (无)

---

### Release_1.1.2_20211106_build_A

#### 功能构建

- (无)

#### Bug修复

- 修复 `HibernateProfileTypeIndicator` 中不正确的 JPA 注解。

- 修正 Profile 相关实体注解中不规范的命名。

- 修正调用 ServiceExceptionCodes.setExceptionCodeOffset 后，报警代码不更新的 bug。

#### 功能移除

- (无)

---

### Release_1.1.1_20211102_build_A

#### 功能构建

- 新增实体。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.User。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.ProfileTypeIndicator。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.Popr。

- 修改实体字段。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.Profile。

- 实现操作服务。
  - com.dwarfeng.familyhelper.clannad.stack.service.ProfileOperateService。

#### Bug修复

- (无)

#### 功能移除

- 删除实体。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.Profile。

---

### Release_1.1.0_20211029_build_A

#### 功能构建

- 将 GenderTypeIndicator 的主键类型改为字符串。

#### Bug修复

- (无)

#### 功能移除

- (无)

---

### Release_1.0.0_20211027_build_A

#### 功能构建

- 实体建立，单元测试通过。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.GenderTypeIndicator。
  - com.dwarfeng.familyhelper.clannad.stack.bean.entity.Profile。

- 程序架构搭建，运行测试通过，打包测试通过。

#### Bug修复

- (无)

#### 功能移除

- (无)
