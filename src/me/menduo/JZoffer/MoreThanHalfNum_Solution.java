package me.menduo.JZoffer;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-19 20:15
 **/
public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int length = array.length;
        if(length<=0) return 0;

        int middle = length >> 1; //右移除2
        int end = length-1;
        int start = 0;
        int index = partition(array,0,end);
        while (index!=middle) {
            if(index<middle) {
                start = index+1;
                index = partition(array,start,end);
            }else if (index>middle){
                end = index-1;
                index = partition(array,start,end);
            }
        }
        if(checkMoreThanHalf(array,array[middle])) return array[middle];
        else  return 0;
    }

    private boolean checkMoreThanHalf(int[] array,int value) {
        int count = 0;
        for (int i = 0; i < array.length ; i++) {
            if(array[i] == value) count++;
        }
        return count*2>array.length;
    }

    private int partition(int[] array,int start,int end) {
        int pivot = array[start];
        swap(array,start,end);
        int left = start;
        int right = end;
        while (left < right) {
            while (left<right && array[left] <= pivot) left++;
            while (left<right && array[right] >= pivot) right--;
            if(left<right) swap(array,left,right);
        }
        swap(array,left,end);
        return left;
    }

    private void swap(int[] array,int m,int n) {
        if (array[m] != array[n]) {
            array[m]^=array[n];
            array[n]^=array[m];
            array[m]^=array[n];
        }
    }
}
