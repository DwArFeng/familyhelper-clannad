# ChangeLog

### Release_1.2.2_20220315_build_A

#### 功能构建

- 升级 `log4j2` 依赖版本至 `2.17.1`。

#### Bug修复

- (无)

#### 功能移除

- (无)

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
