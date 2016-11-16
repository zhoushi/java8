package com.java8.Functional;

/**
 * Created by Administrator on 2016/11/15.
 */
public class TrainJourney {

    public int price;
    public TrainJourney onward;
    public TrainJourney(int p,TrainJourney t){
        price = p;
        onward =t;
    }
}
