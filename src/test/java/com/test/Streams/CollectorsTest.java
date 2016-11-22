package com.test.Streams;

import com.java8.stream.stream.CollectorsApi;
import com.java8.stream.stream.Dish;
import com.java8.stream.stream.ToListCollector;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.java8.stream.stream.Dish.menu;

/**
 * Created by Administrator on 2016/11/22.
 */
public class CollectorsTest {

    public static void main(String...args){

    }

    CollectorsApi collectorsApi = new CollectorsApi();

    @Test
    public void singleGroupby(){
        System.out.println(collectorsApi.dishesByCaloricLevel());
    }

    @Test
    public void twoGroupby(){
        System.out.println(collectorsApi.dishesByTypeCaloricLevel());
    }

    @Test
    public void collectorTest(){
        //toList() 自定义收集器
        List<Dish> dishList = menu.stream().collect(new ToListCollector<>());
        List<Dish> dishList1 = menu.stream().collect(Collectors.toList());

        dishList.stream().forEach(System.out::println);
    }
}
