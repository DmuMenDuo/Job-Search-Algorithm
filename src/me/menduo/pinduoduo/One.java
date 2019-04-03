package me.menduo.pinduoduo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-03 18:54
 **/
public class One {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] m = new int[n];
            for (int i = 0; i < n ; i++) {
                m[i] = scanner.nextInt();
            }

            Arrays.sort(m);
            int max = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0;i<=n/2-1;i++) {
                int tmp = m[i] + m[n-i-1];
                if(tmp > max) max = tmp;
                if(tmp < min) min = tmp;
            }
            System.out.println(max - min);

        }
    }
}
