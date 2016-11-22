package com.java8.patterns.builder;

/**
 * Created by Administrator on 2016/11/21.
 */
public enum Weapon {

    DAGGER,SWORD,AXE,WARHAMMER,BOW;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
