package me.menduo.top100;

public class NO19RemoveNthNodeFromEndOfList {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        if(fast == null) {
            head = head.next ;
            return head;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        NO19RemoveNthNodeFromEndOfList no19RemoveNthNodeFromEndOfList = new NO19RemoveNthNodeFromEndOfList();
        head = no19RemoveNthNodeFromEndOfList.removeNthFromEnd(head,1);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }


    }
}
