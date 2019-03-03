package me.menduo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(matrix.length==0 || matrix[0].length==0) return null;
        int start = 0;
        int end = matrix[0].length-1;
        int up = 0;
        int down = matrix.length-1;

        int status=0;
        int count=0;
        int total = matrix.length*matrix[0].length;
        while(count<total) {
            if(count<total && status == 0) {
                for (int i = start; i <= end; i++) {
                    arrayList.add(matrix[up][i]);
                    count++;
                }
                up++;
                status=1;
            }
            if(count<total &&  status == 1){
                for (int i = up; i <= down; i++) {
                    arrayList.add(matrix[i][end]);
                    count++;
                }
                end--;
                status=2;
            }
            if(count<total && status == 2){
                for (int i = end; i >= start; i--) {
                    arrayList.add(matrix[down][i]);
                    count++;
                }
                down--;
                status=3;
            }

            if(count<total && status == 3){
                for (int i = down; i >= up; i--) {
                    arrayList.add(matrix[i][start]);
                    count++;
                }
                start++;
                status=0;
            }
        }


        return arrayList;
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
