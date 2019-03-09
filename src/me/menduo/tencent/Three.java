package me.menduo.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-09 20:30
 **/
public class Three {
    static int mod = 1000000007;
    static int[][] cap = new int[2001][2001];
    public static void main(String[] args) {
        cap[1][1] = 1;
        for (int i = 2; i < 2001; i++) {
            cap[i][1] = 1;
            for (int j = 1; j <= i; j++) {
                cap[i][j] = (cap[i - 1][j - 1]%mod + cap[i - 1][j]%mod)%mod;
            }
        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        List<Integer> list=new ArrayList();
        int ans = cap[n+1][s+1];
        for(int i = 0; i < n; i++){
            list.add(sc.nextInt());
        }
        for(int i = 0;i < (n-s) ;i++){
            ans = ans%mod * 2 %mod;
        }
        System.out.println(ans);
    }
}

