package me.menduo.leetcode;

/**
 * User: menduo email:demon9607@163.com
 * Date: 2018-07-03
 * Time: 13:21
 */
public class NO29DivideTwoInteger {
    public int divide(int dividend, int divisor) {
        boolean flag = false;
        if ((dividend < 0) ^ (divisor < 0)) flag = true;
        long div = dividend;
        long divi = divisor;

        if (divi == -1 && div == -2147483648) {
            return 2147483647;
        }
        if (div < 0) div = 0 - div;
        if (divi < 0) divi = 0 - divi;

        int cont = 0;
        while (div >= divi) {
            long t = divi;
            long i = 1;
            while (div >= (t << 1)) {
                t <<= 1;
                i <<= 1;
            }
            div -= t;
            cont += i;
        }
        if (flag) return 0 - cont;
        return cont;
    }

    public static void main(String[] args) {
        NO29DivideTwoInteger no29DivideTwoInteger = new NO29DivideTwoInteger();
        System.out.println(no29DivideTwoInteger.divide(-2147483648, -1));
        System.out.println(no29DivideTwoInteger.divide(7, -2));
    }
}
