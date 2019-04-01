package me.menduo.huawei;

import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-27 20:52
 **/
public class Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n  = scanner.nextInt();
            int[][] x = new int[n][n];
            for (int i = 0; i < n ; i++) {
                x[scanner.nextInt()][scanner.nextInt()] = 1;
            }
        }
    }
}
