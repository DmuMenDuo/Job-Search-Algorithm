package me.menduo.tencent;

import java.util.Scanner;
import java.util.Stack;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-09 20:44
 **/
public class Five {
    /**
     * 4 3
     * 1 1 2 1
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int L = sc.nextInt();
            int[] c = new int[n];
            for (int i = 0; i <n ; i++) {
                c[i] = sc.nextInt();
            }
            System.out.println(soluction(n,L,c));
        }
    }

    private static int soluction(int n,int L,int[] c){
        //弃疗
        return 0;
    }



}
