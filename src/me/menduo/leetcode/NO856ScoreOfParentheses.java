package me.menduo.leetcode;

import java.util.Stack;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-04 22:38
 **/
public class NO856ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        if(S==null||S.length()==0) return 0;
        Stack<Integer> stack = new Stack<>();
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length ; i++) {
            if(chars[i]=='(') stack.push(-1);
            if(chars[i]==')') {
                int score = 0;
                while (stack.peek()!=-1){
                    score+=stack.pop();
                }
                stack.pop();
                if(score==0) stack.push(1);
                else stack.push(2*score);
            }
        }
        int result =0;
        while (!stack.isEmpty()) result+=stack.pop();
        return result;
    }
    public static void main(String[] args) {
        NO856ScoreOfParentheses no856ScoreOfParentheses = new NO856ScoreOfParentheses();
        System.out.println(no856ScoreOfParentheses.scoreOfParentheses("(()(()))"));
    }
}
