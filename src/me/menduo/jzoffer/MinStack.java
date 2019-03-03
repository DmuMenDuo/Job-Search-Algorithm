package me.menduo.jzoffer;

import java.util.Stack;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-03 14:40
 **/
public class MinStack {

    Stack<Integer> normal = new Stack<>();
    Stack<Integer> min_val = new Stack<>();

    public void push(int node) {
        if(!normal.isEmpty()) {
            normal.push(node);
            if(node>min_val.peek()){
                min_val.push(min_val.peek());
            }else {
                min_val.push(node);
            }
        }else{
            normal.push(node);
            min_val.push(node);
        }
    }

    public void pop() {
        normal.pop();
        min_val.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int min() {
        return min_val.peek();
    }
}
