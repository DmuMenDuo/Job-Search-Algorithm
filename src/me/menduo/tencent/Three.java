package me.menduo.tencent;

import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-09 20:30
 *
 **/
public class Three {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n ; i++) {
                array[i] = sc.nextInt();
            }
            int[][] dp = new int[2001][2001];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= s; j++) {

                    dp[i][j] += 2 * dp[i - 1][j];
                    dp[i][j] %= 1000000007;
                    if (j > 0)
                        dp[i][j] += dp[i - 1][j - 1];
                    dp[i][j] %= 1000000007;
                }
            }
            System.out.println(dp[n][s]);
        }
    }
}

