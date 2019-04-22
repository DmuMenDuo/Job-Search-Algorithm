package me.menduo.yuewen;

import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-20 14:58
 **/
public class One {

    public static void main(String[] args) {
        int a0 = 1;
        int b0 = 128;
        Integer a1 = 1;
        Integer b1 = 128;
        Integer a2 = new Integer(1);
        Integer a3 = Integer.valueOf(1);
        Integer b3 = Integer.valueOf(128);
        Integer a4 = Integer.valueOf(1);
        Integer b4 = Integer.valueOf(128);
        System.out.println(a0 == a1); //true 首先a1返回的是常量池中的对象，又因为和int进行比较所以进行拆箱操作
        System.out.println(b0 == b1); //true 同上，但是会在堆上new一个新的对象然后自动拆箱
        System.out.println(a1 == a2); //false 首先 a1是缓存在常量池的对象，a2是在堆上new的对象
        System.out.println(a3 == a2); //false a3返回的是放在常量池中的对象，两个对象不是同一个
        System.out.println(a3 == a1); //true 返回都是常量池的中的对象，比较地址相等
        System.out.println(a3 == a4); //true 返回都是常量池进行缓存过的对象，比较地址相等
        System.out.println(b3 == b4); // false 两个堆上新new对象，具体看valueOf源码，在上面
        System.out.println(a0 == a4); // true 拆箱比较
        System.out.println(b0 == b4); //true 拆箱
        System.out.println(b1 == b4); //false 装箱返回new的堆上对象 和 new的堆上对象

        Bio bio = new Bio();
    }
    static class Bio {

    }
}
