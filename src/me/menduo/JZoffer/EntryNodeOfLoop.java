package me.menduo.JZoffer;

import me.menduo.leetcode.struct.ListNode;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-19 17:33
 **/
public class EntryNodeOfLoop {
    public ListNode entryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) return null;
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (true) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = pHead;
                while (fast != slow){
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }
    }
}
