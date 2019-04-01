package me.menduo.leetcode;

public class NO45JumpGameII {
    public int jump(int[] nums) {
        int times = 0;
        int reach = 0; // 之前能到达的最大距离
        int max = 0; //当前可以达到的最大距离
        for(int i=0;i<nums.length;i++){
            if(reach<i){
                times++;
                reach = max;
            }
            max = Math.max(max,i+nums[i]);
        }
        return times;
    }

    public static void main(String[] args) {
        NO45JumpGameII no45JumpGameII = new NO45JumpGameII();
        System.out.println(no45JumpGameII.jump(new int[]{2,3,1,1,4}));
    }
}
