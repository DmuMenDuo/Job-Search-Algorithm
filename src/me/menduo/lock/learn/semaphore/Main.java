package me.menduo.lock.learn.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-13 13:01
 **/
public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10 ; i++) {
            new Worker(semaphore,i).start();
        }
    }
}

class Worker extends Thread{
    private Semaphore semaphore;
    private int i;
    public Worker(Semaphore semaphore,int i){
        this.semaphore = semaphore;
        this.i = i;
    }
    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("ing....:"+i);
            Thread.sleep(2000);
            semaphore.release();
            System.out.println("release...:"+i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
