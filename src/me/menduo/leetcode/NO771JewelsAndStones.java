package me.menduo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-01-25 18:39
 **/
public class NO771JewelsAndStones {
    public static void main(String[] args) {
        NO771JewelsAndStones no771JewelsAndStones =new NO771JewelsAndStones();
        System.out.println(no771JewelsAndStones.numJewelsInStones("aA","aAAbbbb"));
    }

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        char[] jewels = J.toCharArray();
        for (int i = 0; i < jewels.length; i++) {
            set.add(jewels[i]);
        }
        char[] stone = S.toCharArray();
        int result=0;
        for (char s:stone) {
            if(set.contains(s))
                result++;
        }


        return result;
    }
}
