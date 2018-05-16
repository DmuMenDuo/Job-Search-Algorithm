package me.menduo.top100;

public class NO461HammingDistance {
    public int hammingDistance(int x, int y) {
        int cont = 0;
        int xor = x ^ y;
        while (xor != 0) {
            xor = xor & (xor - 1);
            cont++;

        }
        return cont;

    }

    public static void main(String[] args) {
        NO461HammingDistance no461HammingDistance = new NO461HammingDistance();
        System.out.println(no461HammingDistance.hammingDistance(1, 4));
    }
}
