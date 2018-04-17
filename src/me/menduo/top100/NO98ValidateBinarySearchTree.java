package me.menduo.top100;

import me.menduo.top100.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NO98ValidateBinarySearchTree {

    /**
     * 二叉排序树中序遍历必定有序
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> x = new ArrayList();
        if(root==null||(root.left==null&&root.right==null)) return true;
        middleB(root,x);
        for (int i=1;i<x.size();i++) {
            if(x.get(i)<=x.get(i-1)) return false;
        }
        return true;

    }

    public void middleB(TreeNode root,List x){
        if(root.left!=null)
            middleB(root.left,x);
        x.add(root.val);
        if(root.right!=null)
            middleB(root.right,x);

    }

    public boolean isValidBST2(TreeNode root) {
        if(root ==null) return true;
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean check(TreeNode root,long left,long right) {
        if(root == null) return true;
        if(root.val<=left||root.val>=right) return false;
        return  check(root.left,left,root.val)&&check(root.right,root.val,right);
    }
    public static void main(String[] args) {

    }
}
