package me.menduo.jzoffer;

import me.menduo.leetcode.struct.TreeLinkNode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-08 13:18
 **/
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if(pNode==null) return null;
        //3种情况 如果该节点有右子树，那么 下一个节点就是右子树的最左节点
        TreeLinkNode next  = null;
        if(pNode.right!=null){
            TreeLinkNode right = pNode.right;
            while (right.left!=null) right=right.left;
            next = right;
        }
        //如果该节点是父节点的左子树，且右子树为空，拿下一个节点就是他父节点
        else if(pNode.next!=null){
            if(pNode.next.left == pNode)
                next =  pNode.next;
            else {
                //如果该节点是其父节点的右子树，且自身右子树为空，那么其下一个节点为其第一个
                TreeLinkNode current = pNode;
                TreeLinkNode parent = pNode.next;
                while (parent !=null && current == parent.right){
                    current = current.next;
                    parent = current.next;
                }
                next = parent;
            }
        }
        return next;

    }








}
