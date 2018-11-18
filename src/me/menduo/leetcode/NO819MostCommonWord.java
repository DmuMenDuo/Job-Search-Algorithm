package me.menduo.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class NO819MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        //paragraph = paragraph.replaceAll("\\pP","");
        paragraph = paragraph.toLowerCase();
        HashSet<String> set = new HashSet<>();
        for(String x:banned) {
            set.add(x);
        }
        int max=0;
        String res=null;
        String[] md = paragraph.split(" ");
        HashMap<String,Integer> map = new HashMap<>();
        for(String x:md){
            if(!Character.isLetter(x.charAt(x.length()-1)))
                x=x.substring(0,x.length()-1);
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);

            }else {
                map.put(x,1);
            }
            if(!set.contains(x)&&map.get(x)>max) {
                max=map.get(x);
                res = x;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NO819MostCommonWord no819MostCommonWord = new NO819MostCommonWord();
        System.out.println(no819MostCommonWord.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit."
                ,new String[]{"hit"}));
    }
}
