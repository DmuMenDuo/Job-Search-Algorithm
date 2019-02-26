package me.menduo.jzoffer;

import me.menduo.leetcode.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-26 23:06
 **/
public class ReConstructBinaryTree {
    /**
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
     * @param pre
     * @param in
     * @return
     */
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre==null || pre.length==0) return null;
        for (int i = 0; i < in.length ; i++) {
            map.put(in[i],i);
        }
        return helper(pre,0,pre.length-1,0);
    }

    private TreeNode helper(int[] pre,int left,int right,int pos) {
        if(left>right) return null;

        TreeNode root = new TreeNode(pre[left]);
        int index = map.get(pre[left]);
        int leftTreeSize = index - pos;
        root.left = helper(pre,left+1,left+leftTreeSize,pos);
        root.right = helper(pre,left+leftTreeSize+1,right,pos+leftTreeSize+1);
        return root;
    }
}
