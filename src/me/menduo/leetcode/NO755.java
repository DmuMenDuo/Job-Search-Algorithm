package me.menduo.leetcode;

import java.util.Arrays;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-24 15:54
 **/
public class NO755 {
    public static void main(String[] args) {
        NO755 no755 = new NO755();
        no755.pourWater(new int[]{3,1,3},5,1);

    }

    private void pourWater(int[] heights, int V, int K) {
        for (int i = 0; i < V ; i++) {
           int best = K;
            for (int j = -1; j <=1 ; j+=2) {
                int step = K+j;
                while(step>=0 && step < heights.length && heights[step] <= heights[step - j]) {
                    if (heights[step] < heights[best]) best = step;
                    step += j;
                }
                if(best!=K) break;
            }
            heights[best]++;
        }
        System.out.println(Arrays.toString(heights));
    }
}
