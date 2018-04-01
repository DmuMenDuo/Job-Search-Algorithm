package me.menduo.top100;

public class NO242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] result = new int[26];
        for(int i=0;i<s.length();i++) {
            result[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++) {
            result[t.charAt(i)-'a']--;
        }
        for(int i = 0 ; i< result.length;i++){
            if(result[i]!=0) return false;
        }
        return  true;
    }

}
