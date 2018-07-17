package me.menduo.top100;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NO3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) return 0;
        char[] arrays = s.toCharArray();
        int res = 0;
        int head = 0;
        int tail = 0;
        Set<Character> sc = new HashSet<>();
        while (head < arrays.length && tail < arrays.length) {
            if (!sc.contains(arrays[tail])) {
                sc.add(arrays[tail]);
                tail++;
                res = Math.max(res, tail - head);
            } else {
                sc.remove(arrays[head]);
                head++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        NO3LongestSubstringWithoutRepeatingCharacters no3LongestSubstringWithoutRepeatingCharacters
                = new NO3LongestSubstringWithoutRepeatingCharacters();

        System.out.println(no3LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abba"));
        System.out.println(no3LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(no3LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
    }
}
