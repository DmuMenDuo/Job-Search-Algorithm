package me.menduo.jzoffer;

import java.util.ArrayList;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-27 13:18
 **/
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
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
        PrintMatrix p = new PrintMatrix();
        System.out.println(p.printMatrix(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));
        System.out.println(p.printMatrix(new int[][]{{1},{2},{3},{4},{5}}));
    }
}
