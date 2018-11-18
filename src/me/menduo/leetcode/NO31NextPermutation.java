package me.menduo.leetcode;

import java.util.Arrays;

/**
 * User: menduo email:demon9607@163.com
 * Date: 2018-07-08
 * Time: 15:50
 */
public class NO31NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;

        int cut = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                cut = i;
                break;
            }
        }

        if (cut == 0) {
            Arrays.sort(nums);
        } else if (cut == nums.length - 1) {
            int tmp = nums[cut];
            nums[cut] = nums[cut - 1];
            nums[cut - 1] = tmp;
        } else {
            int flag = cut - 1;
            int min = cut;
            for (int i = cut; i < nums.length; i++) {
                if (nums[i] > nums[flag] && nums[min] > nums[i]) {
                    min = i;
                }
            }

            int tmp = nums[min];
            nums[min] = nums[flag];
            nums[flag] = tmp;
            Arrays.sort(nums, cut, nums.length);
        }
    }


    public static void main(String[] args) {
        NO31NextPermutation no31NextPermutation = new NO31NextPermutation();
        int[] nums = {1, 2, 3};
        no31NextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        int[] nums2 = {3, 2, 1};
        no31NextPermutation.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));
        int[] nums3 = {5, 4, 7, 5, 3, 2};
        no31NextPermutation.nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3));
    }
}
