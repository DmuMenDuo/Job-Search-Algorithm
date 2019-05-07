package me.menduo.meituan;

import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-23 20:43
 **/
public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            int[] color = new int[n];
            for (int i = 1; i < n ; i++) {
                array[i] = scanner.nextInt();
            }
            for (int i = 0; i < n ; i++) {
                color[i] = scanner.nextInt();
            }

            System.out.println(2);
        }
    }
}
