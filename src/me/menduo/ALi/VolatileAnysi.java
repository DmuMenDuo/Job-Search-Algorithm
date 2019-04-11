package me.menduo.ALi;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-11 14:06
 **/
public class VolatileAnysi extends Thread {
    private static volatile boolean flag = false;
    @Override
    public void run() {
        while (!flag){}
    }


    public static void main(String[] args) throws InterruptedException {
        VolatileAnysi volatileAnysi = new VolatileAnysi();
        volatileAnysi.start();
        Thread.sleep(1000);
        flag = true;
    }
}
