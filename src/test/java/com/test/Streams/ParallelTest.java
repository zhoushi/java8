package com.test.Streams;

import com.java8.stream.parallelStream.ParallelApi;
import org.junit.Test;

/**
 * Created by Administrator on 2016/11/23.
 */
public class ParallelTest {
    ParallelApi parallelApi = new ParallelApi();

    @Test
    public void timeTest(){
        System.out.println("Sequetial sum done in:"+
                parallelApi.measureSumPerf(ParallelApi::sequentialSumk,10_000_000)+"msecs");
    }


}
