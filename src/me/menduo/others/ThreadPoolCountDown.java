package me.menduo.others;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-16 14:29
 **/
public class ThreadPoolCountDown implements Runnable{
    private static CountDownLatch start = new CountDownLatch(1);
    private static CountDownLatch end = new CountDownLatch(10);
    @Override
    public void run() {

        try {
            start.await();
            System.out.println("我是子线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            end.countDown();
        }


    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService x = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10 ; i++) {
            x.submit(new ThreadPoolCountDown());
        }

        start.countDown();
        System.out.println("我是主线程");
        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
