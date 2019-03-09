package me.menduo.tencent;

import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-09 19:26
 **/
public class One {

    /**
     * 6 7
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a>=b) System.out.println(1);
            else
                System.out.println(b/a+1);
        }
    }
}
