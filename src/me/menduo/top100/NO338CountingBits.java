package me.menduo.top100;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2018-10-02 19:45
 **/
public class NO338CountingBits {
    public int[] countBits(int num) {
        if(num==0) return new int[]{0};
        int[] dp = new int[num+1];
        dp[0] = 0;
        for(int i=1;i<=num;i<<=1){
            dp[i] = 1;
        }
        int cut = 1;
        for(int i=1;i<=num;i++){
            if(dp[i]==1) cut =i;
            else dp[i] = dp[cut] + dp[i-cut];

        }
        return dp;
    }

    public int[] countBits2(int num) {
        int[] dp = new int[num+1];
        for(int i=1;i<=num;i++){
            dp[i] = dp[i & i-1] +1;
        }
        return dp;
    }
    public static void main(String[] args) {
        NO338CountingBits no338CountingBits = new NO338CountingBits();
        System.out.println(no338CountingBits.countBits2(2));
        System.out.println(no338CountingBits.countBits2(5));
    }
}
