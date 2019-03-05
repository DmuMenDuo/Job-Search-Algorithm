package me.menduo.jzoffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-04 15:21
 **/
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        int[] hashtable = new int[256];
        char[] chars = str.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            hashtable[chars[i]]++;
        }

        for (int i = 0; i < chars.length; i++) {
            if(hashtable[chars[i]]==1) return i;
        }

        return -1;
    }
    public static void main(String[] args) {
        FirstNotRepeatingChar firstNotRepeatingChar = new FirstNotRepeatingChar();
        System.out.println(firstNotRepeatingChar.FirstNotRepeatingChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp"));
    }
}
