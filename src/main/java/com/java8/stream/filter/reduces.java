package com.java8.stream.filter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/11/2.
 */
public class reduces {

    List<Integer> numbers = Arrays.asList(1,2,3);
    public int sums(){
        return numbers.stream().reduce(0,(a,b)->a+b);
    }
    public static void main(String[] args){
        reduces r = new reduces();
        System.out.println(r.sums());
    }
}
