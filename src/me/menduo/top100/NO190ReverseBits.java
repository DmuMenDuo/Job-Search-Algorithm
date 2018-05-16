package me.menduo.top100;

public class NO190ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n = n >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        NO190ReverseBits no190ReverseBits = new NO190ReverseBits();
        System.out.println(no190ReverseBits.reverseBits(43261596));
    }
}
