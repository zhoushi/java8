package com.test.Lambda;

/**
 * Created by Administrator on 2016/10/31.
 */

import com.java8.stream.filter.filter;
import com.java8.stream.filter.parallel;
import org.junit.Test;

/**
 * stream过滤器测试
 */
public class filterTest {
    filter filters = new filter();
    parallel p = new parallel();

    @Test
    public void filterTest1(){
        filters.predications();
    }

    @Test
    public void fiflterTest2(){
        filters.distincts();
    }

    @Test
    public void min(){

    }

    @Test
    public void parallelSte(){

//        System.out.println(p.measureSumPerf(parallel::sequentialSum,10_000_000));
        //并发求和
//        System.out.println(p.measureSumPerf(parallel::parallelSum,10_000_000));
        System.out.println(p.measureSumPerf(parallel::sideEffectSum,10_000_000));
    }

}
