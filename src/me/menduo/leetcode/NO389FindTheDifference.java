package me.menduo.leetcode;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-09 12:16
 **/
public class NO389FindTheDifference {
    public char findTheDifference(String s, String t) {
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        char result = tchars[0];
        for (int i = 0; i <s.length() ; i++) {
            result^=schars[i];
            result^=tchars[i+1];
        }
        return result;
    }
}
