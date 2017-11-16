package me.menduo.top100;

import java.util.List;

/**
 * @author: menduo
 * @description:
 * @date: Create in 21:14 2017/11/15
 * @motified by:
 */
public class Top2AddTwoNumbers {

    /**
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p=l1,q=l2,curr=result;
        int carry = 0;
        while(p!=null||q!=null){
            int x = (p==null)?0:p.val;
            int y = (q==null)?0:q.val;
            int m = x+y+carry;
            curr.next = new ListNode(m%10);
            carry = m/10;
            curr = curr.next;

            if(p!=null) {
                p=p.next;
            }
            if(q!=null) {
                q=q.next;
            }
        }

        if(carry>0){
            curr.next = new ListNode(carry);
        }
        return result.next;
    }


    public static void main(String[] args) {
        //eg.1
        /*ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);*/
        //eg2
        /*ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(0);*/
        //eg3
        /*ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        Top2AddTwoNumbers top2AddTwoNumbers = new Top2AddTwoNumbers();
        ListNode l3 = top2AddTwoNumbers.addTwoNumbers(l1,l2);*/
        //eg4
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        Top2AddTwoNumbers top2AddTwoNumbers = new Top2AddTwoNumbers();
        ListNode l3 = top2AddTwoNumbers.addTwoNumbers(l1,l2);

        while(l3!=null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}