package me.menduo.jzoffer;

import me.menduo.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-08 14:42
 **/
public class PrintTree {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null) return result;
        Deque<TreeNode>  deque = new LinkedBlockingDeque<>();
        deque.addFirst(pRoot);
        while (!deque.isEmpty()){
            int size =deque.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i <size ; i++) {
                TreeNode tmp = deque.removeLast();
                arrayList.add(tmp.val);
                if(tmp.left!=null) deque.addFirst(tmp.left);
                if (tmp.right!=null) deque.addFirst(tmp.right);
            }
            result.add(arrayList);
        }
        return result;
    }
}
