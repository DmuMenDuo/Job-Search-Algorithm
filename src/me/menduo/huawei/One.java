package me.menduo.huawei;

import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-27 18:50
 **/
public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String str = scanner.next();
            char[] chars = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <chars.length ; i+=9) {
                if(chars[i]=='0'){
                    reverse(sb,chars,i+1,i+8);
                }else if(chars[i]=='1') {
                    print(sb,chars,i+1,i+8);
                }
            }
            System.out.println(sb.deleteCharAt(sb.length()-1).toString());

        }
    }
    private static void print(StringBuilder sb,char[] chars,int start,int end) {
        while (start<=end){
            sb.append(chars[start++]);
        }
        sb.append(" ");
    }
    private static void reverse(StringBuilder sb,char[] chars,int start,int end){
        while(end>=start){
            sb.append(chars[end--]);
        }
        sb.append(" ");
    }
}
