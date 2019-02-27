package me.menduo.jzoffer;

import me.menduo.leetcode.struct.ListNode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-27 12:50
 **/
public class Merge {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;

        ListNode result = null;
        if (list1.val < list2.val) {
            result = list1;
            result.next = Merge(list1.next, list2);
        } else {
            result = list2;
            result.next = Merge(list1, list2.next);
        }
        return result;
    }
}
