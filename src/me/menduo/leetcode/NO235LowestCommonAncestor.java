package me.menduo.leetcode;

import me.menduo.leetcode.struct.TreeNode;

import java.util.Stack;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-27 20:23
 **/
public class NO235LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        if(root==null) return null;
        if(root.val<p.val && root.val<q.val)  return lowestCommonAncestor(root.right,p,q);
        if (root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left,p,q);

        return root;

    }


}
