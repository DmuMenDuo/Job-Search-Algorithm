package me.menduo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NO228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int first = 0, second = 0;
        List<String> res = new ArrayList<>();
        while (second < nums.length) {
            int tmp = second + 1;
            if (tmp >= nums.length || nums[second] != nums[tmp] - 1) {
                if (first == second) {
                    res.add("" + nums[first]);
                } else {
                    res.add(nums[first] + "->" + nums[second]);
                }
                first = tmp;
            }
            second = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        NO228SummaryRanges no228SummaryRanges = new NO228SummaryRanges();
        System.out.println(Arrays.toString(no228SummaryRanges.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}).toArray()));
    }
}
