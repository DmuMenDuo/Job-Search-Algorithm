package me.menduo.leetcode;

import me.menduo.leetcode.struct.ListNode;

import java.util.PriorityQueue;

/**
 * User: menduo email:demon9607@163.com
 * Date: 2018-07-01
 * Time: 19:17
 */
public class NO23MergeKSortedLists {
    /**
     * 多链表排序，想到优先队列
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val < o2.val ? -1 : 1);
        for (ListNode list : lists) if (list != null) queue.add(list);
        ListNode head = new ListNode(0);
        ListNode trans = head;
        while (!queue.isEmpty()) {
            trans.next = queue.poll();
            trans = trans.next;

            if (trans.next != null)
                queue.add(trans.next);
        }
        return head.next;
    }


    public static void main(String[] args) {

    }
}
