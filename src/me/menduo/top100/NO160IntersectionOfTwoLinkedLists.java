package me.menduo.top100;

import me.menduo.top100.struct.ListNode;

import java.util.HashSet;
import java.util.Set;

public class NO160IntersectionOfTwoLinkedLists {
    /**
     * O(n)的空间复杂度 和O(n)的时间复杂度
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int headALength = getLength(headA);
        int headBLength = getLength(headB);

        if (headALength < headBLength) {
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
            int tmpL = headALength;
            headALength = headBLength;
            headBLength = tmpL;
        }

        int toDes = headALength - headBLength;

        for (int i = 0; i < toDes; i++) {
            headA = headA.next;
        }

        while (headA != null) {
            if (headA == headB) return headA;

            headA = headA.next;
            headB = headB.next;
        }

        return null;

    }

    private int getLength(ListNode l) {
        int resLength = 0;
        while (l != null) {
            resLength++;
            l = l.next;
        }
        return resLength;
    }

    /**
     * 长度对齐之后走的如果有相等就是有公共节点
     * O(1)的空间复杂度 和O(n)的时间复杂度
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        Set<ListNode> listNodes = new HashSet<>();
        int cont = 0;
        while (headA.next != null) {
            listNodes.add(headA);
            headA = headA.next;
            cont++;
        }

        while (headB.next != null) {
            if (listNodes.contains(headB)) return headB;
            headB = headB.next;
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
