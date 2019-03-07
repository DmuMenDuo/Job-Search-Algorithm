package me.menduo.jzoffer;

import me.menduo.leetcode.struct.TreeNode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-03 17:51
 **/
public class TreeNodeConvert {
    TreeNode head=null;
    TreeNode realHead=null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return null;

        Convert(pRootOfTree.left);

        if(head==null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        }else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        Convert(pRootOfTree.right);

        return realHead;
    }


    private void convert(TreeNode root) {
        if(root == null) return;
        convert(root.left);

        if(head==null){
            head = root;
            realHead = root;
        }else {
            head.right = root;
            root.left = head;
            head = root;
        }
        convert(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = createTree();
        System.out.println(new TreeNodeConvert().Convert(root).val);
        TreeNode root2 = createTree();
        TreeNodeConvert treeNodeConvert = new TreeNodeConvert();
        treeNodeConvert.convert(root2);
        System.out.println(treeNodeConvert.realHead.val);
    }

    private static TreeNode createTree() {
        TreeNode one1 = new TreeNode(10);
        TreeNode one2 = new TreeNode(6);
        TreeNode one3 = new TreeNode(14);
        TreeNode one4 = new TreeNode(4);
        TreeNode one5 = new TreeNode(8);
        TreeNode one6 = new TreeNode(12);
        TreeNode one7 = new TreeNode(16);
        one1.left=one2;one1.right=one3;
        one2.left=one4;one2.right=one5;
        one3.left=one6;one3.right=one7;

        return one1;

    }
}
