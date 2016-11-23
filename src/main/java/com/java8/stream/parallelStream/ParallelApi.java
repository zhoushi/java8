package com.java8.stream.parallelStream;

/**
 * Created by Administrator on 2016/11/23.
 */

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 并行流的API
 */
public class ParallelApi {


    //1-n求和 s顺序流
    public static long sequentialSumk(long n){
        return Stream.iterate(1L,i->i+1)
                .limit(n)
                .reduce(0L,Long::sum);
    }

    //并行流
    public static long parallelSum(long n){
        return Stream.iterate(1L,i->i+1)
                .limit(n)
                .parallel()
                .reduce(0L,Long::sum);
    }

    //测试 顺序流和并行流
    public long measureSumPerf(Function<Long,Long> adder,long n){
        long fastest = Long.MAX_VALUE;
        for (int i=0;i<10;i++){
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime()-start)/1_000_000;
            System.out.println("Result: "+sum);
            if (duration<fastest){
                fastest = duration;
            }
        }
        return fastest;
    }


}
