package me.menduo.leetcode;

import java.util.Arrays;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-24 23:51
 **/
public class PokeCard {
    public static void main(String[] args) {
        int[] test = new int[]{1,3,5,7,2,6,4,8};
        test = order(test);
        System.out.println(Arrays.toString(test));
    }

    private static int[] order(int[] array){
        int[] result = new int[array.length];
        int n = array.length;
        int cur = 0;
        int tmp = 0;
        while(cur<n){
            if(result[tmp]==0) result[tmp] = array[cur++];
            int count = 0;
            while (count<2){
                if(result[tmp]==0) {
                    count++;
                }
                tmp++;
                if(tmp == n) tmp = 0;
                if(cur == n) break;
            }
            tmp--;
            if(tmp == -1) tmp = n-1;

        }
        return result;
    }
}
