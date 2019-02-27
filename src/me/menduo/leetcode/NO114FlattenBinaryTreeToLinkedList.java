package me.menduo.leetcode;

import me.menduo.leetcode.struct.TreeNode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-27 16:31
 **/
public class NO114FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root==null) return;

        flatten(root.left);
        flatten(root.right);

        if(root.left!=null) {
            TreeNode right = root.right;
            root.right=root.left;
            root.left=null;
            TreeNode tmp = root.right;
            while (tmp.right!=null)
                tmp=tmp.right;
            tmp.right = right;
        }

    }
}
