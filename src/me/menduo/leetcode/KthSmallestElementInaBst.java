package me.menduo.leetcode;

import me.menduo.leetcode.struct.TreeNode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-08 00:05
 **/
public class KthSmallestElementInaBst {
    private int count;
    private TreeNode t;
    public int kthSmallest(TreeNode pRoot, int k) {
       count=k;
       helper(pRoot);
       return t.val;
    }

    private void helper(TreeNode p){
        if(p==null)return;
        helper(p.left);
        if(--count==0){
            t=p;
            return;
        }
        helper(p.right);

    }
}
