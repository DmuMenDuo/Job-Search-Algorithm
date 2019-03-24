package me.menduo.leetcode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-24 21:38
 **/
public class NO46 {
    public  String multiply(String num1, String num2) {
        if(num1.length()==0 || num2.length()==0) return "";
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int m = chars1.length-1;
        int n = chars2.length-1;
        int[] result = new int[m+n+2];
        for (int i = m; i >= 0 ; i-- ) {
            for (int j = n; j >= 0; j--) {
                int mult = (chars1[i] - '0') * (chars2[j] - '0');
                mult += result[i+j+1];
                result[i+j] += mult / 10;
                result[i+j+1] = mult % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < result.length ; i++) {
            if(result[i]!=0) flag = true;
            if(flag) sb.append(result[i]);
        }
        if(!flag) return "0";
        return sb.toString();
    }
}
