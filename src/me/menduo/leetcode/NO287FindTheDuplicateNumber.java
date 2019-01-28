package me.menduo.leetcode;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-01-28 21:22
 **/
public class NO287FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }


    public static void main(String[] args) {
        NO287FindTheDuplicateNumber no287FindTheDuplicateNumber = new NO287FindTheDuplicateNumber();
        System.out.println(no287FindTheDuplicateNumber.findDuplicate(new int[]{1,3,4,2,2}));
    }
}
