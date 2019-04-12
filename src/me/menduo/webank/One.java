package me.menduo.webank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-11 19:25
 **/
public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            ArrayList<Integer> list  = new ArrayList();
            for (int i = 0; i < n ; i++) {
                list.add(i+1);
            }
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while (list.size()!=1) {
                i = (i + m - 1 )%list.size();
                int tmp  = list.get(i);
                stringBuilder.append(tmp + " ");
                list.remove(i);

            }
            System.out.println(stringBuilder.toString().trim());
            System.out.println(list.get(0));
        }
    }
}
