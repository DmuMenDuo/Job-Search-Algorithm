package me.menduo.leetcode;

import java.util.Arrays;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-27 14:42
 **/
public class NO165 {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        long l1=0,l2=0;
        int len = v1.length<v2.length?v2.length:v1.length;
        int len1 = v1.length;
        if(v1.length<len) v1 = Arrays.copyOf(v1,len);
        for (int i = len1; i <len ; i++) {
            v1[i]="0";
        }
        int len2 = v2.length;
        if(v2.length<len) v2 = Arrays.copyOf(v2,len);
        for (int i = len2; i <len ; i++) {
            v2[i]="0";
        }
        for(int i = 0;i<len;i++){
            if(Integer.valueOf(v1[i])<Integer.valueOf(v2[i])) return -1;
            if(Integer.valueOf(v1[i])>Integer.valueOf(v2[i])) return 1;
        }
        return 0;
    }
}
