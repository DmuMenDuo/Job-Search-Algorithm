package me.menduo.top100;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @email: menduo96@gmail.com
 * @author: menduo
 * @create: 2018/9/27 下午11:33
 **/
public class NO91DecodeWays {
    public int numDecodings(String s) {
        if(s.isEmpty () || (s.length ()>0 &&s.charAt (0) == '0' )) return 0;
        char[] chars = s.toCharArray ();
        int[] dp = new int[chars.length+1];
        dp[0] = 1;
        for (int i = 1; i < dp.length ; i++) {
            dp[i] = chars[i-1] == '0'?0:dp[i-1];
            if(i>1 && (chars[i-2]=='1'||chars[i-2]=='2'&&chars[i-1]<='6'))
                dp[i]+=dp[i-2];
        }
        return dp[dp.length-1];
    }
    public static void main(String[] args) {
        NO91DecodeWays no91DecodeWays = new NO91DecodeWays ();
        System.out.println (no91DecodeWays.numDecodings ("226"));
    }
}
