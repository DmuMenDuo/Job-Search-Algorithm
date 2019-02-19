package me.menduo.jzoffer;

import java.util.ArrayList;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-19 22:26
 **/
public class GetLeastNumbers_Solution {
    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(input.length<k || k==0) return arrayList;
        int start = 0;
        int end = input.length-1;
        int index = partition(input,start,end);
        while (index!=k-1){
            if(index<k-1) {
                start = index+1;
                index = partition(input,start,end);
            }else if (index > k-1) {
                end = index-1;
                index = partition(input,start,end);
            }
        }

        for (int i = 0; i <k ; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }


    private int partition(int[] array, int start, int end) {
        int pivot = array[start];
        swap(array,start,end);
        int left = start;
        int right = end;
        while (left<right) {
            while (left<right && array[left]<=pivot) left++;
            while (left<right && array[right]>=pivot) right--;
            if(left<right) swap(array,left,right);
        }
        swap(array,left,end);
        return left;
    }

    private void swap(int[] array, int m, int n) {
        if(array[m]!=array[n]) {
            array[m]^=array[n];
            array[n]^=array[m];
            array[m]^=array[n];
        }
    }
}
