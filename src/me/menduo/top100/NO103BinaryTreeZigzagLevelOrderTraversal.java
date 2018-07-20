package me.menduo.top100;

import me.menduo.top100.struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class NO103BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //队列不为空
        ArrayDeque<TreeNode> q1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> q2 = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        q1.add(root);
        int flag = 0;
        while (!q1.isEmpty()) {
            List<Integer> ele = new ArrayList<>();
            int zigzag = 0;
            while (!q1.isEmpty()) {
                TreeNode tmp = q1.removeFirst();
                ele.add(tmp.val);
                if (zigzag == 0) {
                    if (tmp.left != null) q2.addLast(tmp.left);
                    if (tmp.right != null) q2.addLast(tmp.right);
                } else {
                    if (tmp.right != null) q2.addLast(tmp.right);
                    if (tmp.left != null) q2.addLast(tmp.left);
                }
            }
            res.add(ele);
            while (!q2.isEmpty()) {
                q1.addLast(q2.removeLast());
            }
            flag = flag == 0 ? 1 : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode s = new TreeNode(9);
        TreeNode t = new TreeNode(20);
        TreeNode f = new TreeNode(15);
        TreeNode ff = new TreeNode(7);
        root.left = s;
        root.right = t;
        t.left = f;
        t.right = ff;


        NO103BinaryTreeZigzagLevelOrderTraversal no103 = new NO103BinaryTreeZigzagLevelOrderTraversal();

        no103.zigzagLevelOrder(root);

    }
}
