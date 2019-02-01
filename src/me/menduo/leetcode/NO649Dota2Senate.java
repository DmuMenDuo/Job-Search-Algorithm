package me.menduo.leetcode;

import java.util.Deque;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-01 13:33
 **/
public class NO649Dota2Senate {
    /**
     *
     * @param senate
     * @return
     */
    public String predictPartyVictory(String senate) {
        Deque<Integer> R = new LinkedBlockingDeque<>();
        Deque<Integer> D = new LinkedBlockingDeque<>();
        char[] x = senate.toCharArray();
        int n = x.length;
        for (int i = 0; i <n ; i++) {
            if(x[i] == 'R') R.addLast(i);
            else D.addLast(i);
        }

        while(!R.isEmpty()&&!D.isEmpty()){
            int CR = R.pollFirst();
            int CD = D.pollFirst();

            if(CR<CD) R.addLast(CR+n);
            else D.addLast(CD+n);
        }

        return R.size()>=D.size()?"Radiant":"Dire";


    }
    public static void main(String[] args) {
        NO649Dota2Senate no649Dota2Senate = new NO649Dota2Senate();
        System.out.println(no649Dota2Senate.predictPartyVictory(""));
    }
}
