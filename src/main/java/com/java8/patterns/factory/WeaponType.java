package com.java8.patterns.factory;

/**
 * Created by Administrator on 2016/11/3.
 */
public enum WeaponType {

    SHORT_SWORD("short sword"),SPEAR("spear"),AXE("axe"),UNDEFINED("");

    private String title;

    WeaponType(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
