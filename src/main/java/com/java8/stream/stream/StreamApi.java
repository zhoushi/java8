package com.java8.stream.stream;

import com.sun.corba.se.impl.naming.cosnaming.NamingUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.java8.stream.stream.Dish.menu;
import static java.util.stream.Collectors.toList;

/**
 * Created by Administrator on 2016/11/21.
 */
public class StreamApi {

    //内部迭代
    public List<Dish> getVegetarianDishes(){
        List<Dish> vegetarianDishes = new ArrayList<>();
        for (Dish d:menu){
            if (d.isVegetarian()){
                vegetarianDishes.add(d);
            }
        }
        return vegetarianDishes;
    }

    //java8内部迭代
    public List<Dish> getJava8VegetarianDishes(){
        return Dish.menu.stream().filter(dish -> dish.isVegetarian()).collect(toList());
    }

    //筛选
    public void distinctQ(){

        List<Integer> numbers = Arrays.asList(1,2,1,3,3);
        numbers.stream().filter(i->i%2 ==0)
                .distinct()
                .forEach(System.out::println);
    }

    //截短流
    public List<Dish> limitDish(){
        return menu.stream().filter(dish -> dish.getCalories() >300)
                .limit(3)
                .collect(toList());
    }

    //跳过元素,返回一个扔掉了前n个元素的流，如果流中元素不足n个，则返回一个空流
    public List<Dish> skipDish(){
        return menu.stream()
                .filter(dish -> dish.getCalories() >300)
                .skip(2)
                .collect(toList());
    }

    /**
     * 映射 将流中的元素转换成自己想要的元素
     */

    //map的用法
    public List<String> DishToName(){
        return menu.stream()
                .map(Dish::getName)
                .collect(toList());
    }

    public List<Integer> wordsInteger(){
        List<String> words =Arrays.asList("JAVA 8","Lambdas","In","Action");

        return words.stream().map(String::length)
                .collect(toList());
    }

    //流的扁平化
    //初始状态
    public List<String[]> wordsSplit(){
        List<String> words = Arrays.asList("Hello","World");

        return words.stream().map(word->word.split(""))
                .distinct()
                .collect(toList());
    }

    //Arrays stream
    public List<Stream<String>> ArraysStream(){
        String[] arrayOfWords = {"Goodbye","World"};

        Stream<String> stringStream = Arrays.stream(arrayOfWords);

        List<String> words = Arrays.asList("Hello","World");

        return words.stream().map(word->word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());
    }

    //flatMap方法让你把一个流中的每个值都换成另一个流，然后把所有的流连接起来成为一个流。
    public List<String> flatMapStream(){
        List<String> words = Arrays.asList("Hello","World");
        return words.stream()
                .map(w->w.split(""))//Stream<String[]>
                .flatMap(Arrays::stream)//Stream<String>
                .distinct()
                .collect(Collectors.toList());//List<String>
    }

    // [1,2,3,4,5]==>[1,4,9,16,25]
    public List<Integer> toDoubleMap(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        return numbers.stream().map(n->n*n)
                .collect(toList());
    }

    //[1,2,3]和[3,4]==>[(1,3),(1,4),(2,3),(2,4),(3,3)(3,4)]

    public List<int[]> toArraysMap(){
        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(3,4);

        return numbers1.stream()
                .flatMap(i->numbers2.stream()
                .map(j->new int[]{i,j})).collect(toList());
    }

    //find and Match

    //allMatch
    public boolean allMatchs(){
        return menu.stream().allMatch(d->d.getCalories() < 1000);
    }

    //find 查找第一个元素
    public Optional<Integer> findFrist(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        return numbers.stream().map(x->x*x).filter(x->x%3==0)
                .findFirst();
    }

    //规约

    public int reduces(){
        return menu.stream().map(d->1)
                .reduce(0,(a,b)->a+b);
    }

    /**
     * 构建流
     */

    //由值创建流
    public void streamOf(){
        //创建流
        Stream<String> stream = Stream.of("Java 8","Lambdas","In","Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
    }

    //由数组创建流

    public int ArraysStreams(){
       int[] numbers = {2,3,5,7,11,13};
        return  Arrays.stream(numbers).sum();
    }

    //由文件生成流




}
