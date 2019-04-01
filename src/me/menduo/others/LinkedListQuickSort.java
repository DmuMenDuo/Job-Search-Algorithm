package me.menduo.others;

import me.menduo.leetcode.struct.ListNode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-01 14:07
 **/
public class LinkedListQuickSort {
    public static void main(String[] args) {
        ListNode head = create();
        quickSort(head,null);
    }


    private static void quickSort(ListNode head,ListNode end) {
        if(head!=end) {
            ListNode index = partition(head, end);
            quickSort(head, index);
            quickSort(index.next, end);
        }
    }

    private static ListNode partition(ListNode head,ListNode end) {
        int key = head.val;
        ListNode i = head;
        ListNode j = head.next;
        while (j!=null) {
            if(j.val<key) {
                i = i.next;
                swap(j, i);
            }
            j = j.next;
        }
        swap(i,head);
        return i;
    }

    private static void swap(ListNode x,ListNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
    private  static ListNode create() {
        ListNode head = new ListNode(5);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(7);
        ListNode four = new ListNode(4);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        return head;
    }
}
