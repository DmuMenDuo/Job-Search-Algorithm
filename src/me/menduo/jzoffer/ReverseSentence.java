package me.menduo.jzoffer;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-08 15:43
 **/
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if(str==null || "".equals(str.trim())) return str;
        str = helper(str);
        String[] strings = str.split(" ");
        for (int i = 0; i < strings.length ; i++) {
            strings[i] = helper(strings[i]);
        }
        StringBuilder sb = new StringBuilder(strings[0]);
        for (int i = 1; i < strings.length ; i++) {
            sb.append(" ");
            sb.append(strings[i]);
        }
        return sb.toString();
    }
    private String helper(String str){
        char[] chars = str.toCharArray();
        int start = 0 ;
        int end = str.length()-1;
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
        ReverseSentence reverseSentence = new ReverseSentence();
        System.out.println(reverseSentence.ReverseSentence(""));
    }

}
