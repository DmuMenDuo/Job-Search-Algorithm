package me.menduo.leetcode;

public class NO191NumberOf1Bits {
    // you need to treat n as an unsigned value

    /**
     * 坑在 n!=0 千万不要写n>0 因为是无符号。n可能会被认为是负数。
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        //System.out.println(2>>1);
        int cont = 0;
        while (n != 0) {
            n = n & (n - 1);
            cont++;
        }

        return cont;
    }

    public static void main(String[] args) {
        NO191NumberOf1Bits no191NumberOf1Bits = new NO191NumberOf1Bits();
        System.out.println(no191NumberOf1Bits.hammingWeight(11));
        System.out.println(no191NumberOf1Bits.hammingWeight(2147483647));
    }
}
