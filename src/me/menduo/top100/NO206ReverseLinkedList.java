package me.menduo.top100;

import me.menduo.top100.struct.ListNode;

import java.util.Stack;

public class NO206ReverseLinkedList {
    /**
     * 用栈的方式
     * 2ms,效率很差虽然是o(n)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        Stack<ListNode> stack = new Stack<>();
        while(head!=null){
            stack.push(head);
            head=head.next;
            stack.peek().next = null;
        }
        ListNode newHead=stack.pop();
        ListNode tmp = newHead;
        while(!stack.empty()){
            tmp.next = stack.pop();
            tmp = tmp.next;

        }
        return newHead;
    }

    /**
     * 递归的方式
     * 0ms 比用栈的方式好
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }else {
            ListNode newhead = reverseList2(head.next);
            head.next.next = head;
            head.next = null;
            return newhead;
        }
    }

    public ListNode reverseList3(ListNode head) {
        if(head == null) return null;
        if(head.next ==null){
            return head;
        }
        ListNode current = head;
        ListNode tmp;
        ListNode pre = null;
        while(current !=null){
            tmp = current.next;
            current.next = pre;
            pre = current;
            current = tmp;
        }

        return pre;
    }


    public static void main(String[] args) {
        NO206ReverseLinkedList no206ReverseLinkedList = new NO206ReverseLinkedList();
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        head.next = two;
        two.next = three;
        head = no206ReverseLinkedList.reverseList3(head);
        while(head!=null) {
            System.out.println(head.val);
            head=head.next;
        }
    }
}
