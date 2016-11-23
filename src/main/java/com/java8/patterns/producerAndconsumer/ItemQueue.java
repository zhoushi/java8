package com.java8.patterns.producerAndconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Administrator on 2016/11/23.
 */
public class ItemQueue {

    private BlockingQueue<Item> queue;

    public ItemQueue(){
        queue = new LinkedBlockingQueue<>();
    }

    public void put(Item item) throws InterruptedException {
        queue.put(item);
    }

    public Item take() throws InterruptedException {

        return queue.take();
    }
}
