package me.menduo.top100;

/**
 * @program: LeetCode
 * @email: menduo96@gmail.com
 * @author: menduo
 * @create: 2018/9/26 下午11:32
 **/
public class NO63UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1 ) {
            if(obstacleGrid[0][0] == 0) return 1;
            else return 0;
        }
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1 || obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 1; i < obstacleGrid[0].length ; i++) {
            if( obstacleGrid[0][i-1] == 1 ){
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < obstacleGrid.length ; i++) {
            if( obstacleGrid[i-1][0] == 1 ){
                break;
            }
            dp[i][0] = 1;
        }

        for(int i=1;i< dp.length;i++) {
            for (int j = 1; j < dp[0].length ; j++) {
                if(obstacleGrid[i][j]!=1)
                    if(obstacleGrid[i][j-1] == 1 && obstacleGrid[i-1][j] == 1)
                       dp[i][j] = 0;
                    else if(obstacleGrid[i][j-1] == 1)
                        dp[i][j] = dp[i-1][j];
                    else if(obstacleGrid[i-1][j] == 1)
                        dp[i][j] = dp[i][j-1];
                    else
                        dp[i][j] = dp[i][j-1] + dp[i-1][j] ;

            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        NO63UniquePathsII no63UniquePathsII = new NO63UniquePathsII();
        System.out.println(no63UniquePathsII.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
