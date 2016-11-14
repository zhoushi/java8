package com.java8.stream.filter;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2016/11/4.
 */
public class parallel {

    //单流从0+n
    public static long sequentialSum(long n){
        return Stream.iterate(1L,i->i+1)
                .limit(n)
                .reduce(0L,Long::sum);
    }

    //并行流0+n
    public static long parallelSum(long n){
        return Stream.iterate(1L,i->i+1)
                .limit(n)
                .parallel()
                .reduce(0L,Long::sum);
    }

    //测量对前n个自然数求和的函数的性能
    public long measureSumPerf(Function<Long,Long> adder,long n){
        long fastest = Long.MAX_VALUE;
        for (int i = 0;i<10;i++){
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }




    //避免共享可变状态，使用并行错误
    public static long sideEffectSum(long n){
        Acccumulator acccumulator=new Acccumulator();

        LongStream.rangeClosed(1,n).parallel().forEach(acccumulator::add);
        return acccumulator.total;
    }
}
class Acccumulator{
    public long total = 0;
    public void add(long value){
        total+=value;
    }
}
