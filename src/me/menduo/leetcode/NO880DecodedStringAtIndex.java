package me.menduo.leetcode;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-02 16:06
 **/
public class NO880DecodedStringAtIndex {
    public String decodeAtIndex(String S, int K) {
        long N = 0;
        char[] chars = S.toCharArray();
        int i = 0;
        for (; N < K ; i++) {
            if(Character.isDigit(chars[i])){
                N*=chars[i]-'0';
            }else {
                N+=1;
            }
        }
        while (i>=0){
            i--;
            if(Character.isDigit(chars[i])){
                N/=chars[i]-'0';
            }else if (K%(N--)==0){
                return chars[i]+"";
            }

        }
        return "";
    }
    public static void main(String[] args) {
        NO880DecodedStringAtIndex no880DecodedStringAtIndex = new NO880DecodedStringAtIndex();
        System.out.println(no880DecodedStringAtIndex.decodeAtIndex("leet2code3",10));
        System.out.println(no880DecodedStringAtIndex.decodeAtIndex("ha22",5));
        System.out.println(no880DecodedStringAtIndex.decodeAtIndex("a2345678999999999999999",1));
        System.out.println(no880DecodedStringAtIndex.decodeAtIndex("abc",3));
    }
}
