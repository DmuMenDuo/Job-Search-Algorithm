package me.menduo.pinduoduo;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-03 19:50
 **/
public class Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            s= s.replace("{","");
            s =s.replace("}","");
            s = s.replace(" ","");
            String[] array = s.split(",");
            int[] arrays = new int[array.length];
            for (int i = 0; i < array.length ; i++) {
                arrays[i] = Integer.parseInt(array[i]);
            }
            int thred = scanner.nextInt();
            //c(n,2)
            int total = arrays.length * (arrays.length-1) / 2;
            int count = 0;
            Arrays.sort(arrays);
            for (int i = 0; i < arrays.length ; i++) {
                for (int j = i+1; j <arrays.length ; j++) {
                    if(arrays[j] - arrays[i] <= thred) {
                        count++;
                    }else {
                        break;
                    }
                }
            }
            DecimalFormat df = new DecimalFormat("#0.000000");
            double x = count/(total * 1.0);
            System.out.println(df.format(x));
        }
    }
}
