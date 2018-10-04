package me.menduo.top100;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2018-10-04 13:38
 **/
public class NO375GuessNumberHigherOrLowerII {
    //minimax 极小极大算法
    // 最小化对手的最大收益
    public int getMoneyAmount(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <=n ; i++) {
            for(int j=i-1;j>=1;j--){
                int min = Integer.MAX_VALUE;
                for (int k = j+1; k <i ; k++) {
                    min = Math.min(min,Math.max(k+dp[j][k-1],k+dp[k+1][i]));
                }
                dp[j][i] = j == (i-1)?j:min;
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        NO375GuessNumberHigherOrLowerII no375GuessNumberHigherOrLowerII = new NO375GuessNumberHigherOrLowerII();
        System.out.println(no375GuessNumberHigherOrLowerII.getMoneyAmount(10));
    }
}
