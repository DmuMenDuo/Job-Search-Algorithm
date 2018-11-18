package me.menduo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2018-10-02 15:24
 **/
public class NO120Triangle {
    public static void main(String[] args) {
        NO120Triangle no120Triangle = new NO120Triangle();
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(2);
        input.add(one);
        List<Integer> two = new ArrayList<>();
        two.add(3);
        two.add(4);
        input.add(two);
        List<Integer> three = new ArrayList<>();
        three.add(6);
        three.add(5);
        three.add(7);
        input.add(three);
        List<Integer> four = new ArrayList<>();
        four.add(4);
        four.add(1);
        four.add(8);
        four.add(3);
        input.add(four);
        System.out.println(no120Triangle.minimumTotal(input));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.get(triangle.size()-1).size()+1];
        for(int i=1;i<=triangle.size();i++){
            for (int j = i; j >0 ; j--) {
                if(j==i) {
                    dp[j] = dp[j-1] +triangle.get(i-1).get(j-1);
                }
                else if(j==1) dp[j] = dp[j] + triangle.get(i-1).get(j-1);
                else dp[j] = Math.min(dp[j] + triangle.get(i-1).get(j-1),dp[j-1]+triangle.get(i-1).get(j-1));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <dp.length ; i++) {
            min = dp[i]<min?dp[i]:min;
        }
        return min;
    }
}
