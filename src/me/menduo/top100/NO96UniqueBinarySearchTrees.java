package me.menduo.top100;

/**
 * @program: LeetCode
 * @email: menduo96@gmail.com
 * @author: menduo
 * @create: 2018/9/28 12:29 PM
 **/
public class NO96UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n == 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            for (int j = 1; j <= i ; j++) {
                dp[i]+=dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NO96UniqueBinarySearchTrees no96UniqueBinarySearchTrees = new NO96UniqueBinarySearchTrees ();
        System.out.println (no96UniqueBinarySearchTrees.numTrees (4));
    }
}
