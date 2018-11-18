package me.menduo.leetcode;

/**
 * @program: LeetCode
 * @email: menduo96@gmail.com
 * @author: menduo
 * @create: 2018/9/25 下午9:47
 **/
public class NO62UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i <n ; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i <m ; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        NO62UniquePaths no62UniquePaths = new NO62UniquePaths();
        System.out.println(no62UniquePaths.uniquePaths(7,3));
    }
}
