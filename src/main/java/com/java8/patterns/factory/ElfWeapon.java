package com.java8.patterns.factory;

/**
 * Created by Administrator on 2016/11/23.
 */
public class ElfWeapon implements Weapon {
    private WeaponType weaponType;

    public ElfWeapon(WeaponType weaponType){
        this.weaponType = weaponType;
    }

    @Override
    public String toString() {
        return "Elven " + weaponType;
    }

    @Override
    public WeaponType getWeaponType() {
        return weaponType;
    }
}
