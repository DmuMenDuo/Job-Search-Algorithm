package me.menduo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2018-11-17 23:25
 **/
public class NO898BitwiseOrsOfSubarrays {

    /**
     *  一段错误的尝试 TLE了
     */
    public int subarrayBitwiseORs2(int[] A) {
        int dp[][] = new int[A.length+1][A.length+1];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= A.length ; i++) {
            dp[i][i] = A[i-1];
            set.add(dp[i][i]);
        }
        for (int i = 1; i <= A.length ; i++) {
            for (int j = i+1; j <= A.length ; j++) {
                dp[i][j] = dp[i][j-1]|A[j-1];
                set.add(dp[i][j]);
            }
        }
        return set.size();
    }

    /**
     * JAVA AC不动了 虽然将复杂度降到了32N，还是TLE,用c++却过了
     * @param A
     * @return
     */
    public int subarrayBitwiseORs(int[] A) {
        int dp[][] = new int[A.length][A.length];
        Set<Integer> result = new HashSet<>();
        Set<Integer> tmp = new HashSet<>();
        for (int i = 0; i < A.length ; i++) {
            Set<Integer> set2 = new HashSet<>();
            set2.add(A[i]);
            for (int x:tmp) {
                set2.add(x|A[i]);
            }
            result.addAll(set2);
            tmp = set2;
        }
        return result.size();

    }

    public static void main(String[] args) {
        NO898BitwiseOrsOfSubarrays no898BitwiseOrsOfSubarrays = new NO898BitwiseOrsOfSubarrays();
        System.out.println(no898BitwiseOrsOfSubarrays.subarrayBitwiseORs(new int[]{1,2,4}));
    }
}
