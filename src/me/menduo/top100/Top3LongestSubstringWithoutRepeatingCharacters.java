package me.menduo.top100;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: menduo
 * @description:
 * @date: Create in 20:22 2017/11/16
 * @motified by:
 */
public class Top3LongestSubstringWithoutRepeatingCharacters {
    /**
     * 滑动窗口的方式 窗口为[i,j],当窗口的下一个值也就是j+1 在窗口中有，那么窗口缩小，缩小的方式为i++
     * 时间复杂度O(2n) = O(n)
     *  @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> h = new HashSet<>();
        int i=0,j=0;
        int ans =0;
        while(i<n&&j<n){
            if(h.contains(s.charAt(j))){
                h.remove(s.charAt(i++));
            }else{
                h.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            }

        }

        return ans;
    }

    /**
     * 改良版 记录重复发生时的位置，每次不用一步一步的移动，而是直接移动到记录的位置+1（看注释解释这里）
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_2(String s) {
        int n = s.length();
        HashMap<Character,Integer> h = new HashMap<>();
        int i=0,j=0;
        int ans =0;
        while(i<n&&j<n){
            if(h.containsKey(s.charAt(j))){
                //这里要注意：i确实要移动到重复的j再加1的位置，
                // 但如果在发现重复的，这个重复的位置比i小是不移动的，也就是滑动完窗口后，以前的记录就作废了，窗口从0开始
                //eg. abba
                //    0123
                // 当j下标为2时为b,发现重复,取得hashmap中b的位置为1，这时i=2了
                // 下一次为a,又重复,hashmap中位置为0,如果不比较现在的i和要移动的i的位置，i就会从2变为1，窗口就会回去，导致结果变大
                i=Math.max(h.get(s.charAt(j))+1,i);
            }
            h.put(s.charAt(j),j++);
            ans = Math.max(ans,j-i);
        }

        return ans;
    }

    /**
     * 改良2：hashmap的cantain是需要时间查找的，因为题中只是字符串，我们完全可以用一个int数组解决问题，这样o(1)就可以找到了
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_3(String s) {
        int n = s.length();
        int[] index = new int[128];
        int i=0,j=0;
        int ans = 0;
        while(i<n&&j<n){
            i = Math.max(index[s.charAt(j)],i);
            ans = Math.max(ans,j-i+1);
            index[s.charAt(j)] = j+1;
            j++;
        }
        return ans;
    }
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        Top3LongestSubstringWithoutRepeatingCharacters t3 = new Top3LongestSubstringWithoutRepeatingCharacters();
        System.out.println(t3.lengthOfLongestSubstring_3(s1));
        System.out.println(t3.lengthOfLongestSubstring_3(s2));
        System.out.println(t3.lengthOfLongestSubstring_3(s3));
    }
}
