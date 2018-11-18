package me.menduo.leetcode;

public class NO832FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null) return null;
        for (int i = 0; i < A.length; i++) {
            reverse(A[i]);
            invert(A[i]);
        }
        return A;
    }

    private void reverse(int[] A) {
        int head = 0, tail = A.length - 1;
        int tmp;
        while (head < tail) {
            tmp = A[head];
            A[head] = A[tail];
            A[tail] = tmp;
            head++;
            tail--;
        }
    }

    private void invert(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) A[i] = 1;
            else A[i] = 0;
        }
    }

    public static void main(String[] args) {
        NO832FlippingAnImage no832FlippingAnImage = new NO832FlippingAnImage();
        System.out.println(no832FlippingAnImage.flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}}));
    }
}
