package me.menduo.leetcode;

import java.util.Arrays;

public class NO48RotateImage {
    public void rotate(int[][] matrix) {
        int head = 0;
        int tail = matrix.length-1;
        int a;
        int tmp[];
        while(head < tail) {
//            for(int i = 0;i<matrix[head].length;i++) {
//                a = matrix[head][i];
//                matrix[head][i] = matrix[tail][i];
//                matrix[tail][i] = a;
//            }
            tmp = matrix[head];
            matrix[head]=matrix[tail];
            matrix[tail]=tmp;
            head++;
            tail--;
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                a = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = a;
            }
        }
    }
    public static void main(String[] args) {
        NO48RotateImage no48RotateImage = new NO48RotateImage();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        no48RotateImage.rotate(matrix);
        for(int[] x:matrix){
            System.out.println(Arrays.toString(x));
        }
    }
}
