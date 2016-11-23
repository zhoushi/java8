package com.java8.patterns.factory.Abmethod;

/**
 * Created by Administrator on 2016/11/23.
 */
public class App {

    public static void main(String[] args){
        WeaponFactory factory = WeaponFactory.factory(builder -> {
            builder.add(WeaponType.AXE,Axe::new);
        });

        Weapon axe = factory.create(WeaponType.AXE);
        System.out.println(axe);
    }
}
