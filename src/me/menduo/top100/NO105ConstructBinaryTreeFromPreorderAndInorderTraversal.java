package me.menduo.top100;

import me.menduo.top100.struct.TreeNode;

public class NO105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /**
     * 递归
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return 生成树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if ((pe < ps) || (ie < is)) return null;
        TreeNode treeNode = new TreeNode(preorder[ps]);
        int cut = findCutPos(inorder, is, ie, preorder[ps]);
        treeNode.left = buildTree(preorder, ps + 1, ps + cut, inorder, is, is + cut - 1);
        treeNode.right = buildTree(preorder, cut + ps + 1, pe, inorder, cut + is + 1, ie);
        return treeNode;
    }

    private int findCutPos(int[] inorder, int is, int ie, int val) {
        for (int i = is; i <= ie; i++)
            if (inorder[i] == val) return i - is;
        return -1;
    }

    public static void main(String[] args) {

    }
}