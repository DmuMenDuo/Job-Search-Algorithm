package me.menduo.leetcode;

import java.util.Arrays;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-01 20:24
 **/
public class NO313SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] array = new int[n];
        array[0]=1;
        int[] primes_index = new int[primes.length];
        int index =1;
        while (index<n){
            int[] values = new int[primes.length];
            for (int i = 0; i < primes.length ; i++) {
                values[i] = primes[i] * array[primes_index[i]];
            }
            array[index] = min(values);
            for (int i = 0; i < primes.length ; i++) while(array[primes_index[i]]*primes[i]<=array[index]) primes_index[i]++;
            index++;
        }

        return array[--index];
    }

    private int min(int[] value){
        Arrays.sort(value);
        return value[0];
    }

    public static void main(String[] args) {
        NO313SuperUglyNumber no313SuperUglyNumber = new NO313SuperUglyNumber();
        System.out.println(no313SuperUglyNumber.nthSuperUglyNumber(12,new int[]{2,7,13,19}));
    }


}
