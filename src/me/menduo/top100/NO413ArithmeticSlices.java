package me.menduo.top100;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2018-10-05 23:28
 **/
public class NO413ArithmeticSlices {
    /**
     * 题目要求是连续的三个数，不考虑非连续的情况
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices(int[] A) {
        if(A==null || A.length <=2) return 0;
        int dp_cont = 0;
        int dp_cons = 2;
        for(int i=2;i<A.length;i++) {
            if(A[i]-A[i-1] == A[i-1]-A[i-2]) {
                dp_cont += dp_cons - 1;
                dp_cons++;
            }else{
                //等差数列断掉，从新开始
                dp_cons = 2;
            }
        }

        return dp_cont;

    }
    public static void main(String[] args) {
        NO413ArithmeticSlices no413ArithmeticSlices = new NO413ArithmeticSlices();
        System.out.println(no413ArithmeticSlices.numberOfArithmeticSlices(new int[]{1,2,3,4,5}));
    }

}
