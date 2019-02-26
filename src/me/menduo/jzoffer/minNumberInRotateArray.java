package me.menduo.jzoffer;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-26 23:45
 **/
public class minNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array==null || array.length==0) return 0;
        int left = 0;
        int right = array.length-1;
        while (left<right){
            int mid = left + (right-left)/2;

            if(array[mid]>array[left]) left = mid+1;
            else right=mid;
        }
        Math.pow(2,1);
        return array[left];
    }
}

