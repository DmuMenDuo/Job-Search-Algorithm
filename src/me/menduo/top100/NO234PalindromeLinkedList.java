package me.menduo.top100;

import java.util.List;

public class NO234PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(3);
        ListNode ln5 = new ListNode(2);
        ListNode ln6 = new ListNode(1);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;

        NO234PalindromeLinkedList no234PalindromeLinkedList = new NO234PalindromeLinkedList();
        System.out.println(no234PalindromeLinkedList.isPalindrome(ln1));
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow = head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        ListNode current = second;
        slow.next = null;

        ListNode pre = null;

        ListNode tmp;
        while(current!=null){
            tmp = current.next;
            current.next = pre;
            pre = current;
            current = tmp;
        }
        while(head!=null&&pre!=null){
            if(head.val !=pre.val){
                return  false;
            }
            head = head.next;
            pre = pre.next;
        }

        return true;
    }

}
