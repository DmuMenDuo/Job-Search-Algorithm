package me.menduo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: menduo email:demon9607@163.com
 * Date: 2018-07-01
 * Time: 13:12
 */
public class NO17LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits.length() <= 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        char[][] map = new char[][]{{0}, {1},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        char[] arrayc = digits.toCharArray();
        int[] array = new int[arrayc.length];
        for (int i = 0; i < arrayc.length; i++) {
            array[i] = Integer.parseInt(String.valueOf(arrayc[i]));
        }
        comb(result, array, map, "", 0);
        return result;
    }

    private void comb(List<String> result, int[] array, char[][] map, String tmp, int x) {
        if (x == array.length) {
            result.add(tmp);
        } else {
            for (int i = 0; i < map[array[x]].length; i++) {
                comb(result, array, map, tmp + map[array[x]][i], x + 1);
            }
        }
    }

    public static void main(String[] args) {
        NO17LetterCombinationsOfAPhoneNumber no17LetterCombinationsOfAPhoneNumber = new NO17LetterCombinationsOfAPhoneNumber();
        List<String> a = no17LetterCombinationsOfAPhoneNumber.letterCombinations("23");
        System.out.println(Arrays.toString(a.toArray()));
    }
}
