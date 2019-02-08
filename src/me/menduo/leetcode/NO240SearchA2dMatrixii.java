package me.menduo.leetcode;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-06 14:23
 **/
public class NO240SearchA2dMatrixii {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int i = matrix.length-1;
        int j=0;
        while(i>=0&&j<matrix[0].length){
            if(matrix[i][j]==target) return true;
            else if (matrix[i][j]>target) i--;
            else j++;
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
