package com.dwarfeng.familyhelper.clannad.stack.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateCreateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificatePermissionRemoveInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificatePermissionUpsertInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 证件处理器。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface CertificateOperateHandler extends Handler {

    /**
     * 创建证件。
     *
     * @param userKey               证件的所有者的主键。
     * @param certificateCreateInfo 证件的创建信息。
     * @return 生成的证件的主键。
     * @throws HandlerException 处理器异常。
     */
    LongIdKey createCertificate(StringIdKey userKey, CertificateCreateInfo certificateCreateInfo)
            throws HandlerException;

    /**
     * 更新证件。
     *
     * @param userKey               证件的所有者的主键。
     * @param certificateUpdateInfo 证件的更新信息。
     * @throws HandlerException 处理器异常。
     */
    void updateCertificate(StringIdKey userKey, CertificateUpdateInfo certificateUpdateInfo) throws HandlerException;

    /**
     * 删除证件。
     *
     * @param userKey        证件的所有者的主键。
     * @param certificateKey 证件的主键。
     * @throws HandlerException 处理器异常。
     */
    void removeCertificate(StringIdKey userKey, LongIdKey certificateKey) throws HandlerException;

    /**
     * 添加或更新证件的访客权限。
     *
     * @param ownerUserKey                    操作者的主键。
     * @param certificatePermissionUpsertInfo 权限添加信息。
     * @throws HandlerException 处理器异常。
     */
    void upsertPermission(
            StringIdKey ownerUserKey, CertificatePermissionUpsertInfo certificatePermissionUpsertInfo
    ) throws HandlerException;

    /**
     * 移除证件的访客权限。
     *
     * @param ownerUserKey                    操作者的主键。
     * @param certificatePermissionRemoveInfo 权限移除信息。
     * @throws HandlerException 处理器异常。
     */
    void removePermission(
            StringIdKey ownerUserKey, CertificatePermissionRemoveInfo certificatePermissionRemoveInfo
    ) throws HandlerException;
}
