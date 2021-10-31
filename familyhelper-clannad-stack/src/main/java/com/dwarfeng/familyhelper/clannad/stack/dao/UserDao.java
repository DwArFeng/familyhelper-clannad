package com.dwarfeng.familyhelper.clannad.stack.dao;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.User;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;

/**
 * 用户数据访问层。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public interface UserDao extends BatchBaseDao<StringIdKey, User> {
}
