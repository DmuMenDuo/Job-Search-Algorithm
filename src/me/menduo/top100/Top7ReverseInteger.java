package me.menduo.top100;

/**
 *
 * 多考虑边界值 负数，翻转超界
 * @author: menduo
 * @description:
 * @date: Created on 18-1-26
 * @modified by:
 */
public class Top7ReverseInteger {
    public int reverse(int x) {
        boolean signal = true;
        if(x<0) signal = false;
        long result=0;
        int tmp = x;
        while(tmp!=0){
            int u = tmp % 10;
            tmp = tmp / 10;
            result = (result+u)*10;

        }
        result/=10;
        if(result>Integer.MAX_VALUE && signal){
            return 0;
        }else if(result<Integer.MIN_VALUE){
            return 0;
        }else {
            return (int)result;
        }
    }
    public static void main(String[] args) {
        int eg1 = 1534236469;
        int eg2 = -123;
        int eg3 = 120;
        int eg4 = 563847412;
        int eg5 = -2147483412;
        int eg6 = 1534236469;

        Top7ReverseInteger top7ReverseInteger = new Top7ReverseInteger();
        System.out.println(top7ReverseInteger.reverse(eg1));
        System.out.println(top7ReverseInteger.reverse(eg2));
        System.out.println(top7ReverseInteger.reverse(eg3));
        System.out.println(top7ReverseInteger.reverse(eg4));
        System.out.println(top7ReverseInteger.reverse(eg5));
        System.out.println(top7ReverseInteger.reverse(eg6));
    }
}
