package me.menduo.pinduoduo;

import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-03 19:13
 **/
public class Four {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String word1 = scanner.next();
            String word2 = scanner.next();
            int[][] dp = new int[word1.length()+1][word2.length()+1];
            for (int i = 1; i < dp[0].length ; i++) {
                dp[0][i] = dp[0][i-1] +1;
            }
            for (int i = 1; i < dp.length ; i++) {
                dp[i][0] = dp[i-1][0] +1;
            }
            for (int i = 1; i <= word1.length() ; i++) {
                for (int j = 1; j <= word2.length() ; j++) {
                    if(word1.charAt(i-1) == word2.charAt(j-1))
                        dp[i][j] = dp[i-1][j-1];
                    else{
                        dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                    }
                }
            }
            System.out.println(dp[word1.length()][word2.length()]);
        }
    }
}
