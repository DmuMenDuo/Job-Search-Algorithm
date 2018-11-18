package me.menduo.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NO739DailyTemperatures {
    /**
     * O(n)算法
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        if (temperatures.length <= 0) return null;
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    /**
     * O(n^2)算法
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1) return new int[]{0};
        int res[] = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int j = i + 1;
            int flag = 0;
            while (true) {
                if (j >= temperatures.length) {
                    res[i] = 0;
                    break;
                }
                if (temperatures[j] <= temperatures[i]) {
                    flag++;
                    j++;
                } else {
                    res[i] = flag + 1;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NO739DailyTemperatures no739DailyTemperatures = new NO739DailyTemperatures();
        System.out.println(Arrays.toString(no739DailyTemperatures.dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
