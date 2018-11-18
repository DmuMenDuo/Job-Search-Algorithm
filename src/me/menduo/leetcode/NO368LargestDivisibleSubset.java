package me.menduo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NO368LargestDivisibleSubset {
    /**
     * dp数组代表的含义是nums[0-i]中能组成整除子集的个数的最大值 如果i能够除尽其之前的j 则dp[i] = max(dp[i],dp[j]+1)
     * max 记录dp数组中的最大值
     * <p>
     * 随意最后的结果序列应该是dp数组中从max递减到0且依次可以除尽的那一组
     *
     * @param nums input
     * @return output
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int dp[] = new int[nums.length];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (dp[i] == max) {
                if (res.size() < 1) {
                    res.add(nums[i]);
                    max--;
                } else if (res.get(res.size() - 1) % nums[i] == 0) {
                    res.add(nums[i]);
                    max--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NO368LargestDivisibleSubset no368LargestDivisibleSubset = new NO368LargestDivisibleSubset();
        System.out.println(Arrays.toString(no368LargestDivisibleSubset.largestDivisibleSubset(new int[]{1, 2, 3}).toArray()));
    }
}
