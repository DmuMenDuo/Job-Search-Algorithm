package me.menduo.jzoffer;

import me.menduo.leetcode.struct.TreeNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-03 15:41
 **/
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root==null) return arrayList;
        Deque<TreeNode> q = new LinkedBlockingDeque<>();
        q.addFirst(root);
        while (!q.isEmpty()){
            TreeNode tmp = q.removeLast();
            arrayList.add(tmp.val);
            if(tmp.left!=null) q.addFirst(tmp.left);
            if(tmp.right!=null) q.addFirst(tmp.right);
        }
        return arrayList;
    }
}
