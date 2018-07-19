package me.menduo.top100;

import me.menduo.top100.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NO94BinaryTreeInorderTraversal {

    /**
     * 非递归
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        while (root != null && !treeNodes.isEmpty()) {
            while (root != null) {
                treeNodes.push(root);
                root = root.left;
            }

            if (!treeNodes.isEmpty()) {
                root = treeNodes.peek();
                result.add(root.val);
                treeNodes.pop();
                root = root.right;
            }
        }
        return result;

    }


    /**
     * 递归中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        middleTraversal(root, result);


        return result;

    }

    private void middleTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;

        middleTraversal(root.left, result);

        result.add(root.val);

        middleTraversal(root.right, result);
    }

    public static void main(String[] args) {
        NO94BinaryTreeInorderTraversal no94BinaryTreeInorderTraversal = new NO94BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        TreeNode s = new TreeNode(2);
        TreeNode t = new TreeNode(3);
        root.right = s;
        s.left = t;

        no94BinaryTreeInorderTraversal.inorderTraversal2(root);
    }
}
