package me.menduo.leetcode;


import java.util.Arrays;
import java.util.Stack;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-23 15:44
 **/
public class NO84 {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        Stack<Integer> stack = new Stack();
        int res = 0;
        for (int i = 0; i <= heights.length; i++) {
            int curH = i == heights.length ? -1:heights[i];
            while (!stack.isEmpty() && curH <= heights[stack.peek()]) {
                int left = stack.pop();
                int s = (stack.isEmpty() ? i : (i - stack.peek() - 1)) * heights[left];
                res = Math.max(res, s);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        NO84 no84 =new NO84();
        System.out.println(no84.largestRectangleArea(new int[]{1,2,2}));
    }
}
