package me.menduo.leetcode;

import me.menduo.leetcode.struct.TreeNode;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-04 09:28
 **/
public class NO226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        change(root);
        return root;
    }

    public void change(TreeNode treeNode){
        if(treeNode.left==null && treeNode.right==null) return;
        else{
            if(treeNode.left!=null) change(treeNode.left);
            if(treeNode.right!=null) change(treeNode.right);

            TreeNode tmp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = tmp;
        }

    }
    public static void main(String[] args) {
    }
}
