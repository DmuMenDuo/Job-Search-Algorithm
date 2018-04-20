package me.menduo.top100;

import me.menduo.top100.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NO637AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root==null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Double> res = new ArrayList<>();
        long lt = 0;
        int cont=0;
        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if(tmp!=null){
                lt+=tmp.val;
                cont++;
                if(tmp.left!=null) queue.add(tmp.left);
                if(tmp.right!=null) queue.add(tmp.right);
            }else{
                res.add(lt*1.0/cont);
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
                lt=0;
                cont=0;
            }
        }
        return res;
    }
}
