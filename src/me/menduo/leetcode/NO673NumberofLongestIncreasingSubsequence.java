package me.menduo.leetcode;


/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2018-10-07 23:06
 **/
public class NO673NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0 ) return 0;
        int[] dp = new int[nums.length+1];
        int[] cont = new int[nums.length+1];
        int max = 1;
        dp[0] = cont[0]=1;
        for (int i = 1; i <nums.length ; i++) {
            dp[i]=cont[i] = 1;
            for (int j = 0; j <i ; j++) {
                if(nums[i]>nums[j] && dp[i]==dp[j]+1)
                    cont[i]+=cont[j];
                else if(nums[i]>nums[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    cont[i] = cont[j];
                }
            }
            max = Math.max(dp[i],max);
        }
        int res = 0;
        for (int i = 0; i < dp.length ; i++) {
            if(dp[i]==max) res+=cont[i];
        }
         return res;
    }
    public static void main(String[] args) {
        NO673NumberofLongestIncreasingSubsequence no673NumberofLongestIncreasingSubsequence = new NO673NumberofLongestIncreasingSubsequence();
//        System.out.println(no673NumberofLongestIncreasingSubsequence.findNumberOfLIS(new int[]{2,2,2,2,2}));
//        System.out.println(no673NumberofLongestIncreasingSubsequence.findNumberOfLIS(new int[]{1,3,5,4,7}));
        System.out.println(no673NumberofLongestIncreasingSubsequence.findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2}));
        System.out.println(no673NumberofLongestIncreasingSubsequence.findNumberOfLIS(new int[]{3,2,1}));
    }
}
