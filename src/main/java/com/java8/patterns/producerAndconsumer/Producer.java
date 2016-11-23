package com.java8.patterns.producerAndconsumer;

import java.util.Random;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Administrator on 2016/11/23.
 */
public class Producer {

    private final ItemQueue queue;

    private final String name;

    private int itemId;

    public Producer(String name,ItemQueue queue){
        this.name = name;
        this.queue = queue;
    }

    public void produce() throws InterruptedException {
        Item item = new Item(name,itemId++);
        queue.put(item );
        Random random = new Random();
        Thread.sleep(random.nextInt(2000));
    }
}
