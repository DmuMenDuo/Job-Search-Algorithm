package me.menduo.tencent;

import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-09 20:56
 **/
public class Four {
    /**
     * 12 5
     * 2 5 3 1 3 2 4 1 0 5 4 3
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int color = sc.nextInt();
            int[] arrays = new int[n];
            for (int i = 0; i < arrays.length ; i++) {
                arrays[i] = sc.nextInt();
            }
            int start = 0;
            int end = 1;
            int count=1;
            int max = Integer.MAX_VALUE;
            int[] map = new int[color+1];
            Deque<Integer> deque = new LinkedBlockingDeque<>();
            deque.addLast(arrays[start]);
            map[arrays[start]]++;
            while (end<n){
                if(!deque.contains(arrays[end])){
                    count++;
                }
                deque.addLast(arrays[end]);
                map[arrays[end]]++;
                while (count==color) {
                    max = Math.min(max,deque.size());
                    if(map[deque.getFirst()]>1) {
                        map[deque.getFirst()]--;
                        deque.removeFirst();
                        start++;
                    }else {
                        count--;
                    }
                }
                end++;

            }
            if(max==Integer.MAX_VALUE) System.out.println(-1);
            else
            System.out.println(max);
        }
    }

}
