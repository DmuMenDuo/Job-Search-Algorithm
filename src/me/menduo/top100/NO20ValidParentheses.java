package me.menduo.top100;

import java.util.Stack;

public class NO20ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{')
                stack.push(chars[i]);
            else if (chars[i] == ')' && (stack.empty() || stack.peek() != '('))
                return false;
            else if (chars[i] == ']' && (stack.empty() || stack.peek() != '['))
                return false;
            else if (chars[i] == '}' && (stack.empty() || stack.peek() != '{'))
                return false;
            else
                stack.pop();
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        NO20ValidParentheses no20ValidParentheses = new NO20ValidParentheses();
        System.out.println(no20ValidParentheses.isValid("()"));
        System.out.println(no20ValidParentheses.isValid("()[]{}"));
        System.out.println(no20ValidParentheses.isValid("(]"));
        System.out.println(no20ValidParentheses.isValid("([)]"));
        System.out.println(no20ValidParentheses.isValid("{[]}"));
    }
}
