package me.menduo.others;

import me.menduo.leetcode.struct.TreeNode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-07 00:24
 **/
public class NO543DiameterOfBinaryTree {
    private int dia=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        return helper(root);
    }

    private int helper(TreeNode node){
        if(node==null) return 0;

        int lf_len = helper(node.left);
        int lr_right = helper(node.right);
        if(dia<lf_len+lr_right){
            dia = lf_len+lr_right;
        }

        return Math.max(lf_len,lr_right)+1;
    }
}
