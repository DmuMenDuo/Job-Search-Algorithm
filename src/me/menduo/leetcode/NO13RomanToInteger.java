package me.menduo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NO13RomanToInteger {
    private void init(Map map) {
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
    }

    public int romanToInt(String s) {
        if (s == null || "".equals(s)) return 0;
        Map<String, Integer> map = new HashMap<>();
        init(map);
        char[] c = s.toCharArray();
        int res = 0;
        int i = 0;
        while (i < c.length) {
            if (i + 1 < c.length && map.containsKey("" + c[i] + c[i + 1])) {
                res += map.get("" + c[i] + c[i + 1]);
                i += 2;
            } else {
                res += map.get("" + c[i]);
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NO13RomanToInteger no13RomanToInteger = new NO13RomanToInteger();
        System.out.println(no13RomanToInteger.romanToInt("III"));
        System.out.println(no13RomanToInteger.romanToInt("IV"));
        System.out.println(no13RomanToInteger.romanToInt("MCMXCIV"));
        System.out.println(no13RomanToInteger.romanToInt("LVIII"));

    }
}
