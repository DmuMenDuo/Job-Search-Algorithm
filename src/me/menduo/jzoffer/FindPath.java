package me.menduo.jzoffer;

import me.menduo.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-27 14:18
 **/
public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        helper(root,new ArrayList<>(),result,0,target);
        return result;
    }

    private void helper(TreeNode root,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> result,int cur,int target) {
        if(root==null) return;
        cur+=root.val;
        path.add(root.val);

        boolean isleaf = root.left==null && root.right == null;
        if(cur==target && isleaf)
            result.add(new ArrayList<>(path));

        else{
            helper(root.left,path,result,cur,target);
            helper(root.right,path,result,cur,target);
        }
        path.remove(path.size()-1);
    }

}
