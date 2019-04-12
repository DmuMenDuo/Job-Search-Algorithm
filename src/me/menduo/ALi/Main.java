package me.menduo.ALi;



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int[] numArray;
    static int[] reverseArray;
    static Map<Integer,Integer> map;
    static String calculate(int m, int k) {
        generalNumArray(m);//第m的编号
        generalMap(); //设置映射关系
        reverseArray(numArray); // 反转m,m-k+1为第k大
        int year = getYear(m) + 2019;
        return numArray[m] + "," + year  +"," + map.get(reverse(reverseArray[m-k+1]));
    }

    private static int getYear(int m){
        int one = 1;
        int two = 1;
        int tmp = 0;
        int year = 0;
        while (tmp < m) {
            tmp = one + two;
            one = two;
            two = tmp;
            year++;
        }
        return year-1;
    }

    private static void generalNumArray(int m) {
        if(m <= 3) numArray = new int[4];
        else numArray = new int[m+1];
        numArray[1] = 2;
        numArray[2] = 3;
        numArray[3] = 4;
        for (int i = 4; i < m+1 ; i++) {
            numArray[i] = numArray[i-2] + numArray[i-3];
        }
    }

    private static void generalMap() {
        map = new HashMap<>();
        for (int i = 0; i < numArray.length ; i++) {
            map.put(numArray[i],i);
        }
    }

    private static void reverseArray(int[] array) {
        reverseArray = new int[array.length];
        for (int i = 0; i < array.length ; i++) {
            reverseArray[i] = reverse(array[i]);
        }
        Arrays.sort(reverseArray);
    }
    private static int reverse(int num) {
        String x = String.valueOf(num);
        char[] chars = x.toCharArray();
        int start = 0, end = chars.length-1;
        while (start<end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
        return Integer.parseInt(String.valueOf(chars));
    }

    public static void main(String[] args){
        Scanner in = new Scanner("20,3");
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(m, k));

    }
}