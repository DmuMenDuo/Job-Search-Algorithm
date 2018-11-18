package me.menduo.leetcode;

/**
 * @program: LeetCode
 * @email: menduo96@gmail.com
 * @author: menduo
 * @create: 2018/9/25 下午9:08
 **/
public class NO64MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid.length+1];

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp.length;j++){
                if(i==1) {
                    dp[i][j]+=dp[i][j-1]+grid[i-1][j-1];
                    continue;
                }
                if(j==1) {
                    dp[i][j]+=dp[i-1][j]+grid[i-1][j-1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j]+dp[i-1][j]+grid[i-1][j-1],dp[i][j]+dp[i][j-1]+grid[i-1][j-1]);
            }
        }
        return dp[dp.length-1][dp.length-1];
    }
    public static void main(String[] args) {
        NO64MinimumPathSum no64MinimumPathSum = new NO64MinimumPathSum();
        System.out.println(no64MinimumPathSum.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
     System.out.println();
    }
}
