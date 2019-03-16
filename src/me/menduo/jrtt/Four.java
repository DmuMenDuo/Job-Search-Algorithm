package me.menduo.jrtt;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-16 12:16
 **/
public class Four {
    public static double binary(int[] a,int n){
        double ans = 0;
        Arrays.sort(a);
        double max = a[a.length-1];
        double min = 0;
        for(int j=0;j<100;j++){
            ans = (min+max)/2.0;
            int num=0;
            for(int i=0;i<a.length;i++){
                num += (int) (a[i]/ans);
            }
            if(num<n) max = ans;
            else min = ans;
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            double ans = binary(a, m);
            DecimalFormat df = new DecimalFormat("#0.00");
            ans = Math.floor(ans*100)/100;
            if(m==0) System.out.println("0.00");
            else System.out.println(df.format(ans));
        }
    }
}
