package me.menduo.leetcode;

import java.util.List;

public class NO54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rStart=0;
        int rEnd = matrix.length-1;
        int cStart=0;
        int cEnd=matrix[0].length-1;
        int n=0;
        int total = matrix.length*matrix[0].length;
        while (n<total){
            for (int i = rStart; i <=rEnd ; i++) {

            }
        }
        return null;
    }

    public static void main(String[] args) {
        NO54SpiralMatrix no54SpiralMatrix = new NO54SpiralMatrix();
        System.out.println(no54SpiralMatrix.spiralOrder(
                new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}
                }
        ));
    }
}
