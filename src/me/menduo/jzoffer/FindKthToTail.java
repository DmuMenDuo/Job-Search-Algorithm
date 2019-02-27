package me.menduo.jzoffer;

import me.menduo.leetcode.struct.ListNode;

import java.util.List;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-27 12:29
 **/
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode tmp = head;
        while (tmp!=null && k-->0) {
            tmp = tmp.next;
        }
        if(k>0) return null;
        while(tmp!=null) {
            head = head.next;
            tmp = tmp.next;
        }
        return head;
    }
}
