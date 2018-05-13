package me.menduo.top100;

public class NO53MaximumSubArray {
    /**
     * dp[i] = Math.max(dp[i-1]+nums[i],nums[i])
     * res = Math.max(dp)
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = sum + nums[i] < nums[i] ? nums[i] : sum + nums[i];
            max = max > sum ? max : sum;
        }
        return max;
    }

    public static void main(String[] args) {
        NO53MaximumSubArray no53MaximumSubArray = new NO53MaximumSubArray();
        System.out.println(no53MaximumSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
