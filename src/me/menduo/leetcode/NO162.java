package me.menduo.leetcode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-11 17:19
 **/
public class NO162 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (mid == 0 && nums[mid] > nums[mid + 1] ||
                    mid == nums.length-1 && nums[mid] > nums[mid - 1] ||
                    mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }



    public static void main(String[] args) {
        NO162 no162 = new NO162();
        no162.findPeakElement(new int[]{0,1,0});
    }
}
