package me.menduo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-01 13:17
 **/
public class NO804UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        if(words==null||words.length==0) return 0;
        String[] map = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> result = new HashSet<>();
        for (String x: words) {
            char[] chars = x.toCharArray();
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i <chars.length ; i++) {
                //System.out.println(map[chars[i]-'a']);
                tmp.append(map[chars[i] - 'a']);
            }
            result.add(tmp.toString());
        }
        return result.size();
    }
    public static void main(String[] args) {
        NO804UniqueMorseCodeWords no804UniqueMorseCodeWords = new NO804UniqueMorseCodeWords();
        System.out.println(no804UniqueMorseCodeWords.uniqueMorseRepresentations(null));
    }
}
