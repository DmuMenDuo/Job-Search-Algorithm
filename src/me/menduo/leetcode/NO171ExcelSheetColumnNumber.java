package me.menduo.leetcode;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-03 14:19
 **/
public class NO171ExcelSheetColumnNumber {
    /**
     * 26进制转10进制
     *
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            res = res * 26;
            res += chars[i] - 64;
        }
        return res;
    }
}
