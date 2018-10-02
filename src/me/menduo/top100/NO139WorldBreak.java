package me.menduo.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2018-10-02 16:52
 **/
public class NO139WorldBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 0; j < i ; j++) {
                if(dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }

            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {
        NO139WorldBreak no139WorldBreak = new NO139WorldBreak();
        //s = "leetcode", wordDict = ["leet", "code"]
        System.out.println(no139WorldBreak.wordBreak("leetcode", Arrays.asList("leet","code")));
        //s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
        System.out.println(no139WorldBreak.wordBreak("catsandog",Arrays.asList("cats", "dog", "sand", "and", "cat")));

    }
}
