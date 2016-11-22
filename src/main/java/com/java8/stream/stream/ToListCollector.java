package com.java8.stream.stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;


import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

/**
 * Created by Administrator on 2016/11/22.
 *
 * toList()方法的重写
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {
    @Override
    public Supplier<List<T>> supplier() {//创建集合操作的起始点
        return ArrayList::new;//建立新的结果容器
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;//将元素添加到结果容器
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1,list2)->{
            list1.addAll(list2);
            return list1;
        };//合并两个结果容器
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();//对结果容器应用最终转换
    }

    /**
     * 会返回一个不可变的Characteristics集合
     * UNORDERED:归约结果不受六中项目的遍历和积累顺序的影响
     * CONCURRENT：
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH,CONCURRENT));
    }
}
