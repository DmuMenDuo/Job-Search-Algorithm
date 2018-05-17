package me.menduo.top100;

public class NO238ProductOfArrayExceptSelf {
    /**
     * left[] = a1 a1*a2 a1*a2*a3 a1*a2*a3*a4 a1*a2*a3*a4*a5 ...
     * right[] = a1*a2*a3*a4*a5 a2*a3*a4*a5 a3*a4*a5 a4*a5 a5
     * 1   2   6   24
     * 24  24  12  4
     * 结果:[
     * 数组下标：0
     * 24 ==right[1]
     * 1 ~ n-2
     * left[i-1]*right[i+1]
     * n-1
     * left[nums.length-2]
     * ]
     *
     * @param nums input
     * @return output
     */

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length - 1; i++) {
            left[i] = left[i - 1] * nums[i];
            right[nums.length - 1 - i] = right[nums.length - i] * nums[nums.length - 1 - i];
        }

        int[] res = new int[nums.length];
        res[0] = right[1];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = left[i - 1] * right[i + 1];
        }
        res[nums.length - 1] = left[nums.length - 2];
        return res;
    }
}
