package me.menduo.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: menduo email:demon9607@163.com
 * Date: 2018-07-01
 * Time: 15:00
 */
public class NO18FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                int sum;
                while (left < right) {
                    sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[left]);
                        res.add(nums[right]);
                        left++;
                        right--;
                        if (!result.contains(res))
                            result.add(res);
                    } else if (sum > target) right--;
                    else left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NO18FourSum no18FourSum = new NO18FourSum();
        List<List<Integer>> l = no18FourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }
}
