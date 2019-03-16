package me.menduo.jrtt;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-15 23:21
 **/
public class zuidayingshe {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            long[] x =new long[10];
            for (int i = 0; i < n ; i++) {
                char[] a = sc.next().toCharArray();
                for(int j = a.length-1;j>=0;j--) {
                    x[a[j]-'A']+= Math.pow(10,a.length-j-1);
                }
            }
            Arrays.sort(x);
            long max = 0;
            for (int i = 0; i <=9 ; i++) {
                max += x[i]*i;
            }
            System.out.println(max);
        }
    }
}
