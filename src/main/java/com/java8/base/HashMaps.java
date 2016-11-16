package com.java8.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/14.
 */
public class HashMaps {



    public static void main(String... args){
        Map<String,Object> map = new HashMap<>();
        map.put("key","value1");
        map.put("key","value2");
        map.put("key","value3");

        map.put("",new Object());

        map.get("key");
        System.out.println(map.get(""));
        map.get("");

        Object object = new Object();

        ArrayList arrayList = new ArrayList(Arrays.asList(1,2,3));
        System.out.println(arrayList.get(1));

    }
}
