package me.menduo.leetcode;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-09 12:06
 **/
public class NO441ArrangingCoins {
    public int arrangeCoins(int n) {
        return (int)(-1 + Math.sqrt(1 + (long)n << 3)) >> 1;
    }
}
