package me.menduo.leetcode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-11 17:34
 **/
public class NO852 {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) return mid;
            if (A[mid] > A[mid + 1]) right = mid;
            else left = mid + 1;
        }
        return mid;
    }
}
