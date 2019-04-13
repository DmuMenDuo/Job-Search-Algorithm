package me.menduo.jd;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-13 19:22
 **/
public class One {
    static class TreeNode {
        int val;
        List<TreeNode> childen;
        public TreeNode(int val) {
            this.val = val;
            childen = new ArrayList<>();
        }
    }

    static int count;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            TreeNode[] tree = new TreeNode[n+1];
            for (int i = 1; i <= n; i++) {
                tree[i] = new TreeNode(i);
            }

            for (int i = 1; i < n ; i++) {
                int index = scanner.nextInt();
                int parent = scanner.nextInt();
                tree[parent].childen.add(tree[index]);
            }


            TreeNode head = tree[1];
            int res = 0;
            for (int i = 0; i < head.childen.size() ; i++) {
                count = 0;
                findNode(head.childen.get(i));
                res = Math.max(res,count);
            }
            System.out.println(res);
        }
    }

    /**
     * 求树节点数
     * @param tr
     */
    private static void findNode(TreeNode tr){
        if(tr == null) return;
        count++;
        for (int i = 0; i < tr.childen.size() ; i++) {
            findNode(tr.childen.get(i));
        }
    }
}
