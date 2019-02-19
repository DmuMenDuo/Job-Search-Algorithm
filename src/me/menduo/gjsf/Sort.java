package me.menduo.gjsf;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-19 19:04
 **/
public class Sort {


    public void quickSort(int[] array, int start, int end) {
        if (start == end) return;

        int index = patition(array, start, end);
        if (index > start) quickSort(array, start, index - 1);
        if (index < end) quickSort(array, index + 1, end);
    }

    private int patition(int[] array, int start, int end) {
        int pivot = array[start];
        swap(array, start, end);
        int low = start;
        int high = end;
        while (low < high) {
            while (low < high && array[low] <= pivot) low++;
            while (low < high && array[high] >= pivot) high--;
            if (low < high) swap(array, low, high);
        }
        swap(array, low, end);

        return low;
    }

    /**
     * 这种交换算法一定要注意自己和自己交换的情况
     * @param array
     * @param m
     * @param n
     */
    private void swap(int[] array, int m, int n) {
        if (array[m] != array[n]) {
            array[m] ^= array[n];
            array[n] ^= array[m];
            array[m] ^= array[n];
        }

    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] array = new int[]{21, 34, 74, 3, 20, 20, 3, 2, 56, 46, 6};
        int[] after_array = array.clone();
        sort.quickSort(after_array, 0, after_array.length - 1);
        System.out.println(Arrays.toString(after_array));
    }
}
