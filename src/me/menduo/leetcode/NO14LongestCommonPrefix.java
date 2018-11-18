package me.menduo.leetcode;

import java.util.Arrays;

public class NO14LongestCommonPrefix {
    /**
     * 9ms
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        Arrays.sort(strs, (o1, o2) -> o1.length() < o2.length() ? -1 : 1);
        char[] x = strs[0].toCharArray();
        for(int i=0;i<x.length;i++) {
           for(int j=1;j<strs.length;j++) {
               if(strs[j].charAt(i)!=x[i]) {
                   return strs[0].substring(0,i);
               }
           }
        }
        return strs[0];
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++) {
            while(strs[i].indexOf(prefix)!=0)
                prefix = prefix.substring(0,prefix.length()-1);
        }
        return prefix;
    }

    public static void main(String[] args) {
        NO14LongestCommonPrefix no14LongestCommonPrefix = new NO14LongestCommonPrefix();
        String[] m = {"abcd","aba","abc"};
        System.out.println(no14LongestCommonPrefix.longestCommonPrefix2(m));
    }
}
