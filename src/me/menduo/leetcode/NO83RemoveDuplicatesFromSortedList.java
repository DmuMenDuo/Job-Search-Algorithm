package me.menduo.leetcode;

import me.menduo.leetcode.struct.ListNode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-27 16:49
 **/
public class NO83RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode cur = head;
        ListNode next = cur.next;

        while(cur!=null){
            while(next!=null && cur.val==next.val)
                next=next.next;
            cur.next = next;
            cur = next;

            if(next==null || next.next==null) return head;
            next=next.next;
        }

        return head;
    }
}
