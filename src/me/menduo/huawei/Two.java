package me.menduo.huawei;

import java.util.Scanner;

/**
 * 100 0 200 0 200 100 100 100 0 100
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-27 19:22
 **/
public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            Loc[] locs = new Loc[5];
            String[] x = sc.nextLine().split(" ");
            int start = 0;
            for (int i = 0; i < x.length ; i+=2) {
                locs[start++] = new Loc(Long.valueOf(x[i]),Long.valueOf(x[i+1]));
            }
            double result = 0;
            int f = 5;
            Loc cur = new Loc(0,0);
            Loc nextLoc = cur;
            while (f>0) {
                double next = Integer.MAX_VALUE;
                for (int i = 0; i < 5 ; i++) {
                    if(locs[i].visit==0 && compare(cur,locs[i],next)){
                        next = locs[i].getDiss(cur);
                        nextLoc = locs[i];
                    }
                }
                cur = nextLoc;
                result+=next;
                cur.visit = 1;
                f--;
            }
            System.out.println((long)(result+nextLoc.getDiss(new Loc(0,0))));
        }
    }
    private static boolean compare(Loc one,Loc two,double next){
        if(next>two.getDiss(one)) return true;
        else if(next == two.getDiss(one)){
            if(one.x < two.x) return true;
            else if(one.x == two.x) {
                if(one.y > two.y) {
                    return true;
                }
            }
        }
        return false;
    }
    static class Loc {
        long x;
        long y;
        int visit;
        public Loc(long x, long y) {
            this.x = x;
            this.y = y;
        }
        private double getDiss(Loc loc){
            return Math.sqrt((loc.x-x)*(loc.x-x)+(loc.y-y)*(loc.y-y));
        }
    }
}
