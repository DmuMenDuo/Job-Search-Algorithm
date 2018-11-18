package me.menduo.leetcode;

public class NO537ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        String[] a1 = a.split("\\+");
        String[] a2 = b.split("\\+");
        int x1 = Integer.parseInt(a1[0]);
        int x2 = Integer.parseInt(a2[0]);
        int y1 = Integer.parseInt(a1[1].split("i")[0]);
        int y2 = Integer.parseInt(a2[1].split("i")[0]);
        return (x1 * x2 - y1 * y2) + "+" + (x1 * y2 + x2 * y1) + "i";
    }

    public static void main(String[] args) {
        NO537ComplexNumberMultiplication no537ComplexNumberMultiplication = new NO537ComplexNumberMultiplication();
        System.out.println(no537ComplexNumberMultiplication.complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
