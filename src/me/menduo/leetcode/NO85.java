package me.menduo.leetcode;

import java.util.Stack;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-23 16:37
 **/
public class NO85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length == 0) return 0;
        int[][] tmp = new int[matrix.length][matrix[0].length+1];
        for (int i = 0; i < matrix[0].length ; i++) {
            tmp[0][i] = matrix[0][i] - '0';
        }
        for(int i=1;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]-'0'!=0)
                    tmp[i][j] = matrix[i][j] - '0' + tmp[i-1][j];
            }
        }
        int max = 0;
        for(int i=0;i<tmp.length; i++) {
            int j = 0;
            Stack<Integer> stack = new Stack();
            while(j<tmp[i].length) {
                if(stack.isEmpty() || tmp[i][stack.peek()] <= tmp[i][j]) {
                    stack.push(j);
                    j++;
                }else{
                    int height = stack.pop();
                    int width = stack.isEmpty()?j:j-stack.peek()-1;
                    max = Math.max(max,tmp[i][height]*width);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        NO85 no85 =new NO85();
        System.out.println(no85.maximalRectangle(new char[][]
                {{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','1'}}));
    }
}
