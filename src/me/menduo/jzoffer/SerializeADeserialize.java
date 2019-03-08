package me.menduo.jzoffer;

import me.menduo.leetcode.struct.TreeNode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-08 14:54
 **/
public class SerializeADeserialize {
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root,sb);
        return sb.toString();
    }

    private void helper(TreeNode  treeNode ,StringBuilder sb){
        if(treeNode==null){
            sb.append("$,");
        }else{
            sb.append(treeNode.val);
            sb.append(",");
            helper(treeNode.left,sb);
            helper(treeNode.right,sb);
        }
    }
    int index = -1;
    TreeNode Deserialize(String str) {
        String[] strings = str.split(",");
        return helper2(strings);
    }
    private TreeNode helper2(String[] strings){
        index++;
        if(!strings[index].equals("$")){
            TreeNode root = new TreeNode(Integer.parseInt(strings[index]));
            root.left = helper2(strings);
            root.right = helper2(strings);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode t = createTree();
        SerializeADeserialize serializeADeserialize = new SerializeADeserialize();
        System.out.println(serializeADeserialize.Serialize(t));
        t = serializeADeserialize.Deserialize(serializeADeserialize.Serialize(t));
        System.out.println(t.val);
    }

    private static TreeNode createTree() {
        TreeNode one1 = new TreeNode(1);
        TreeNode one2 = new TreeNode(6);
        TreeNode one3 = new TreeNode(2);
        TreeNode one4 = new TreeNode(4);
        TreeNode one5 = new TreeNode(8);
        TreeNode one6 = new TreeNode(3);
        TreeNode one7 = new TreeNode(5);
        one1.left=one2;one1.right=one3;
        one2.left=one4;one2.right=one5;
        one3.left=one6;one3.right=one7;

        return one1;

    }
}
