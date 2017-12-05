package me.menduo.top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: menduo
 * @description:
 * @date: Create in 20:30 2017/11/14
 * @motified by:
 */
public class Top1TwoSum {
    /**
     *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *  You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     * 得到的结果是一个数组内两个数的的和为target的这两个数的下标
     * @param nums 数组
     * @param target 目标值
     * @return 两个结果在数组中的下标
     */
    public int[] twoSum(int[] nums, int target) {
        int[] x = new int[2];
        if(nums==null || nums.length<2){
            return x;
        }
        Map<Integer,Integer> m = new HashMap();
        for(int i=0;i<nums.length;i++){
            m.put(nums[i], i);
        }
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(target-nums[i])){
                int index=m.get(target-nums[i]);
                if(index==i){
                    continue;
                }
                x[0]=i;
                x[1]=m.get(target-nums[i]);
                return x;
            }
        }
        return x;
    }


    public static void main(String[] args) {
        Top1TwoSum ts = new Top1TwoSum();
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = ts.twoSum(nums,target);
        System.out.println(Arrays.toString(result));
    }
    
}
