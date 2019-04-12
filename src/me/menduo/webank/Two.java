package me.menduo.webank;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-11 19:41
 **/
public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n =  scanner.nextInt();
            int k = scanner.nextInt();
            int m = scanner.nextInt();
            long skill = n * k;
            long res = 0;
            if ( n > m) {
                res = (long)Math.ceil(skill / (1.0 * m));
            }else  {
                res = (long)Math.ceil(skill / (1.0 * n));
            }
            System.out.println(res);
        }
    }
}
