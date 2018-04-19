package me.menduo.top100;

import me.menduo.top100.struct.ListNode;

import java.util.HashSet;

public class NO817LinkedListComponents {

    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set = new HashSet();
        for(int i=0;i<G.length;i++){
            set.add(G[i]);
        }
        int cont=0;
        while(head!=null){
            if(set.contains(head.val)){
                cont++;
                head=head.next;
                while(head!=null&&set.contains(head.val))
                    head=head.next;
            }else {
                head = head.next;
            }
        }
        return cont;
    }


    public static void main(String[] args) {

    }
}