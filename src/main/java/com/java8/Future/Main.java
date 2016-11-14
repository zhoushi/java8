package com.java8.Future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2016/11/14.
 */
public class Main {

    public static void main(String ... args){
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();

        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime()-start)/1_000_000);
        System.out.println("Invocation returned after " + invocationTime
                + " msecs");
        //在计算商品价格的同时
        try {
           //得到价格
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");


    }

}
