package me.menduo.leetcode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-01 20:15
 **/
public class NO264UglyNumberii {
    public int nthUglyNumber(int n) {
        if(n<=0) return 0;
        int[] array = new int[n];
        array[0]=1;
        int pos_two = 0;
        int pos_three = 0;
        int pos_five = 0;
        int index = 1;
        while(index<n) {
            int min = Math.min(Math.min(array[pos_two]*2,array[pos_three]*3),array[pos_five]*5);
            array[index] = min;

            while(array[pos_two]*2<=array[index]) pos_two++;
            while (array[pos_three]*3<=array[index]) pos_three++;
            while (array[pos_five]*5<=array[index]) pos_five++;

            index++;
        }

        return array[--index];
    }

    public static void main(String[] args) {
        NO264UglyNumberii no264UglyNumberii = new NO264UglyNumberii();
        System.out.println(no264UglyNumberii.nthUglyNumber(10));
    }
}
