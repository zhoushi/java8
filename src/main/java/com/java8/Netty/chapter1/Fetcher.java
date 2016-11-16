package com.java8.Netty.chapter1;

/**
 * Created by Administrator on 2016/11/16.
 */
public interface Fetcher {

    void fetchData(FetcherCallback callback);
}
