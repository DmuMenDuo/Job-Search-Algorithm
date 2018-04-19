package me.menduo.aiqiyi;

import java.util.Scanner;

public class Test1 {
    /**
     * 在求字典序最大的子串
     *
     * 逆向实现的思路：从主串的最后一个字母出发，向前遍历，
     * 如果前边的字母大于等于后边串中最大的字母，那么保存下来，最后逆序输出即可。
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String x = sc.nextLine();
            char[] str = x.toCharArray();
            int max = 0;
            String res="";
            for(int i=str.length-1;i>=0;i--){
                if(str[i]>=max) {
                    max=str[i];
                    res+=str[i];
                }
            }
            System.out.println(res);
        }
    }
}
