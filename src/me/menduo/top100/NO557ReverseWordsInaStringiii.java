package me.menduo.top100;

public class NO557ReverseWordsInaStringiii {
    public String reverseWords(String s) {
        if(s == null || "".equals(s)) return "";

        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<strs.length-1;i++){
            strs[i] = reverse(strs[i]);

            sb.append(strs[i]+" ");
        }
        sb.append(reverse(strs[strs.length-1]));
        return sb.toString();

    }
    public String reverse(String x){
        char[] chars = x.toCharArray();
        int i=0;
        int j=chars.length-1;
        while(i<j){
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }
    public static void main(String[] args) {
        NO557ReverseWordsInaStringiii no557ReverseWordsInaStringiii = new NO557ReverseWordsInaStringiii();
        System.out.println(no557ReverseWordsInaStringiii.reverseWords("Let's take LeetCode contest"));
    }
}
