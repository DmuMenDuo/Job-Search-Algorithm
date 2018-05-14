package me.menduo.top100;

import java.util.Arrays;
import java.util.Random;

public class NO384ShuffleAnArray {
    private int[] array;
    private int[] orign;
    private Random rand;

    public NO384ShuffleAnArray(int[] nums) {
        array = nums;
        orign = array.clone();
        rand = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        array = orign.clone();
        return array;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            int tmp = rand.nextInt(array.length - i) + i;
            swap(tmp, i);
        }
        return array;
    }

    private void swap(int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    public static void main(String[] args) {
        NO384ShuffleAnArray no384ShuffleAnArray = new NO384ShuffleAnArray(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(no384ShuffleAnArray.shuffle()));
        no384ShuffleAnArray.reset();
        System.out.println(Arrays.toString(no384ShuffleAnArray.shuffle()));

    }
}
