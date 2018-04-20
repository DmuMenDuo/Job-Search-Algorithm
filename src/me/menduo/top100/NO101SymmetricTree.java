package me.menduo.top100;

import me.menduo.top100.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NO101SymmetricTree {
    //不可以用前序遍历来做，是错的，无法排除null的情况
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return  isSymmetric(root,root);
    }
    boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;

        if(left.val!=right.val) return false;

        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }

    public static void main(String[] args) {
        TreeNode ls = new TreeNode(1);
        TreeNode ls2 = new TreeNode(2);
        TreeNode ls3 = new TreeNode(2);
        TreeNode ls4 = new TreeNode(3);
        TreeNode ls5 = new TreeNode(4);
        TreeNode ls6 = new TreeNode(4);
        TreeNode ls7 = new TreeNode(3);
        ls.left = ls2;
        ls.right = ls3;
        ls2.left = ls4;
        ls2.right = ls5;
        ls3.left = ls6;
        ls3.right = ls7;
        NO101SymmetricTree no101SymmetricTree = new NO101SymmetricTree();
        System.out.println(no101SymmetricTree.isSymmetric(ls));
    }
}
