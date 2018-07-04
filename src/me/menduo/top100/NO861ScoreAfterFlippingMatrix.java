package me.menduo.top100;

/**
 * User: menduo email:demon9607@163.com
 * Date: 2018-07-03
 * Time: 15:09
 */
public class NO861ScoreAfterFlippingMatrix {


    /**
     * 第一种 先将行进行翻转 取最大的写入A,然后对0的个数大于总列数一半的列进行翻转
     *
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int[] tmp = new int[A[i].length];
            int a = 0;
            int b = 0;
            int cont = 1;
            for (int j = A[i].length - 1; j >= 0; j--) {
                tmp[j] = change(A[i][j]);
                a += A[i][j] * cont;
                b += tmp[j] * cont;
                cont <<= 1;
            }
            if (a < b) A[i] = tmp;
        }

        for (int j = 0; j < A[0].length; j++) {
            int cont = 0;

            for (int i = 0; i < A.length; i++) {
                if (A[i][j] == 0) cont++;
            }
            if (cont > A.length / 2) {
                for (int i = 0; i < A.length; i++) {
                    A[i][j] = change(A[i][j]);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            int a = 0;
            int cont = 1;
            for (int j = A[i].length - 1; j >= 0; j--) {
                a += A[i][j] * cont;
                cont <<= 1;
            }
            result += a;
        }
        return result;
    }

    private int change(int x) {
        return x == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        NO861ScoreAfterFlippingMatrix no861ScoreAfterFlippingMatrix = new NO861ScoreAfterFlippingMatrix();
        System.out.println(no861ScoreAfterFlippingMatrix.matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));
    }
}
