package me.menduo.top100;

public class NO268MissingNumber {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) res ^= (i ^ nums[i]);
        return res;
    }

    public static void main(String[] args) {
        NO268MissingNumber no268MissingNumber = new NO268MissingNumber();
        System.out.println(no268MissingNumber.missingNumber(new int[]{0, 1, 3, 4}));
    }
}
