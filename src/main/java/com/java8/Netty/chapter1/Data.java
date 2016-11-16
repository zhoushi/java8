package com.java8.Netty.chapter1;

/**
 * Created by Administrator on 2016/11/16.
 */
public class Data {

    private int n;
    private int m;

    public Data(int n,int m){
        this.n = n;
        this.m = m;
    }

    @Override
    public String toString() {
        int r =n/m;
        return n+"/"+m+"="+r;
    }
}
