package me.menduo.meituan;

import java.util.*;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-23 20:43
 **/
public class Two {
    static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            int[] color = new int[n];
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 1; i < n ; i++) {
                array[i] = scanner.nextInt();
                if(map.containsKey(array[i])){
                    map.get(array[i]).add(i);
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(array[i],list);
                }
            }
            for (int i = 0; i < n ; i++) {
                color[i] = scanner.nextInt();
            }

            long[][] dp = new long[n][2]; //dp状态转化
            dfs(map, color, dp, 0);
            System.out.println(dp[0][1]);
        }
    }

    private static void dfs(Map<Integer, List<Integer>> map, int[] color, long[][] dp, int n) {
        //dfs遍历所有的节点
        if(map.get(n) == null) {
            if (color[n] == 0) dp[n][1] = 1;
            else dp[n][0] = 1;
            return;
        }
        for(int i:map.get(n)) dfs(map,color,dp, i);
        //如果当前节点是白色的
        if(color[n] == 0) {
            dp[n][1] = 1;
            for (int i = 0; i < map.get(n).size() ; i++) {
                dp[n][1] = dp[n][1] * (dp[map.get(n).get(i)][0] + dp[map.get(n).get(i)][1]) % MOD;
            }
        }else {
            int k = map.get(n).size();
            int[] q = new int[k+2];
            long[] l = new long[k+2];
            long[] r = new long[k+2];
            for (int i = 0; i < k; i++) {
                q[i+1] = map.get(n).get(i);
            }

            l[0] = r[k+1] = 1;
            for (int i = 1; i <= k; i++) {
                l[i] = l[i-1] * (dp[q[i]][0] + dp[q[i]][1]) % MOD;
            }

            for (int i = k; i >= 1; i--) {
                r[i] = r[i+1] * (dp[q[i]][0] + dp[q[i]][1]) % MOD;
            }
            dp[n][0] = 1;
            for (int i = 1; i <= k ; i++) {
                dp[n][0] = dp[n][0] * (dp[q[i]][0] + dp[q[i]][1]) % MOD;
            }

            for (int i = 1; i <= k ; i++) {
                dp[n][1] = (dp[n][1] + l[i-1] % MOD * r[i+1] % MOD * dp[q[i]][1]) % MOD;
            }
        }

    }
}
