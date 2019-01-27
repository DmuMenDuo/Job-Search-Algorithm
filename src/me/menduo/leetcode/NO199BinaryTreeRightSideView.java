package me.menduo.leetcode;

import me.menduo.leetcode.struct.TreeNode;

import java.util.*;
/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-01-26 12:12
 **/
public class NO199BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> pre = new ArrayDeque<>();
        Deque<TreeNode> cur = new ArrayDeque<>();
        pre.add(root);
        while (!pre.isEmpty()){
            result.add(pre.peekFirst().val);
            while (!pre.isEmpty()){
                TreeNode f = pre.removeFirst();
                if(f.right!=null) cur.addLast(f.right);
                if(f.left!=null) cur.addLast(f.left);
            }

            Deque<TreeNode> tmp = cur;
            cur = pre;
            pre = tmp;
        }
        return result;
    }
    public static void main(String[] args) {
        NO199BinaryTreeRightSideView no199BinaryTreeRightSideView = new NO199BinaryTreeRightSideView();
        TreeNode root = createTree();
        System.out.println(Arrays.toString(no199BinaryTreeRightSideView.rightSideView(root).toArray()));
    }

    public static TreeNode createTree(){
        TreeNode root = new TreeNode(1);
        TreeNode one = new TreeNode(2);
        TreeNode two = new TreeNode(3);
        TreeNode three = new TreeNode(4);
        TreeNode four = new TreeNode(5);
        root.left=one;
        root.right=two;
        one.right=four;
        two.right=three;
        return root;
    }
}
