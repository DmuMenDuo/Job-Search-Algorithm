package me.menduo.jzoffer;

import java.util.Stack;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-26 23:39
 **/
public class Stack2 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        if(stack2.isEmpty())
            throw new Exception("队列为空，无法读取数据");
        return stack2.pop();
    }
}
