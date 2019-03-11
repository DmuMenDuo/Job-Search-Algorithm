package me.menduo.lock.learn;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-11 13:52
 **/
public class Model {

    private int size = 3;
    private ReentrantLock lock = new ReentrantLock();

    private Condition fullCondition = lock.newCondition();
    private Condition empyCondition = lock.newCondition();

    private ArrayList<String> blockQ = new ArrayList<>();

    public void produce(String x) throws InterruptedException {
        lock.lock();
        while (blockQ.size() >= size) {
            fullCondition.await();
            System.out.printf(Thread.currentThread() + "服务者--> %d " + "--> %d\n", blockQ.size(), size);
        }
        blockQ.add(x);
        empyCondition.signal();
        lock.unlock();

    }

    public String consume() throws InterruptedException {
        lock.lock();
        String result = "";

        while ((blockQ.size() <= 0)) {
            empyCondition.await();
            System.out.printf(Thread.currentThread() + "消费者--> %d " + "--> %d\n", blockQ.size(), size);
        }

        result = blockQ.remove(0);

        fullCondition.signal();
        lock.unlock();
        return result;

    }
}
