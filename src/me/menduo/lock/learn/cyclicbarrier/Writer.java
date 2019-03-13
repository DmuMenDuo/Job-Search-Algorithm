package me.menduo.lock.learn.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-13 12:20
 **/
public class Writer extends Thread {
    private CyclicBarrier cyclicBarrier;

    public Writer(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + ":正在进行写操作...");
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread()+":写操作执行完毕，等待其他人执行完...");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread()+":我可以继续执行啦");
    }
}
