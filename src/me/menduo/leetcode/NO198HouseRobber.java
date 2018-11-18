package me.menduo.leetcode;

public class NO198HouseRobber {
    /**
     * dp[1] 应该为Max{nums[i],dp[i-1]}
     * dp[i]=Max{dp[i-2]+nums[i],dp[i-1]}
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
        //int[] dp = new int[nums.length];
        //dp[0]=nums[0];
        //dp[1]=Math.max(nums[0],nums[1]);
        int pre = nums[0];
        int cur = nums[0] > nums[1] ? nums[0] : nums[1];
        int tmp = 0;
        for (int i = 2; i < nums.length; i++) {
            //dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
            tmp = pre + nums[i] > cur ? pre + nums[i] : cur;
            pre = cur;
            cur = tmp;
        }
//        return dp[nums.length-1];
        return cur;
    }

    public static void main(String[] args) {
        NO198HouseRobber no198HouseRobber = new NO198HouseRobber();
        System.out.println(no198HouseRobber.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
