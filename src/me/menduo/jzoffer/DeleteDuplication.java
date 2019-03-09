package me.menduo.jzoffer;

import me.menduo.leetcode.struct.ListNode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-08 17:28
 **/
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null ||pHead.next==null) return pHead;
        ListNode pre = new ListNode(0);
        pre.next = pHead;
        ListNode tmp = pHead;
        ListNode next = tmp.next;
        while (tmp!=null && tmp.next!=null){

            if (tmp.val == tmp.next.val){
                int val = tmp.val;
                while (tmp!= null&&tmp.val == val)
                    tmp = tmp.next;
                next = next.next;
            }
            pre.next =
            tmp.next = next;
            tmp = next;
            if(next==null) break;
            next=next.next;
        }

        return pHead;
    }ju
}
