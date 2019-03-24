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
        if(heights == null && heights.length==0) return 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int max = 0;
        int[] tmp = Arrays.copyOf(heights,heights.length+1);
        while (i<tmp.length){
            if(stack.isEmpty() || tmp[stack.peek()] <= tmp[i]) {
                stack.push(i);
                i++;
            }else {
                int x = stack.pop();
                int width = stack.isEmpty()?i:i-stack.peek()-1;
                max = Math.max(max,tmp[x] * width);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        NO84 no84 =new NO84();
        System.out.println(no84.largestRectangleArea(new int[]{2,1,2}));
    }
}
