package me.menduo.xiecheng;

import java.util.*;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-08 19:37
 **/
public class Two {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNext()) {
            String x = scanner.next();
            String tmp = x.replace("[","").replace("]","").replace(" ","");
            String[] links = tmp.split(",");

            int k = scanner.nextInt();
            if(links.length==1) {
                System.out.println(x);
                continue;
            }
            for (int i = 0; i < links.length ; i+=k) {
                if(i+k<=links.length) reverse(links,i,i+k-1);
            }


            StringJoiner stringJoiner =new StringJoiner(",","[","]");
            for (int i = 0; i < links.length ; i++) {
                stringJoiner.add(links[i]);
            }
            System.out.println(stringJoiner.toString());
        }
    }



    private static void reverse(String[] links,int start,int end) {
        while (start<end){
            swap(links,start,end);
            start++;
            end--;
        }
    }

    private static  void swap(String[] links, int a, int b) {
        String tmp  = links[a];
        links[a] = links[b];
        links[b] = tmp;
    }
}
