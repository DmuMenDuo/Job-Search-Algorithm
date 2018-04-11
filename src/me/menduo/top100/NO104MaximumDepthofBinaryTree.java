package me.menduo.top100;

import me.menduo.top100.struct.TreeNode;

public class NO104MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left>right? left+1:right+1;
    }
    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        NO104MaximumDepthofBinaryTree no104MaximumDepthofBinaryTree = new NO104MaximumDepthofBinaryTree();
        System.out.println(no104MaximumDepthofBinaryTree.maxDepth(root));
    }
}
