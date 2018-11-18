package me.menduo.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class NO387FirstUniqChar {
    public int firstUniqChar(String s) {
        char[] x = s.toCharArray();
        Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
        for(int i=0;i<x.length;i++) {
            if(!map.containsKey(x[i])) {
                map.put(x[i],1);
            }else {
                map.put(x[i],map.get(x[i])+1);
            }
        }

        Character m = null;
        for(Map.Entry<Character,Integer> en : map.entrySet()){
            if(en.getValue() == 1) {

                m = en.getKey();
                break;
            }
        }
        if(m == null ) return -1;
        return s.indexOf(m.toString());
    }
    public static void main(String[] args) {
        NO387FirstUniqChar no387FirstUniqChar = new NO387FirstUniqChar();
        System.out.println(no387FirstUniqChar.firstUniqChar("teetcooce"));
    }
}
