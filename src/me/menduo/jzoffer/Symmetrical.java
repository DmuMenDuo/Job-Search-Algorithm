package me.menduo.jzoffer;

import me.menduo.leetcode.struct.TreeNode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-08 13:56
 **/
public class Symmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null) return true;

        return helper(pRoot,pRoot);

    }

    private boolean helper(TreeNode one,TreeNode two){
        if(one==null&&two==null) return true;
        if(one!=null && two==null) return false;
        if(one == null) return false;
        if(one.val != two.val) return false;
        return helper(one.left,two.right) && helper(one.right,two.left);
    }
}
