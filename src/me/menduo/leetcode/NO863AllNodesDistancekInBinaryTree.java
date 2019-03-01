package me.menduo.leetcode;

import me.menduo.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-01 13:07
 **/
public class NO863AllNodesDistancekInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode,Integer> disMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        dfs(root,target,disMap);
        find(res,disMap,root,K,disMap.get(root));
        return res;
    }

    private int dfs(TreeNode root,TreeNode target,Map<TreeNode,Integer> disMap){
        if(root==null) return -1;
        if(root==target) {
            disMap.put(target,0);
            return 0;
        }
        int left = dfs(root.left,target,disMap);
        int right = dfs(root.right,target,disMap);

        if(left!=-1) {
            disMap.put(root, left + 1);
            return left + 1;
        }

        if(right!=-1) {
            disMap.put(root,right+1);
            return right+1;
        }

        return -1;
    }
    private void find(List<Integer> res,Map<TreeNode,Integer> disMap,TreeNode root,int K,int d){

        if(root==null) return;
        if(disMap.containsKey(root))
            d = disMap.get(root);

        if(K==d) res.add(root.val);

        find(res,disMap,root.left,K,d+1);
        find(res,disMap,root.right,K,d+1);

    }
}
