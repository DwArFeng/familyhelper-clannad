package com.dwarfeng.familyhelper.clannad.stack.dao;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Nickname;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NicknameKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 昵称数据访问层。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public interface NicknameDao extends BatchBaseDao<NicknameKey, Nickname>, PresetLookupDao<Nickname> {
}
