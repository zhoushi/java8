package com.java8.stream.filter;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Administrator on 2016/11/4.
 */
public class ForkJoinSumCalculator extends RecursiveTask {

    private final long[] numbers;
    private final int start;
    private final int end;

    public static final long THRESHOLD =10_100;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers,0,numbers.length);
    }

    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        return null;
    }
}
