package com.java8.patterns.builder;

/**
 * Created by Administrator on 2016/11/21.
 */
public enum  HairType {

    BALD("bald"), SHORT("short"), CURLY("curly"), LONG_STRAIGHT("long straight"), LONG_CURLY(
            "long curly");
    private String title;

    HairType(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
