package me.menduo.lock.learn.cyclicbarrier;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-13 12:23
 **/
public class Main {
    public static void main(String[] args) {
        int n = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(n, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+":是我要开始做后续处理了");
            }
        });
        for (int i = 0; i <n ; i++) {
            new Writer(cyclicBarrier).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("可重用哦");
        for (int i = 0; i <n ; i++) {
            new Writer(cyclicBarrier).start();
        }


    }
}
