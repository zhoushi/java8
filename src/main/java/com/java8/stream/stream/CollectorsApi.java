package com.java8.stream.stream;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.java8.stream.stream.Dish.menu;
import static java.util.stream.Collectors.*;

/**
 * Created by Administrator on 2016/11/22.
 */
public class CollectorsApi {

    public static List<Transaction> transactions = Arrays.asList( new Transaction(Currency.EUR, 1500.0),
            new Transaction(Currency.USD, 2300.0),
            new Transaction(Currency.GBP, 9900.0),
            new Transaction(Currency.EUR, 1100.0),
            new Transaction(Currency.JPY, 7800.0),
            new Transaction(Currency.CHF, 6700.0),
            new Transaction(Currency.EUR, 5600.0),
            new Transaction(Currency.USD, 4500.0),
            new Transaction(Currency.CHF, 3400.0),
            new Transaction(Currency.GBP, 3200.0),
            new Transaction(Currency.USD, 4600.0),
            new Transaction(Currency.JPY, 5700.0),
            new Transaction(Currency.EUR, 6800.0) );

    //用指令式风格对交易按照货币分组
    public Map<Currency,List<Transaction>> transactionGroup(){

        Map<Currency,List<Transaction>> transactionsByCurrencies = new HashMap<>();

        for (Transaction transaction : transactions){

            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);

            if (transactionsForCurrency  == null){

                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency,transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }
        return transactionsByCurrencies;

    }

    public static class Transaction {
        private final Currency currency;
        private final double value;

        public Transaction(Currency currency, double value) {
            this.currency = currency;
            this.value = value;
        }

        public Currency getCurrency() {
            return currency;
        }

        public double getValue() {
            return value;
        }

        @Override
        public String toString() {
            return currency + " " + value;
        }
    }

    public enum Currency {
        EUR, USD, JPY, GBP, CHF
    }

    //groupingBy 创建的收集器

    /**
     * 1: 将流元素归约和汇总为一个值
     * 2: 元素分组
     * 3: 元素分区
     */

    //归约和汇总
    public long howManyDishes(){
//        return menu.stream().collect(Collectors.counting());
        return menu.stream().count();
    }

    //查找流中的最大值和最小值
    public Optional<Dish> mostCalorieDish(){
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);

        return menu.stream().collect(maxBy(dishComparator));
    }

    //汇总

    //计算平均数
    public double avgCaloriers(){
        return menu.stream().collect(averagingInt(Dish::getCalories));
    }

    //连接字符串
    public String shortMenu(){
        //joining通过StringBuilder来把生成的字符串逐个追加起来
//        return menu.stream().map(Dish::getName).collect(joining());

        return menu.stream().map(Dish::getName).collect(joining(", "));
    }

    //总热量
    public int totalCalories(){
        return menu.stream().collect(reducing(0,Dish::getCalories,(i,j)->i+j));
    }

    //热量最高的菜
    public Optional<Dish> mostCalorieDishs(){
        return menu.stream().collect(reducing((d1,d2)->d1.getCalories()>d2.getCalories()?d1:d2));
    }

    /**
     * 元素分组
     */

    public Map<Dish.Type,List<Dish>> dishesByType(){
        return menu.stream().collect(groupingBy(Dish::getType));
    }

    public enum CaloricLevel{DIET,NORMAL,FAT}

    //对菜单中的菜肴按照类型和热量进行分组
    public Map<CaloricLevel,List<Dish>> dishesByCaloricLevel(){

        return menu.stream().collect(
            groupingBy(
                    dish->{
                        if (dish.getCalories()<=400){
                            return CaloricLevel.DIET;
                        }else if (dish.getCalories()<=700){
                            return CaloricLevel.NORMAL;
                        }else {
                            return CaloricLevel.FAT;
                        }
                    }
            )
        );
    }

    //多级分组
    public Map<Dish.Type,Map<CaloricLevel,List<Dish>>> dishesByTypeCaloricLevel(){
        return menu.stream().collect(
            groupingBy(Dish::getType,
                    groupingBy(dish->{ // 进行二级分组
                        if (dish.getCalories()<=400){
                            return CaloricLevel.DIET;
                        }else if (dish.getCalories()<=700){
                            return CaloricLevel.NORMAL;
                        }else {
                            return CaloricLevel.FAT;
                        }
                            }

                    )
            )
        );
    }

    //按子组收集数据
    public Map<Dish.Type,Long> typesCount(){
        return menu.stream().collect(groupingBy(Dish::getType,counting()));
    }

    /**
     * 分区：由一个谓词（返回一个布尔值的函数）作为分类函数
     */
    public Map<Boolean,List<Dish>> partitionedMenu(){
        return menu.stream().collect(partitioningBy(Dish::isVegetarian));
    }


    //原始的分析是否是质数
    public Map<Boolean,List<Integer>> partitionPrimes(int n){
        return IntStream.rangeClosed(2,n).boxed().collect(partitioningBy(candidate->isPrime(candidate)));
    }


    public boolean isPrime(Integer candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);

        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }



}
