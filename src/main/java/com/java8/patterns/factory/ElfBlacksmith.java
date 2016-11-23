package com.java8.patterns.factory;

/**
 * Created by Administrator on 2016/11/23.
 */
public class ElfBlacksmith implements Blacksmith {


    @Override
    public Weapon manufactureWeapon(WeaponType weaponType) {
        return new OrcWeapon(weaponType);
    }
}
