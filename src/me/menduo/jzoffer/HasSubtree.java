package me.menduo.jzoffer;

import me.menduo.leetcode.struct.TreeNode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-27 13:01
 **/
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result=false;
        if(root1!=null && root2!=null){
            if(root1.val==root2.val)
                result = helper(root1,root2);

            if(!result)
                result = HasSubtree(root1.left,root2);
            if(!result)
                result = HasSubtree(root1.right,root2);
        }
        return result;
    }

    private boolean helper(TreeNode node1, TreeNode node2) {
        if (node2 == null) return true;
        if (node1 == null) return false;
        if (node1.val != node2.val) return false;
        return helper(node1.left, node2.left) && helper(node1.right, node2.right);
    }
}
