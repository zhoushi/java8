package com.test.util;

/**
 * Created by Administrator on 2016/11/21.
 */
public class SBean {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
