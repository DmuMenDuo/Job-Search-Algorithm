package me.menduo.jzoffer;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-27 12:12
 **/
public class reOrderArray {

    public void reOrderArray(int [] array) {
        int count = 0;
        for (int i = 0; i < array.length ; i++) {
            if(array[i]%2!=0) count++;
        }

        int[] nums = array.clone();
        int start = 0,end = count;
        for (int num:nums) {
            if(num%2!=0) array[start++]=num;
            else array[end++]=num;
        }
    }
}
