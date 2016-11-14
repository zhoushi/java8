package com.java8.Future;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2016/11/14.
 */
public class Shop {

    public Shop(String product){

    }

    //同步
    public double getPrice(String product){
        return calculatePrice(product);
    }

    public static void delay(){
        try {
            Thread.sleep(1000L);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    //同步
    private double calculatePrice(String product){
        delay();
        Random random = new Random();
        return random.nextDouble()*product.charAt(0)+product.charAt(1);
    }

    //异步
    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(()->{
            double price = calculatePrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }

    //异步处理异常
    public Future<Double> getPriceAsyncException(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(
                ()->{
                    try {
                        double price = calculatePrice(product);
                        futurePrice.complete(price);
                    }catch (Exception ex){
                        //抛出导致失败的异常，完成这次Future操作
                        futurePrice.completeExceptionally(ex);
                    }
                }
        ).start();
        return futurePrice;
    }

    //使用工厂方式
    public Future<Double> getPriceAsyncFactory(String product){
        return CompletableFuture.supplyAsync(()->calculatePrice(product));
    }



}
