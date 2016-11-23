package com.java8.patterns.producerAndconsumer;

/**
 * Created by Administrator on 2016/11/23.
 */
public class Consumer {

    private final ItemQueue queue;

    private final String name;

    public Consumer(String name, ItemQueue queue) {
        this.name = name;
        this.queue = queue;
    }

    /**
     * Consume item from the queue
     */
    public void consume() throws InterruptedException {

        Item item = queue.take();
        System.out.println(String.format("Consumer [%s] consume item [%s] produced by [%s]", name,
                item.getId(), item.getProducer()));

    }
}
