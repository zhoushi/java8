package com.java8.patterns.callback;

/**
 * Created by Administrator on 2016/11/3.
 */
public abstract class Task {

    public final void executeWith(Callback callback){
        execute();
        if (callback!=null){
            callback.call();
        }
    }

    public abstract void execute();
}
