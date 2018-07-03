package me.menduo.top100;

import me.menduo.top100.struct.ListNode;

/**
 * User: menduo email:demon9607@163.com
 * Date: 2018-07-01
 * Time: 19:43
 */
public class NO24SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode first = head;
        if (head.next == null) return head;
        ListNode result = head.next; //result node head
        ListNode second = head.next;
        ListNode tmp = second.next;
        while (true) {
            second.next = first;
            first.next = tmp;
            if (tmp != null && tmp.next != null) {
                ListNode link = first;
                link.next = tmp.next;
                first = tmp;
                second = tmp.next;
                tmp = second.next;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        NO24SwapNodesInPairs no24SwapNodesInPairs = new NO24SwapNodesInPairs();
        ListNode l = n1;
        System.out.print(l.val);
        while (l.next != null) {
            System.out.print("->" + l.next.val);
            l = l.next;
        }
        System.out.println();

        l = no24SwapNodesInPairs.swapPairs(n1);
        System.out.print(l.val);
        while (l.next != null) {
            System.out.print("->" + l.next.val);
            l = l.next;
        }
        System.out.println();
    }
}
