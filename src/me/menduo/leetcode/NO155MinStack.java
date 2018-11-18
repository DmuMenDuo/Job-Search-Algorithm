package me.menduo.leetcode;

import java.util.Stack;

public class NO155MinStack {
    private Stack<Integer> normal;
    private Stack<Integer> min;

    /**
     * initialize your data structure here.
     */
    public NO155MinStack() {
        normal = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        normal.push(x);
        if (min.empty()) {
            min.push(x);
        } else {
            if (x > min.peek()) {
                min.push(min.peek());
            } else {
                min.push(x);
            }
        }
    }

    public void pop() {
        normal.pop();
        min.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        NO155MinStack no155MinStack = new NO155MinStack();
        no155MinStack.push(1);
        System.out.println(no155MinStack.getMin());
        no155MinStack.push(3);
        System.out.println(no155MinStack.getMin());
        no155MinStack.push(0);
        System.out.println(no155MinStack.getMin());
    }
}
