package me.menduo.top100;

import java.util.Arrays;

public class NO43MutipyStrings {
    public String multiply(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        char[][] tmp = new char[n2.length][n2.length + n1.length];
        for (int i = 0; i < n2.length; i++) {
            Arrays.fill(tmp[i], '0');
        }
        int cont = 1;
        for (int i = 0; i < n2.length; i++) {
            int up = 0;
            for (int j = n1.length - 1; j >= 0; j--) {
                int val = (n2[i] - '0') * (n1[j] - '0');
                tmp[i][j + cont] = (char) ((val + up) % 10 + '0');
                up = (val + up) / 10;
            }
            if (up != 0) tmp[i][cont - 1] = (char) (up + '0');
            cont++;

        }
        char[] res = new char[tmp[0].length];
        Arrays.fill(res, '0');
        int up = 0;
        for (int i = tmp[0].length - 1; i >= 0; i--) {
            int row = 0;
            for (int j = 0; j < tmp.length; j++) {
                row += (tmp[j][i] - '0');
            }
            res[i] = (char) ((row + up) % 10 + '0');
            up = (row + up) / 10;
        }
        //System.out.println(res.toString());
        StringBuilder sb = new StringBuilder();
        int flag = 1;
        for (int i = 0; i < res.length; i++) {
            if (flag == 1 && res[i] == '0' && i!=res.length-1) {
                continue;
            } else {
                flag = 0;
                sb.append(res[i]);
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NO43MutipyStrings no43MutipyStrings = new NO43MutipyStrings();
//        System.out.println(no43MutipyStrings.multiply("9", "9"));
        System.out.println(no43MutipyStrings.multiply("999", "0"));
    }
}
