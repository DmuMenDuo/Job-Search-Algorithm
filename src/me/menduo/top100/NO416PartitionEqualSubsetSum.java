package me.menduo.top100;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2018-10-06 22:54
 **/
public class NO416PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length==0) return false;
        int sum = 0;
        for (int i = 0; i < nums.length ; i++) {
            sum += nums[i];
        }

        if (sum %2!=0) return false;
        else
            sum/=2;

        boolean[][] dp = new boolean[nums.length+1][sum+1];
        for (int i = 0; i < dp.length ; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <=nums.length ; i++) {
            for (int j = 1; j <= sum ; j++) {
                if(j>=nums[i-1]){

                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][sum];
    }
    public static void main(String[] args) {
        NO416PartitionEqualSubsetSum no416PartitionEqualSubsetSum = new NO416PartitionEqualSubsetSum();
        System.out.println(no416PartitionEqualSubsetSum.canPartition(new int[]{1,5,11,5}));
    }
}
