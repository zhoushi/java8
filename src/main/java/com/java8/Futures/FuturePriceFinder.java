package com.java8.Futures;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by Administrator on 2016/11/14.
 */
//使用CompletableFuture发送异步请求
public class FuturePriceFinder {



    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("ShopEasy"));

    //使用定制的执行器
    private final Executor executor = Executors.newFixedThreadPool(shops.size(), new ThreadFactory() {

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });

    public List<CompletableFuture<String >> completableFutureList(String product){
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(()->shop.getName()+"price is"+shop.getPrice(product)))
                .collect(toList());
    }

    //异步请求,join不会抛出任何检测到的异常
    public List<String> priceFinderAsync(String product){
       List<CompletableFuture<String>> priceFutures = completableFutureList(product);

        //转换成List<String>
        List<String> prices = priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        return prices;
    }

    //最简单的方式实现Discount服务的findPrices方法
    public List<String> findPrices(String product){
        return shops.stream()
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(toList());
    }

    //以异步方式重构
    public List<String> findPricesAsync(String product){
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(()->shop.getPrice(product),executor))
                .map(future->future.thenApply(Quote::parse))
                .map(future->future.thenCompose(quote -> CompletableFuture.supplyAsync(
                        ()->Discount.applyDiscount(quote),executor
                ))).collect(toList());
        return priceFutures.stream().map(CompletableFuture::join).collect(toList());
    }

    //合并CompletableFuture

    //响应式CompletableFuture的completion事件
    public Stream<CompletableFuture<String>> findPricesStream(String product){
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(()->shop.getPrice(product),executor))
                .map(future->future.thenApply(Quote::parse))
                .map(future->future.thenCompose(quote -> CompletableFuture.supplyAsync(()->Discount.applyDiscount(quote),executor)));
    }


}
