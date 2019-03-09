package me.menduo.jzoffer;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-08 17:23
 **/
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if(str == null) return "";
        if(n==0) return str;
        char[] chars =str.toCharArray();
        helper(chars,0,n-1);
        helper(chars,n,str.length()-1);
        helper(chars,0,str.length()-1);
        return String.valueOf(chars);

    }

    private String helper(char[] chars,int start,int end){
        while (start<end){
            swap(chars,start++,end--);
        }
        return String.valueOf(chars);
    }

    private void swap(char[] chars,int x,int y){
        char tmp = chars[x];
        chars[x] = chars[y];
        chars[y] = tmp;
    }

    public static void main(String[] args) {
        LeftRotateString leftRotateString = new LeftRotateString();
        System.out.println(leftRotateString.LeftRotateString("abcABCdef",3));
    }
}
