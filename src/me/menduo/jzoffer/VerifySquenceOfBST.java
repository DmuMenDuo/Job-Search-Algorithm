package me.menduo.jzoffer;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-03 15:51
 **/
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0) return false;
        return helper(sequence,0,sequence.length-1);
    }

    private boolean helper(int[] sequence,int start,int end){
        if(start>=end) return true;
        int cur = sequence[end];
        int i = start;
        for (; i <=end ; i++) {
            if(sequence[i]>=cur){
                break;
            }
        }

        for (int j=i; j <end ; j++) {
            if(sequence[j]<cur){
                return false;
            }
        }
        return helper(sequence,start,i-1) && helper(sequence,i,end-1);

    }

    public static void main(String[] args) {
        VerifySquenceOfBST verifySquenceOfBST =new VerifySquenceOfBST();
        System.out.println(verifySquenceOfBST.VerifySquenceOfBST(new int[]{5,7,6,9,11,10,8}));
    }
}
