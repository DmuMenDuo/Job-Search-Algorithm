package me.menduo.jzoffer;

import java.util.Stack;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-03 14:45
 **/
public class IsPopOrder {
    Stack<Integer> push = new Stack();
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length!=popA.length) return false;
        int peek = 0;
        int current = 0;
        while (current < popA.length && (peek<pushA.length || !push.isEmpty())){
            if(push.isEmpty() || push.peek()!=popA[current]){
                if(peek>=pushA.length) break;
                push.push(pushA[peek]);
                peek++;
                continue;
            }
            if(push.peek()==popA[current]){
                current++;
                push.pop();
            }
        }

        if(popA.length-current==0 && push.isEmpty()) return true;
        return false;

    }

    public static void main(String[] args) {
        IsPopOrder isPopOrder = new IsPopOrder();
        System.out.println(isPopOrder.IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
    }
}
