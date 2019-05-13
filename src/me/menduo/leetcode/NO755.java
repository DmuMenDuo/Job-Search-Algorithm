package me.menduo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-24 15:54
 **/
public class NO755 {
    public static void main(String[] args) {
        NO755 no755 = new NO755();
        int[] heights = new int[]{5, 4, 2, 1, 2, 3, 2, 1, 0, 1, 2, 4};
        int[] before = heights.clone();
        no755.print(heights);
        no755.pourWater(heights, 8, 5);
        no755.afterPrint(heights, before);

    }

    private void pourWater(int[] heights, int V, int K) {
        for (int i = 0; i < V; i++) {
            int best = K;
            for (int j = -1; j <= 1; j += 2) {
                int step = K + j;
                while (step >= 0 && step < heights.length && heights[step] <= heights[step - j]) {
                    if (heights[step] < heights[best]) best = step;
                    step += j;
                }
                if (best != K) break;
            }
            heights[best]++;
        }
        System.out.println(Arrays.toString(heights));
    }

    private void print(int[] tmp) {
        int[] height = tmp.clone();
        List<List<String>> lists = new ArrayList<>();
        while (true) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < height.length; i++) {
                if (height[i] == 0) {
                    res.add(" ");
                } else {
                    res.add("+");
                }
                if (height[i] > 0) height[i]--;
            }
            lists.add(res);
            int count = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] == 0) count++;
            }
            if (count == tmp.length) break;
        }
        print(lists);
    }


    private void afterPrint(int[] tmp, int[] before) {
        int[] height = tmp.clone();
        List<List<String>> lists = new ArrayList<>();
        while (true) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < height.length; i++) {
                if (height[i] == 0 && before[i] == 0) {
                    res.add(" ");
                } else if (height[i] != 0 && before[i] != 0) {
                    res.add("+");
                } else if (height[i] != 0 && before[i] == 0) {
                    res.add("w");
                }
                if (height[i] > 0) height[i]--;
                if (before[i] > 0) before[i]--;
            }
            lists.add(res);
            int count = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] == 0) count++;
            }
            if (count == tmp.length) break;
        }
        print(lists);
    }

    private void print(List<List<String>> lists) {
        for (int i = lists.size() - 1; i >= 0; i--) {
            for (String word : lists.get(i)) {
                System.out.print(word);
            }
            System.out.println();
        }
    }
}
