# ChangeLog

### Release_1.3.0_20230207_build_A

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
