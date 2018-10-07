package me.menduo.top100;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2018-10-07 20:27
 **/
public class NO376WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<2) return nums.length;
        int up = 1,down = 1;
        for (int i = 1; i < nums.length ; i++) {
            if(nums[i] > nums[i-1]) up = down + 1;
            else if(nums[i]<nums[i-1]) down = up +1;
        }

        return Math.max(up,down);
    }
    public static void main(String[] args) {
        NO376WiggleSubsequence no376WiggleSubsequence = new NO376WiggleSubsequence();
        System.out.println(no376WiggleSubsequence.wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(no376WiggleSubsequence.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
    }
}
