package me.menduo.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-04 13:55
 **/
public class Permutation {
    ArrayList<String> result = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {

        helper(str.toCharArray(),0,str.length()-1);
        Collections.sort(result);
        return result;
    }

    private void  helper(char[] chars,int start,int end) {
       if(start==end){
           if(!result.contains(String.valueOf(chars)))
               result.add(String.valueOf(chars));
           return;
       }else {
           for (int i = start; i <=end; i++) {
               swap(chars,i,start);
               helper(chars,start+1,end);
               swap(chars,i,start);
           }
       }

    }

    private void swap(char[] chars,int m,int n){
        char tmp = chars[m];
        chars[m] = chars[n];
        chars[n] = tmp;
    }
    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.Permutation("aa");
        System.out.println();
    }
}
