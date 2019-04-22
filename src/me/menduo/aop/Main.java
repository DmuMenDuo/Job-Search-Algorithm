package me.menduo.aop;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-17 15:00
 **/
public class Main {
    public static void main(String[] args) {
        Father son = FatherProxy.newInstance(new Son1());
        son.sayHello();

        Father son2 = FatherProxy.newInstance(new Son2());
        son2.sayHello();
    }
}
