package com.java8.Future;

import java.util.Arrays;
import java.util.List;
import static com.java8.Future.Util.format;

import static java.util.stream.Collectors.toList;

/**
 * Created by Administrator on 2016/11/14.
 */
public class MoreProduct {

    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("ShopEasy"));


    //采用顺序查询所有商店的方式实现的

//    public List<String> findPrices(String product){
//        return shops.stream()
//                .map((ShopBean shopss) -> String.format("%s price is %.2f",shopss.getName(),
//                        shopss.getPrice(product)))
//                .collect(toList());
//    }

    //使用并行流对请求进行并行操作
//    public List<String> findPrices(String product){
//        return shops.parallelStream()
//                .map((ShopBean shorts)->String.format("%s price is %.2f",shorts.getName(),
//                        shorts.getPrice(product))).collect(toList());

//    }



}
