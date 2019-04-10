package me.menduo.leetcode;

import java.util.Arrays;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-09 20:51
 **/
public class NO1024 {
    public int videoStitching(int[][] clips, int T) {
        int MaxV = 101;
        int[][] dp = new int[T+1][T+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],MaxV);
        }
        for (int k = 0; k < clips.length; k++) {
            int s = clips[k][0];
            int e = clips[k][1];

            for (int l = 1; l <= T; l++) {
                for (int i = 0; i <= T-l; i++) {
                    int j = i + l;
                    if (e < i || j < s) continue;
                    if (s <=i && j <= e) dp[i][j] = 1;
                    if (s <= i) dp[i][j] = Math.min(dp[i][j], dp[e][j] + 1);
                    if (j <= e) dp[i][j] = Math.min(dp[i][j], dp[i][s] + 1);
                    else dp[i][j] = Math.min(dp[i][j], dp[i][s] + 1 + dp[e][j]);
                }
            }
        }
        return dp[0][T] == MaxV ? -1:dp[0][T];
    }

    public static void main(String[] args) {
        NO1024 no1024 =new NO1024();
        System.out.println(no1024.videoStitching(new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}},10));
    }
}
