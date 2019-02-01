package me.menduo.leetcode;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-01 15:53
 **/
public class NO486PredictTheWinner {

    /**
     * 解法1:
     * 博弈论必胜策略：当前选的分数大于对手所能选的分数
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length%2==0) return true;
        return find(nums,0,nums.length-1)>=0;
    }

    public int find(int[] nums,int start,int end){
        if(start==end) return nums[start];
        else return Math.max(nums[start]-find(nums,start+1,end),nums[end]-find(nums,start,end-1));
    }

    /**
     * DP解法
     * dp空间[i,j]代表的是从i到j区间当前玩家选的分数大于后手玩家选的分数
     * @param nums
     * @return
     */
    public boolean PredictTheWinnerWithDP(int[] nums) {
        if(nums.length%2==0) return true;
        int[][] dp = new int[nums.length][nums.length];
        for(int i=nums.length-2;i>=0;--i){
            for(int j = i+1;j<nums.length;++j){
                dp[i][j] = Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][nums.length-1]>=0;
    }

    public static void main(String[] args) {
        NO486PredictTheWinner no486PredictTheWinner = new NO486PredictTheWinner();
        System.out.println(no486PredictTheWinner.PredictTheWinnerWithDP(new int[]{1,5,2}));
    }
}
