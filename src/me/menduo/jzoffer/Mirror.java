package me.menduo.jzoffer;

import me.menduo.leetcode.struct.TreeNode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-27 13:12
 **/
public class Mirror {
    public void Mirror(TreeNode root) {
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        TreeNode tmp = root;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if(root.left!=null)
            Mirror(root.left);
        if(root.right!=null)
            Mirror(root.right);
    }

}
