package me.menduo.jzoffer;

import me.menduo.leetcode.struct.ListNode;

import java.util.ArrayList;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-26 22:04
 **/
public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(listNode!=null){
            arrayList.addAll(printListFromTailToHead(listNode.next));
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}
