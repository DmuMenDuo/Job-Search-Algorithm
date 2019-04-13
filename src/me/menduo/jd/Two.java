package me.menduo.jd;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-13 20:02
 **/
public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(scanner.next().trim());
            }
            String target= scanner.next().trim();
            int[] dp = new int[target.length()+1];
            for (int i = 0; i < dp.length ; i++) {
                Iterator<String> strings = set.iterator();
                while (strings.hasNext()) {
                    String cur =strings.next();
                    if(i-cur.length()>=0 && target.substring(i-cur.length(),i).equals(cur)) {
//                        System.out.println(target.substring(i-cur.length(),i));
//                        System.out.println(dp[i-cur.length()]);
                        dp[i] = Math.max(dp[i],dp[i-cur.length()] + 1);
                    }
                }
                if(i>0) dp[i] = Math.max(dp[i],dp[i-1]);
            }
            System.out.println(dp[target.length()]);
        }
    }
}
