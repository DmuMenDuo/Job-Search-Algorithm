package me.menduo.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-01-27 12:08
 **/
public class NO174DungeonGame {
    /**
     * ![推倒图](http://pic.menduo.xyz/20190127152735.png)
     * @param args
     */
    public static void main(String[] args) {
        NO174DungeonGame no174DungeonGame = new NO174DungeonGame();
        no174DungeonGame.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}});
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length+1][dungeon[0].length+1];
        for (int i = 0; i < dp.length ; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        dp[dp.length-1][dp[0].length-2]=1;
        for (int i = m-1; i>=0 ; i--) {
            for (int j = n-1; j>=0 ; j--) {
                dp[i][j] = Math.max(Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }

}
