package me.menduo.jzoffer;

import java.util.Arrays;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-04 14:40
 **/
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        Arrays.sort(numbers);
        if(numbers.length<=0) return "";
        if(numbers.length==1) return String.valueOf(numbers[0]);
        String start = String.valueOf(numbers[0]);
        for (int i = 1; i <numbers.length ; i++) {
            start = compare(start,String.valueOf(numbers[i]));
        }
        return start;
    }

    private String compare(String x,String y){
        char[] s1 = (x+y).toCharArray();
        char[] s2 = (y+x).toCharArray();
        int length = s1.length;
        for (int i = 0; i <length ; i++) {
            if(s1[i]>s2[i]){
                return String.valueOf(s2);
            }else if(s1[i]<s2[i]){
                return String.valueOf(s1);
            }
        }

        return String.valueOf(s1);
    }

    public static void main(String[] args) {
        PrintMinNumber printMinNumber = new PrintMinNumber();
        System.out.println(printMinNumber.PrintMinNumber(new int[]{3,32,321}));
    }
}
