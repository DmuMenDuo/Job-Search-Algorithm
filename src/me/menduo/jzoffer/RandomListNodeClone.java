package me.menduo.jzoffer;

import me.menduo.jzoffer.struct.RandomListNode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-03 17:03
 **/
public class RandomListNodeClone {
    /*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null) return null;
        link(pHead);
        clone(pHead);
        RandomListNode r = new RandomListNode(0);
        r.next = split(pHead);
        return r.next;
    }

    private void link(RandomListNode pHead){
        RandomListNode tmp = pHead;
        while (tmp!=null){
            RandomListNode clone = new RandomListNode(tmp.label);
            RandomListNode next =tmp.next;
            tmp.next = clone;
            clone.next = next;
            tmp = next;
        }
    }

    private void clone(RandomListNode pHead){
        RandomListNode tmp = pHead;
        RandomListNode clone = pHead.next;
        while (clone!=null){
            if(clone.random!=null){
                clone.random = tmp.random.next;
            }
            clone = clone.next;
        }
    }

    private RandomListNode split(RandomListNode pHead){
        RandomListNode result = pHead.next;
        RandomListNode tmp = result;
        while (tmp.next!=null){
            RandomListNode next = tmp.next;
            tmp.next = next.next;
            tmp = tmp.next;
        }

        return result;
    }

    public static void main(String[] args) {
        RandomListNodeClone randomListNodeClone =new RandomListNodeClone();
        RandomListNode one = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        RandomListNode three = new RandomListNode(3);
        one.next = two;
        two.next = three;
        randomListNodeClone.Clone(one);
    }
}
