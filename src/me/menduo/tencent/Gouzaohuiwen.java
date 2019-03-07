package me.menduo.tencent;

import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-07 18:15
 **/
public class Gouzaohuiwen {
    /**
     * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
     * 输出需要删除的字符个数。
     *
     * 输入描述:
     *
     * 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
     *
     *
     *
     * 输出描述:
     *
     * 对于每组数据，输出一个整数，代表最少需要删除的字符个数。
     */

    private static int buildHuiWen(String str) {
        char[] arrays = str.toCharArray();
        char[] re_arrays = new StringBuilder(str).reverse().toString().toCharArray();
        int[][] dp = new int[str.length()+1][str.length()+1];
        int res = 0;
        for (int i = 1; i <= str.length() ; i++) {
            for (int j = 1; j <= str.length() ; j++) {
                if(arrays[i-1]==re_arrays[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        res = dp[str.length()][str.length()];
        return str.length()-res;
    }


    public static void main(String[] args) {
        String text = "google";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            System.out.println(buildHuiWen(str));
        }


    }
}
