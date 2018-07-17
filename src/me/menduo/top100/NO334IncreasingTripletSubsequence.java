package me.menduo.top100;

public class NO334IncreasingTripletSubsequence {
    /**
     * O(n^2)
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {

        if (nums == null || nums.length < 3) return false;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        if (dp[nums.length - 1] >= 2) return true;
        return false;

    }

    /**
     * O(n)
     *
     * @param nums
     * @return
     */

    public boolean increasingTriplet2(int[] nums) {

        if (nums == null || nums.length < 3) return false;
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
                continue;
            }
            if (nums[i] > min && nums[i] <= min2) {
                min2 = nums[i];
                continue;
            }
            if (nums[i] > min2) return true;

        }
        return false;

    }

    public static void main(String[] args) {
        NO334IncreasingTripletSubsequence no334 = new NO334IncreasingTripletSubsequence();
        System.out.println(no334.increasingTriplet2(new int[]{2, 1, 5, 0, 4, 6}));
    }
}
