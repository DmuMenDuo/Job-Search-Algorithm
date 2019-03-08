package me.menduo.jzoffer;

import me.menduo.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-08 14:04
 **/
public class PrintTreeZ {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedBlockingDeque<>();
        Deque<TreeNode> q2 = new LinkedBlockingDeque<>();
        queue.addFirst(pRoot);
        int flag = 0;
        while (!queue.isEmpty()){
            ArrayList<Integer> arrayList = new ArrayList<>();
            int size= queue.size();
            for (int i = 0; i <size; i++) {
                TreeNode tmp =queue.removeFirst();
                arrayList.add(tmp.val);
                if(flag==0) {
                    if(tmp.left!= null) q2.addLast(tmp.left);
                    if(tmp.right!=null) q2.addLast(tmp.right);
                }
                else {
                    if(tmp.right!=null) q2.addLast(tmp.right);
                    if(tmp.left!= null) q2.addLast(tmp.left);
                }
            }
            arrayLists.add(arrayList);
            while (!q2.isEmpty())
                queue.addLast(q2.removeLast());
            flag = (flag == 0?1:0);
        }
        return arrayLists;
    }
}
