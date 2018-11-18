package me.menduo.leetcode;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2018-10-02 20:18
 **/
public class NO357CountNumbersWithUniqueDigits {
    /**
     *  10的0次幂是1
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0 ) return 1;
        if(n>10) n = 10;
        return getf(n);
    }

    public int getf(int k) {
        if(k==1) return 10;
        int cont = 9;
        int res = 9;
        for(int i=1;i<k;i++){
            res*=cont;
            cont--;
        }
        return getf(k-1) + res;
    }

    public static void main(String[] args) {
        NO357CountNumbersWithUniqueDigits no357CountNumbersWithUniqueDigits = new NO357CountNumbersWithUniqueDigits();
        System.out.println(no357CountNumbersWithUniqueDigits.countNumbersWithUniqueDigits(0));
        System.out.println(no357CountNumbersWithUniqueDigits.countNumbersWithUniqueDigits(4));
    }
}
