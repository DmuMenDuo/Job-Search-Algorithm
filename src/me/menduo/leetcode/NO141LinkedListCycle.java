package me.menduo.leetcode;


import me.menduo.leetcode.struct.ListNode;

public class NO141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null||head.next==null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

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
        NO141LinkedListCycle no141LinkedListCycle = new NO141LinkedListCycle();
        System.out.println(no141LinkedListCycle.hasCycle(ln1));
    }
}
