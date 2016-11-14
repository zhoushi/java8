package com.java8.stream.filter;

/**
 * Created by Administrator on 2016/11/3.
 */

import com.java8.bean.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

/**
 * 用流收集数据
 */
public class Collectorss {

//函数式是做什么，而不是如何做

    enum CaloricLevel { DIET, NORMAL, FAT };

    public long countDish(){
        return Dish.menu.stream().count();
    }

    public long countDishs(){
        return Dish.menu.stream().collect(Collectors.counting());
    }

    public Optional<Dish> comparatorMix(){

        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);

        return Dish.menu.stream().collect(maxBy(dishComparator));
    }

    /**
     * 单级分组
     * @return
     */
    public Map<Dish.Type,List<Dish>> dishesByType (){
        return Dish.menu.stream().collect(groupingBy(Dish::getType));
    }

    /**
     * 多级分组
     */
    public Map<Dish.Type,Map<CaloricLevel,List<Dish>>> moreDishesByType(){
//        return Dish.menu.stream().collect(
//                groupingBy(dish -> {
//                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
//                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
//                    else return CaloricLevel.FAT;
//                } ));
        return null;
    }
}
