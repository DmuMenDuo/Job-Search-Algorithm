package me.menduo.top100;

public class Top5LongestPalindromicSubstring {

    private String longestPalindrome(String s) {
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int len1 = findPalindrome(s,i,i);
            int len2 = findPalindrome(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > end-start){
                start = i-(len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);

    }
    private int findPalindrome(String s,int l,int r){
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            //这里l多减了,r多加了，所以最后return结果要减2 r-l+1-2 = r-l-1;
            l--;
            r++;
        }
        return r-l-1;
    }
    public static void main(String[] args) {
        Top5LongestPalindromicSubstring top5LongestPalindromicSubstring = new Top5LongestPalindromicSubstring();
//        Example:
//
//        Input: "babad"
//
//        Output: "bab"
//
//        Note: "aba" is also a valid answer.
        System.out.println(top5LongestPalindromicSubstring.longestPalindrome("babad"));
//        Example:
//
//        Input: "cbbd"
//
//        Output: "bb"
        System.out.println(top5LongestPalindromicSubstring.longestPalindrome("cbbd"));
    }
}
