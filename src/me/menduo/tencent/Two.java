package me.menduo.tencent;

import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-09 19:41
 **/
public class Two {
    /**
     * 4
     * 2 4
     * 2 2
     * 3 3
     * 1 5
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = Long.parseLong(sc.next());
        while (--n>=0){
            long start = Long.parseLong(sc.next());
            long end = Long.parseLong(sc.next());
            if(start%2!=0){
                start = 0 -start;
            }
            if(end%2!=0){
                end = 0 -end;
            }

            if(start<0 && end<0){
                System.out.println((Math.abs(end) - Math.abs(start))/2 +end);
            }else if(start<0 && end>0){
                System.out.println((Math.abs(end)+1-Math.abs(start))/2);
            }else if(start>0 && end<0){
                System.out.println(0-(Math.abs(end)-Math.abs(start)+1)/2);
            }else {
                System.out.println(end - (Math.abs(end)-Math.abs(start))/2);
            }
        }
    }

}
