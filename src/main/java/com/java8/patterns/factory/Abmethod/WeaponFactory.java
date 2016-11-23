package com.java8.patterns.factory.Abmethod;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by Administrator on 2016/11/23.
 */
public interface WeaponFactory {
    Weapon create(WeaponType name);

    static WeaponFactory factory(Consumer<Builder> consumer){
        HashMap<WeaponType,Supplier<Weapon>> map = new HashMap<>();
        consumer.accept(map::put);

        return name -> map.get(name).get();
    }
}
