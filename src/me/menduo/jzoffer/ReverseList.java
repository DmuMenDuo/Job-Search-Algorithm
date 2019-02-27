package me.menduo.jzoffer;

import me.menduo.leetcode.struct.ListNode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-27 12:39
 **/
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        ListNode result = null;
        ListNode cur = head;
        ListNode pre = null;
        while (cur!=null){
            ListNode next = cur.next;
            if(next==null) result = cur;
            cur.next = pre;
            pre = cur;
            cur=next;
        }
        return result;
    }
}
