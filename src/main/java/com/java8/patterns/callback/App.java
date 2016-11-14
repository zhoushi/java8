package com.java8.patterns.callback;

/**
 * Created by Administrator on 2016/11/3.
 */
public class App {

    public static void main(String[] args){
        Task task = new SimpleTask();

        Callback c  = () -> System.out.println("可怕");
        task.executeWith(c);
    }
}
