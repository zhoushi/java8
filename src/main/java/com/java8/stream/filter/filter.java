package com.java8.stream.filter;

import com.java8.bean.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Administrator on 2016/10/31.
 */
public class filter {

    /**
     * 用谓词筛选
     * @return
     */
    public List<Dish> predications(){
        return Dish.menu.stream().filter(Dish::isVegetarian).collect(toList());
    }

    /**
     * 筛选各异的元素
     */
    public void distincts(){
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream()
                .filter(i->i%2==0)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 截断流
     * @return
     */
    public List<Dish> limits(){
        return Dish.menu.stream().filter(d->d.getCalories()>300)
                .limit(3).collect(toList());
    }
}
