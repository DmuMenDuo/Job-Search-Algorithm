package me.menduo.duxiaoman;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-19 10:35
 **/
public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            long[] array = new long[n];
            for (int i = 0; i < n ; i++) {
                array[i] = scanner.nextLong();
            }
            BigDecimal res = new BigDecimal(0);
            boolean up = true;
            boolean down = true;
            BigDecimal count = new BigDecimal(0);
            for (int i = 0; i < n-1 ; i++) {
                long tmp = array[i + 1] - array[i];
                if (tmp > 0) {
                    if(up == down) {
                        down = false;
                        count = count.add(BigDecimal.valueOf(2));
                    }
                    BigDecimal bigDecimal = new BigDecimal(tmp);
                    res = res.add(bigDecimal);
                }else {
                    down = true;
                }

            }



            System.out.println(res.toString()+ " " + count.toString());
        }
    }
}
