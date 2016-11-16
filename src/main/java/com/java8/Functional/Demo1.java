package com.java8.Functional;

/**
 * Created by Administrator on 2016/11/15.
 */

/**
 * 函数式demo
 */
public class Demo1 {

    public static TrainJourney link(TrainJourney a,TrainJourney b){
        if (a==null)
            return b;
        TrainJourney t = a;
        while (t.onward!=null){
            t = t.onward;
        }
        t.onward = b;
        return a;
    }

    public static TrainJourney append(TrainJourney a,TrainJourney b){
        return a==null?b:new TrainJourney(a.price,append(a.onward,b.onward));
    }
}
