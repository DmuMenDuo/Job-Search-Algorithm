package me.menduo.tencent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-07 20:25
 **/
public class Youqudeshuzi {
    /**
     * 小Q今天在上厕所时想到了这个问题：有n个数，两两组成二元组，相差最小的有多少对呢？相差最大呢？
     *
     *
     * 输入描述:
     *
     *  输入包含多组测试数据。
     *
     *  对于每组测试数据：
     *
     *  N - 本组测试数据有n个数
     *
     *  a1,a2...an - 需要计算的数据
     *
     *  保证:
     *
     *  1<=N<=100000,0<=ai<=INT_MAX.
     *
     *
     * 输出描述:
     *
     * 对于每组数据，输出两个数，第一个数表示差最小的对数，第二个数表示差最大的对数。
     *
     *
     * 输入例子1:
     * 6
     * 45 12 45 32 5 6
     *
     * 输出例子1:
     * 1 2
     */
    private static void find(int[] arrays) {
        if (arrays.length == 0) {
            System.out.println("0 0");
            return;
        }
        Arrays.sort(arrays);
        if(arrays[0]==arrays[arrays.length-1]) {
            int tmp = arrays.length * (arrays.length-1) / 2;
            System.out.println(tmp + " " + tmp);
        }

        Map<Integer,Integer> map_count = new HashMap<>();
        for (int i = 0; i < arrays.length ; i++) {
            if(map_count.containsKey(arrays[i])){
                map_count.put(arrays[i],map_count.get(arrays[i])+1);
            }else {
                map_count.put(arrays[i],1);
            }
        }

        int cont = 0;
        if(map_count.size()==arrays.length) {
            int min = Math.abs(arrays[1]-arrays[0]);
            for (int i = 0; i <arrays.length-1 ; i++) {
                if(arrays[i+1]-arrays[i]==min){
                    cont++;
                }else if (arrays[i+1]-arrays[i]<min){
                    min = arrays[i+1]-arrays[i];
                    cont=1;
                }
            }

        } else {
            for(Integer key:map_count.keySet()){
                int val = map_count.get(key);
                if(val>1) {
                    cont+= (val*(val-1))/2;
                }
            }
        }

        int max = map_count.get(arrays[0]) * map_count.get(arrays[arrays.length-1]);
        System.out.println(cont + " " + max);
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            int[] array = new int[count];
            for (int i = 0; i < count ; i++) {
                array[i] = scanner.nextInt();
            }
            find(array);
        }
    }
}
