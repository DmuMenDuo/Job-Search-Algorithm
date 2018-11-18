package me.menduo.leetcode;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2018-10-04 16:02
 **/
public class NO377CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=1;i<=target;i++){
            for (int j = 0; j < nums.length ; j++) {
                if(i>=nums[j]) dp[i] +=dp[i-nums[j]];
                else break;
            }
        }
        return dp[target];
    }


    //TLE
    int cont;
    public int combinationSum4_TLE(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        reverse(nums,target);
        return cont;
    }

    public void reverse(int[] nums,int target){
        if(target==0) {
            cont += 1;
            return;
        }
        if(target<0)return;
        for (int i = 0; i < nums.length ; i++) {
            reverse(nums,target-nums[i]);
        }

    }
    public static void main(String[] args) {
        NO377CombinationSumIV no377CombinationSumIV = new NO377CombinationSumIV();
        System.out.println(no377CombinationSumIV.combinationSum4(new int[]{1, 2, 3},4));
    }
}
