package me.menduo.top100;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2018-10-04 20:01
 **/
public class NO392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s==null&&t==null) return true;
        if("".equals(s)) return true;

        if(s==null || t==null) return false;
        if(t.length()<s.length()) return false;
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        int i=0,j=0;
        while(j<t.length()&&i<s.length()){
            if(ss[i]==ts[j]) {
                i++;
                j++;
            }else{
                j++;
            }
        }

        if(j == t.length() && i != s.length()){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        NO392IsSubsequence no392IsSubsequence = new NO392IsSubsequence();
        System.out.println(no392IsSubsequence.isSubsequence("acb","ahbgdc"));
    }
}
