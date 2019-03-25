package me.menduo.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-24 21:57
 **/
public class Shuffle {
    public int[]  shuffle(int[] array){
        // 等概率 第一次 1/n 第二次 n-1/n * 1/n-1
        // 产生的可能性总数相同 都是n!
        int[] result = array.clone();
        Random random = new Random();
        for (int i = 0; i < result.length ; i++) {
            int j = random.nextInt(result.length);
            int tmp = result[j];
            result[j] = result[i];
            result[i] = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle();
        System.out.println(Arrays.toString(shuffle.shuffle(new int[]{1, 2, 3, 4, 5, 6})));
    }
}
