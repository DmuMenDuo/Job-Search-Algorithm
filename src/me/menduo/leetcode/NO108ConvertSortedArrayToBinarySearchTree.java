package me.menduo.leetcode;

import me.menduo.leetcode.struct.TreeNode;

public class NO108ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return sortedArrayToBST(nums,0,nums.length-1);

    }

    public TreeNode sortedArrayToBST(int[] nums,int left,int right){

        if(left>right) return null;

        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,left,mid-1);
        root.right = sortedArrayToBST(nums,mid+1,right);
        return  root;
    }

    public static void main(String[] args) {
        NO108ConvertSortedArrayToBinarySearchTree no108ConvertSortedArrayToBinarySearchTree = new NO108ConvertSortedArrayToBinarySearchTree();
        System.out.println(no108ConvertSortedArrayToBinarySearchTree.sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }
}
