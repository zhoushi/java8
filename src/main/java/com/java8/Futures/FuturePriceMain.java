package com.java8.Futures;

import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Administrator on 2016/11/14.
 */
public class FuturePriceMain {

    private static FuturePriceFinder bestPriceFinder = new FuturePriceFinder();
    public static void main(String ... args){
        execute("CompletableFuture",()->bestPriceFinder.priceFinderAsync("myPhone7"));
    }

    private static void execute(String msg,Supplier<List<String>> s){
        long start = System.nanoTime();
        System.out.println(s.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(msg + " done in " + duration + " msecs");
    }
}
