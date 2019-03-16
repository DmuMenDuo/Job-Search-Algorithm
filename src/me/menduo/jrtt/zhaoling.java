package me.menduo.jrtt;

import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-16 10:01
 **/
public class zhaoling {
    public static void main(String[] args) {
        int sum = 1024;
        int[] array = new int[]{6,4,2,0};
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int N = sc.nextInt();
            if(N==1024){
                System.out.println(0);
                continue;

            }
            String L = Integer.toBinaryString(sum - N);
            int tmp = 0;
            int result = 0;
            for (int i = 0; i <array.length ; i++) {
                if(L.length()>array[i]){
                    String x = L.substring(tmp,L.length()-array[i]);
                    int m = Integer.parseInt(x,2);
                    result+=m;
                    tmp = L.length()-array[i];
                }
            }
            System.out.println(result);

        }
    }
}
