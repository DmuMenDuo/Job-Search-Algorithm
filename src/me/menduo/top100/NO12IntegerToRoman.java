package me.menduo.top100;

import java.util.HashMap;
import java.util.Map;

public class NO12IntegerToRoman {
    private void init(Map map) {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        init(map);
        StringBuilder sb = new StringBuilder();
        int[] x = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int i = 0;
        while (num > 0) {
            if (num - x[i] >= 0) {
                sb.append(map.get(x[i]));
                num -= x[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NO12IntegerToRoman no12IntegerToRoman = new NO12IntegerToRoman();
        System.out.println(no12IntegerToRoman.intToRoman(1994));
    }
}
