package me.menduo.leetcode;

import me.menduo.leetcode.struct.TreeNode;

import java.util.*;

public class NO107BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lt = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if(tmp!=null){
                lt.add(tmp.val);
                if(tmp.left!=null) queue.add(tmp.left);
                if(tmp.right!=null) queue.add(tmp.right);
            }else{
                res.add(lt);
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
                lt = new ArrayList<>();
            }
        }
        Collections.reverse(res);
        return res;
    }
}
