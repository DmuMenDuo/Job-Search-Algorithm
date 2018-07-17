package me.menduo.top100;

import java.util.HashSet;
import java.util.Set;

public class NO73SetMatrixZeros {

    public void setZeroes(int[][] matrix) {
        Set<Integer> r = new HashSet<>();
        Set<Integer> c = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    r.add(i);
                    c.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (r.contains(i))
                for (int j = 0; j < matrix[i].length; j++)
                    matrix[i][j] = 0;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (c.contains(i))
                for (int j = 0; j < matrix.length; j++)
                    matrix[j][i] = 0;
        }

    }

    /**
     * 常数空间 的空间复杂度
     * 使用矩阵的第一行 和第一列作为辅助空间
     *
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {

        boolean c = false;
        boolean r = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                r = true;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                c = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }


        if (c) for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
        if (r) for (int i = 0; i < matrix[0].length; i++) matrix[0][i] = 0;
    }

    public static void main(String[] args) {

    }
}
