package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 生日祝福信息。
 *
 * @author DwArFeng
 * @since 1.2.4
 */
public class BirthdayBlessInfo implements Dto {

    private static final long serialVersionUID = -4678552960907938733L;

    private StringIdKey key;
    private String birthday;
    private int age;

    public BirthdayBlessInfo() {
    }

    public BirthdayBlessInfo(StringIdKey key, String birthday, int age) {
        this.key = key;
        this.birthday = birthday;
        this.age = age;
    }

    public StringIdKey getKey() {
        return key;
    }

    public void setKey(StringIdKey key) {
        this.key = key;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BirthdayBlessInfo{" +
                "key=" + key +
                ", birthday='" + birthday + '\'' +
                ", age=" + age +
                '}';
    }
}
