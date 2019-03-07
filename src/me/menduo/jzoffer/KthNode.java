package me.menduo.jzoffer;

import me.menduo.leetcode.struct.TreeNode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-07 23:32
 **/
public class KthNode {
    int cont=1;
    TreeNode treeNode;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot==null || k==0) return null;
        cont=k;
        helper(pRoot);
        return treeNode;

    }

    private void helper(TreeNode pRoot){
        if(pRoot==null) return;
        helper(pRoot.left);
        if(--cont==0) {
            treeNode = pRoot;
            return;
        }
        helper(pRoot.right);
    }
}
