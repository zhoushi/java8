package com.java8.Functional;

/**
 * Created by Administrator on 2016/11/15.
 */
public class Tree {

    private String key;
    private int val;
    private Tree left,right;
    public Tree(String k,int v,Tree l,Tree r){
        key = k;
        val = v;
        left = l;
        right =r;
    }
}
