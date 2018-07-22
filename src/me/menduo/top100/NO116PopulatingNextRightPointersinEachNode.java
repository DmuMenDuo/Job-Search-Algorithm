package me.menduo.top100;

import me.menduo.top100.struct.TreeLinkNode;
import me.menduo.top100.struct.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class NO116PopulatingNextRightPointersinEachNode {
    /**
     * 题目给的前提是完美二叉树，所以不存在出现中间有null的情况，如果有这种情况出现，请使用层次遍历
     */
    /**
     * 递归
     */
    public void connect3(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null)
                root.right.next = root.next.left;
        }
        connect3(root.left);
        connect3(root.right);
    }


    /**
     * 规律
     */
    public void connect2(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode tmp = root;
        while (tmp != null) {
            TreeLinkNode tmp2 = tmp;
            while (tmp != null) {
                if (tmp.left != null) tmp.left.next = tmp.right;
                if (tmp.right != null) tmp.right.next = tmp.next == null ? null : tmp.next.left;
                tmp = tmp.next;
            }
            tmp = tmp2.left;
        }
    }


    /**
     * 层次遍历的思想
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        ArrayDeque<TreeLinkNode> q1 = new ArrayDeque<>();
        ArrayDeque<TreeLinkNode> q2 = new ArrayDeque<>();

        if (root == null) return;
        q1.addLast(root);
        while (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                TreeLinkNode tmp = q1.removeFirst();
                if (!q1.isEmpty()) tmp.next = q1.peekFirst();
                if (tmp.left != null) q2.addLast(tmp.left);
                if (tmp.right != null) q2.addLast(tmp.right);
            }

            ArrayDeque<TreeLinkNode> treeLinkNodes = q1;
            q1 = q2;
            q2 = treeLinkNodes;

        }
    }

    public static void main(String[] args) {

    }
}
