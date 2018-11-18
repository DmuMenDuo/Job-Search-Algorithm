package me.menduo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2018-11-14 20:26
 **/
public class NO935KnightDiaer {
    List<List<Integer>> nextNumber;
    int mod = 1000000007;
    public void init() {
        nextNumber = new ArrayList<>();
        nextNumber.add(Arrays.asList(4,6));
        nextNumber.add(Arrays.asList(8,6));
        nextNumber.add(Arrays.asList(7,9));
        nextNumber.add(Arrays.asList(4,8));
        nextNumber.add(Arrays.asList(0,3,9));
        nextNumber.add(null);
        nextNumber.add(Arrays.asList(0,1,7));
        nextNumber.add(Arrays.asList(2,6));
        nextNumber.add(Arrays.asList(1,3));
        nextNumber.add(Arrays.asList(2,4));


    }

    public int knightDialer2(int N) {
        if(N==0) return 0;
        init();
        int result = 0;
        int dp[][] = new int[N+1][10];
        Arrays.fill(dp[1],1);
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10 ; j++) {
                int pre = dp[i - 1][j];
                if (j==5) continue;
                for (int k = 0; k < nextNumber.get(j).size(); k++) {
                    dp[i][nextNumber.get(j).get(k)] = (dp[i][nextNumber.get(j).get(k)] + pre) % mod;
                }
            }
        }
        for (int i = 0; i < 10 ; i++) {
            result = (result + dp[N][i]) % mod;
        }
        return result;
    }
    public static void main(String[] args) {
        NO935KnightDiaer no935KnightDiaer = new NO935KnightDiaer();
        System.out.println(no935KnightDiaer.knightDialer(1));
        System.out.println(no935KnightDiaer.knightDialer(2));
    }

    /**
     * 变成找规律题了。
     * 首先一共四种不同类型的跳法：
     *  情况1：首先0自己一种跳法， 所以a=1
     *  情况2：1，3，7，9 一种跳法，所以b=4
     *  情况3：2,8 一种跳法 可以跳7，9或者1，3 所以c=2
     *  情况4：4,6 是最后一种跳法，可以跳0，3，9或者0，1，7
     * 举个例子：
     * 现在在0上的骑士，可能是从4，6跳过来的 所以是情况4跳过来的，所以组合数就是情况4的个数
     * 现在骑士站在1，3，7，9上会发现他能跳(2,6),(2,4),(6,8),(4,8)，恰好是 （c+d）*2 这个多跳法
     * 以此类推
     *
     * @param N
     * @return
     */
    public int knightDialer(int N) {
        if(N==0) return 0;
        if(N==1) return 10;

        int mod = 1000000007;
        long a = 1; // 0
        long b = 4; // 1,3,7,9
        long c = 2; // 2,8
        long d = 2; // 4,6

        for (int i = 1; i <N ; i++) {
            long next_a = d;
            long next_b = (c+d) * 2; //(2,6),(2,4),(6,8),(4,8)
            long next_c = b;
            long next_d = a*2+b;//(0,3,9),(0,1,7)

            a = next_a % mod;
            b = next_b % mod;
            c = next_c % mod;
            d = next_d % mod;

        }

        return (int)((a+b+c+d)%mod);

    }
}
