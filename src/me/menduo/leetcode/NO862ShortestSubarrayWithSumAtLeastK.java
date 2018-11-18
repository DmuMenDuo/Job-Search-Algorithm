package me.menduo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * User: menduo email:demon9607@163.com
 * Date: 2018-07-03
 * Time: 21:01
 */
public class NO862ShortestSubarrayWithSumAtLeastK {

    /**
     * 滑动窗口
     */

    public int shortestSubarray(int[] A, int K) {
        if (A == null || A.length == 0) return -1;
        int result = Integer.MAX_VALUE;
        int[] tmp = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            tmp[i + 1] = tmp[i] + A[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <= A.length; i++) {
            //维持一个递增的队列，result是逼近某个值的最小值，突然变小的数是只会增加result的大小没有任何收益。
            while (!deque.isEmpty() && tmp[i] <= tmp[deque.getLast()])
                deque.removeLast();
            while (!deque.isEmpty() && tmp[i] >= tmp[deque.getFirst()] + K)
                result = Math.min(result, i - deque.removeFirst());
            deque.addLast(i);

        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * TLE
     *
     * @param A
     * @param K
     * @return
     */
    public int shortestSubarray2(int[] A, int K) {
        if (A == null || A.length == 0) return -1;
        int result = Integer.MAX_VALUE;
        int[][] dp = new int[A.length + 1][A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = i; j <= A.length; j++) {
                dp[i][j] = dp[i][j - 1] + A[j - 1];
                if (dp[i][j] >= K) result = Math.min(result, j - i + 1);
            }
        }
        if (result == Integer.MAX_VALUE) return -1;

        return result;
    }

    public static void main(String[] args) {
        NO862ShortestSubarrayWithSumAtLeastK no862ShortestSubarrayWithSumAtLeastK = new NO862ShortestSubarrayWithSumAtLeastK();
        System.out.println(no862ShortestSubarrayWithSumAtLeastK.shortestSubarray(new int[]{2, -1, 2}, 3));

        System.out.println(no862ShortestSubarrayWithSumAtLeastK.shortestSubarray(new int[]{1}, 1));
        System.out.println(no862ShortestSubarrayWithSumAtLeastK.shortestSubarray(new int[]{1, 2}, 4));
    }
}
