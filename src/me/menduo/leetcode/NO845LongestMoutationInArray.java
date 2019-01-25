package me.menduo.leetcode;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-01-25 17:41
 **/
public class NO845LongestMoutationInArray {

    public int longestMountain(int[] A) {
        if(A==null||A.length<=2){
            return 0;
        }
        int result = 0;
        for (int i = 1; i <A.length-1 ; i++) {
            if(A[i-1]<A[i]&&A[i]>A[i+1]){
                int tmp = i-1;
                int res=1;
                while(tmp>=0&&A[tmp]<A[tmp+1]) {
                    res++;
                    tmp--;
                }
                tmp = i+1;
                while (tmp < A.length && A[tmp-1]>A[tmp]) {
                    res++;
                    tmp++;
                }
                result = Math.max(result,res);
            }

        }
        return result;
    }


    public static void main(String[] args) {
        NO845LongestMoutationInArray no845LongestMoutationInArray = new NO845LongestMoutationInArray();
        System.out.println(no845LongestMoutationInArray.longestMountain(new int[]{2,1,4,7,3,2,5}));
        System.out.println(no845LongestMoutationInArray.longestMountain(new int[]{2,2,2}));
    }

}
