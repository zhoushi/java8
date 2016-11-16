package com.java8.Netty.chapter1;

/**
 * Created by Administrator on 2016/11/16.
 */
public class Worker {

    public void doWork(){
        Fetcher fetcher = new MyFetcher(new Data(1,0));

        fetcher.fetchData(new FetcherCallback() {
            @Override
            public void onData(Data data) throws Exception {
                System.out.println("Data received: "+data);
            }

            @Override
            public void onError(Throwable cause) {
                System.out.println("An error accour"+cause.getMessage());
            }
        });
    }

    public static void main(String...args){
        Worker worker = new Worker();
        worker.doWork();
    }
}
