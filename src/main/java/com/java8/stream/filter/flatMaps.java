package com.java8.stream.filter;

import com.java8.bean.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


/**
 * Created by Administrator on 2016/11/2.
 */
public class flatMaps {
    List<String> words = Arrays.asList("Java8","Lambdas","In","Action");
    /**
     * 映射map
     */
    public List<String> DishToString(){
        return Dish.menu.stream().map((Dish d)->d.getName()).collect(toList());
    }
    /**
     * 映射flatMap
     */
    public List<String> flatMaps(){
        return words.stream().map(w->w.split("")).flatMap(Arrays::stream)
                .distinct().collect(Collectors.toList());
    }

}
