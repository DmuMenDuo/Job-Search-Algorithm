package me.menduo.leetcode;

import me.menduo.leetcode.struct.ListNode;

import java.util.Stack;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-12 00:43
 **/
public class NO1019 {
    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode>  stack = new Stack();
        while(head !=null) {
            stack.push(head);
            head = head.next;
        }

        int res[] = new int[stack.size()];
        Stack<Integer> minStack = new Stack();
        for (int i = res.length - 1; i >= 0; i--) {
            while (!minStack.isEmpty() && stack.peek().val >= minStack.peek()) minStack.pop();
            res[i] = minStack.isEmpty() ? 0 : minStack.peek();
            minStack.push(stack.peek().val);
            stack.pop();

        }
        return res;
    }

    public static void main(String[] args) {
        NO1019 no1019 = new NO1019();
        no1019.nextLargerNodes(create());
    }

    private static ListNode create() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(7);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);
        return head;
    }
}
