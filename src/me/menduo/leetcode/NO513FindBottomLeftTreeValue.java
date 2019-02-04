package me.menduo.leetcode;

import me.menduo.leetcode.struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-04 21:34
 **/
public class NO513FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addFirst(root);
        int result = 0;
        while (!q.isEmpty()){
            TreeNode tmp = q.pollLast();
            result = tmp.val;
           if(tmp.right!=null) q.addFirst(tmp.right);
           if(tmp.left!=null) q.addFirst(tmp.left);
        }

        return result;

    }
    public static void main(String[] args) {
        NO513FindBottomLeftTreeValue no513FindBottomLeftTreeValue = new NO513FindBottomLeftTreeValue();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        no513FindBottomLeftTreeValue.findBottomLeftValue(root);
    }
}
