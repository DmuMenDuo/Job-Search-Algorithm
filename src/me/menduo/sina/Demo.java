package me.menduo.sina;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-01-03 17:37
 **/
public class Demo {
    public static void add(int a){
        System.out.println("int");
    }
    public static void add(long a){
        System.out.println("double");
    }

    public static void main(String[] args) {

        Demo.add((long)2.0f);
        Demo.add(2L);
    }
}
