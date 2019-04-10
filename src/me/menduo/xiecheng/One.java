package me.menduo.xiecheng;

import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-08 18:58
 **/
public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String link = scanner.next();
            String[] links = link.split(",");

            int[] count = new int[26];
            for (int i = 0; i <links.length ; i++) {
                count[links[i].charAt(0)-'a']++;
            }
            boolean flag = false;
            for(int i =0 ; i<26; i++) {
                if(count[i]>1) {
                    flag = true;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
}
