package me.menduo.leetcode;

import me.menduo.leetcode.struct.ListNode;

public class NO328OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;

        ListNode even = head;
        ListNode odd = head.next;
        int cont = 0;
        ListNode l1 = head;
        ListNode l2 = head.next;
        while (l2.next != null) {
            l1.next = l2.next;
            l1 = l2;
            l2 = l2.next;
            cont++;
        }

        l1.next = null;
        if (cont % 2 == 0)
            l1.next = odd;
        else
            l2.next = odd;
        return even;

    }

    public static void main(String[] args) {
        NO328OddEvenLinkedList no328 = new NO328OddEvenLinkedList();
    }
}
