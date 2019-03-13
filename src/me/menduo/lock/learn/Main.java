package me.menduo.lock.learn;

import java.util.concurrent.CyclicBarrier;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-11 14:09
 **/
public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        Producer producer = new Producer(model);
        Consumer consumer = new Consumer(model);
        consumer.consume();
        producer.produce("hello");
        producer.produce("world");
        consumer.consume();
        producer.produce("hahaha");
        consumer.consume();
        producer.produce("nihaoya");
        consumer.consume();
        consumer.consume();
        producer.produce("啥玩意");
    }
}
