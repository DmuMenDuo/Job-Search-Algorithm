package me.menduo.lock.learn.countdownlanch;

import java.util.concurrent.CountDownLatch;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-13 12:38
 **/
public class Main {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);



        for (int i = 0; i <2; i++) {
            new Thread(){
                @Override
                public void run() {
                    System.out.println("子线程执行耗时任务呀。。。");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            }.start();
        }

        try {
            System.out.println("等待子线程执行完毕");
            countDownLatch.await();
            System.out.println("他们执行完了。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
