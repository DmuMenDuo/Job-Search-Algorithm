package me.menduo.top100;

import me.menduo.top100.struct.ListNode;

public class NO21MergeTwoSortedLists {


    /**
     * 非递归的方式
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode tmp;
        if(l1.val<=l2.val){
            tmp = l1;
            l1 = l1.next;
        }else{
            tmp = l2;
            l2 = l2.next;
        }
        ListNode head = tmp;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                head.next = l1;
                head = l1;
                l1 = l1.next;
            }else {
                head.next = l2;
                head = l2;
                l2 = l2.next;
            }
        }

        head.next = l1==null?l2:l1;

        return tmp;

    }

    /**
     * 递归的方式
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode result;
        if(l1.val<=l2.val){
            result = l1;
            result.next = mergeTwoLists(l1.next,l2);
        }else {
            result = l2;
            result.next = mergeTwoLists(l1,l2.next);
        }

        return result;
    }



    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ln1.next = ln3;
        ln3.next = ln5;
        ln2.next = ln4;
        ln4.next = ln6;

        NO21MergeTwoSortedLists no21MergeTwoSortedLists = new NO21MergeTwoSortedLists();
        ListNode head = no21MergeTwoSortedLists.mergeTwoLists(ln1,ln2);
        while(head!=null) {
            System.out.println(head.val);
            head=head.next;
        }
    }
}
