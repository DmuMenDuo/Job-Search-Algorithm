package me.menduo.ALi;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-11 12:18
 **/


/**
 *
 * 多线程顺序打印1-100
 *
 * 1. 使用Object的wait和notify实现。当发现当前值不能输出时，就wait,否则输出并唤醒其他线程。synchronize
 *
 * 2. 使用reentrantlock 锁，获得锁之后检测时候能打印，能就打印，否则 让出锁。
 *
 * 3. val
 *
 */
public class ThreadPrint implements Runnable{

    private int my = 0;
    private static int value = 1;
    private ReentrantLock reentrantLock;

    public ThreadPrint(int my,ReentrantLock reentrantLock) {
        this.my = my;
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        while (value <= 100) {
            reentrantLock.lock();
            if (value<=100 && value % 3 == my) {
                System.out.println(value++);
            }
            reentrantLock.unlock();

        }

    }


    public static void main(String[] args) {
        //创建三个线程，三个线程start;
        ReentrantLock lock = new ReentrantLock();
        ThreadPrint threadPrint = new ThreadPrint(1,lock);
        Thread thread = new Thread(threadPrint);
        ThreadPrint threadPrint1 = new ThreadPrint(2,lock);
        Thread thread2 = new Thread(threadPrint1);
        ThreadPrint threadPrint2 = new ThreadPrint(0,lock);
        Thread thread3 = new Thread(threadPrint2);

        thread.start();
        thread2.start();
        thread3.start();

    }
}
