package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.ProfileUpdateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Popr;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Profile;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.familyhelper.clannad.stack.handler.ProfileOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.PoprMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.ProfileMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProfileOperateHandlerImpl implements ProfileOperateHandler {

    private final ProfileMaintainService profileMaintainService;
    private final PoprMaintainService poprMaintainService;

    private final OperateHandlerValidator operateHandlerValidator;

    public ProfileOperateHandlerImpl(
            ProfileMaintainService profileMaintainService,
            PoprMaintainService poprMaintainService,
            OperateHandlerValidator operateHandlerValidator
    ) {
        this.profileMaintainService = profileMaintainService;
        this.poprMaintainService = poprMaintainService;
        this.operateHandlerValidator = operateHandlerValidator;
    }

    @Override
    public void updateProfile(StringIdKey userKey, ProfileUpdateInfo profileUpdateInfo) throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 根据 profileUpdateInfo 以及更新的规则设置 个人简介 实体。
            Profile profile = new Profile(
                    userKey, profileUpdateInfo.getName(), profileUpdateInfo.getIdNumber(),
                    profileUpdateInfo.getIdType(), profileUpdateInfo.getBirthday(), profileUpdateInfo.getGender(),
                    profileUpdateInfo.getBloodType(), profileUpdateInfo.getNationality(),
                    profileUpdateInfo.getFamilyAddress(), profileUpdateInfo.getPhoneNumber(),
                    profileUpdateInfo.getEmailAddress(), profileUpdateInfo.getEmployer(),
                    profileUpdateInfo.getJobPosition(), profileUpdateInfo.getEmployerAddress(),
                    profileUpdateInfo.getJobTitle(), profileUpdateInfo.getLatestSchoolName(),
                    profileUpdateInfo.getEducationalLevel(), profileUpdateInfo.getEducationalBackground(),
                    profileUpdateInfo.getPoliticalStatus(), profileUpdateInfo.getMaritalStatus(),
                    profileUpdateInfo.getRemark()
            );

            // 3. 插入或更新个人简介实体。
            profileMaintainService.insertOrUpdate(profile);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void addGuestPermission(StringIdKey ownerUserKey, StringIdKey guestUserKey) throws HandlerException {
        try {
            // 1. 如果用户主键与访客主键一致，则什么也不做。
            if (Objects.equals(ownerUserKey, guestUserKey)) {
                return;
            }

            // 2. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(ownerUserKey);
            operateHandlerValidator.makeSureUserExists(guestUserKey);

            // 3. 确认个人简介存在。
            operateHandlerValidator.makeSureProfileExists(ownerUserKey);

            // 4. 通过入口信息组合权限实体，并进行插入或更新操作。
            Popr popr = new Popr(
                    new PoprKey(ownerUserKey.getStringId(), guestUserKey.getStringId()),
                    "赋予用户 " + guestUserKey.getStringId() + " 访客权限"
            );
            poprMaintainService.insertOrUpdate(popr);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void removeGuestPermission(StringIdKey ownerUserKey, StringIdKey guestUserKey) throws HandlerException {
        try {
            // 1. 如果用户主键与访客主键一致，则什么也不做。
            if (Objects.equals(ownerUserKey, guestUserKey)) {
                return;
            }

            // 2. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(ownerUserKey);
            operateHandlerValidator.makeSureUserExists(guestUserKey);

            // 3. 确认个人简介存在。
            operateHandlerValidator.makeSureProfileExists(ownerUserKey);

            // 5. 通过入口信息组合权限实体主键，并进行存在删除操作。
            PoprKey poprKey = new PoprKey(ownerUserKey.getStringId(), guestUserKey.getStringId());
            poprMaintainService.deleteIfExists(poprKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void resetGuestPermission(StringIdKey ownerUserKey, Collection<StringIdKey> guestUserKeys)
            throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(ownerUserKey);
            for (StringIdKey guestUserKey : guestUserKeys) {
                operateHandlerValidator.makeSureUserExists(guestUserKey);
            }

            // 2. 确认个人简介存在。
            operateHandlerValidator.makeSureProfileExists(ownerUserKey);

            // 3. 查询并删除个人简介对应的所有权限。
            List<PoprKey> poprKeys = poprMaintainService.lookup(
                    PoprMaintainService.CHILD_FOR_PROFILE, new Object[]{ownerUserKey}
            ).getData().stream().map(Popr::getKey).collect(Collectors.toList());
            poprMaintainService.batchDeleteIfExists(poprKeys);

            // 4. 遍历集合，组合权限实体列表。
            List<Popr> poprs = guestUserKeys.stream().distinct().filter(
                    key -> !Objects.equals(ownerUserKey, key)
            ).map(
                    key -> new Popr(
                            new PoprKey(ownerUserKey.getStringId(), key.getStringId()),
                            "赋予用户 " + key.getStringId() + " 访客权限"
                    )
            ).collect(Collectors.toList());
            if (poprs.isEmpty()) {
                return;
            }
            poprMaintainService.batchInsert(poprs);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
