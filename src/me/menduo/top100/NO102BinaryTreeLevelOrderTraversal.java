package me.menduo.top100;

import me.menduo.top100.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class NO102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);
        root.left=root1;
        root.right=root2;
        root2.left=root3;
        root2.right=root4;

        List<List<Integer>> res = new NO102BinaryTreeLevelOrderTraversal().levelOrder(root);

        for(List<Integer> m:res){
            for (int x:m){
                System.out.print(x);
            }
            System.out.println();
        }
    }
}
