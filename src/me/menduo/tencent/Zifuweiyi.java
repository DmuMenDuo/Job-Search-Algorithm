package me.menduo.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-07 19:42
 **/
public class Zifuweiyi {
    /**
     * 小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
     * 你能帮帮小Q吗？
     *
     * AkleBiCeilD
     *
     * kleieilABCD
     */
    
    private static String helper(String str){
        if(str.length()==0) return "";
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length ; i++) {
            if(chars[i]<'a' || chars[i]>'z')  count++;
        }
        int i = 0;
        while (count>0){
            if(chars[i]<'a' || chars[i]>'z') {
                int index = i;
                for (int j = i; j < chars.length-1; j++) {
                    swap(chars, j, j+1);
                }
                i = index;
                count--;
            }else {

                i++;
            }

        }

        return String.valueOf(chars);

    }

    private static void swap(char[] chars , int x,int y){
        char tmp = chars[x];
        chars[x] = chars[y];
        chars[y] = tmp;
    }
    public static void main(String[] args) {
        //String text = "hxKLAGLLzPyTxsFsrUnnSKQBHdQQrOyaEYJRgiJbHIDXFcQkFmIhPNKIBfHxXDBdKAvgZiBLVwnlxJAHmttsSJkZhSmQneNVoKoIYZRjPqsrFFaaqZbyNyeRjVKVFrCGdfycidTqbyQcpAtdRGzzBAaKoqybWMOyhrCQdwcRwQQpQavTnAbjriVwxJOrTYJVGYSWzKYeNAGqBzkJLucabNYvyVFxAGKLfqHXNttaqZfncEdTroGMzZnDbvZBBaRbJvuYIvlWrKaaGrvtyxrsCUOqxdwCrmVEeDrLKZKFJVRmrLsmbmOGUJyfdZIrFhuSwJQGRTYMLxKQNMaCavatlQIRZmFQvyWgQTVENxUcPKQCaUQbjyfaNuwoNdTBNldgrtPUcQodqsuJOdDpUczJWCZaasDdEYJkvituMHrCmZQSlRjIefVisatIUtfxBeKnHPyvWUKzRliFsYWgeXogiEgXDbfxAybwFuqFyEvjfIHEPDPKqEiGUtZhdDIDBGKpvBFyqHeEEhAToAbqHEpIdIhIGBtWjGHiQRctZxQQYkfFoWUbqZyIcjRPQBilHrnqNBzFmoRUYCSrGkawJCcOrMceegISpIpSGVjbngWVMTYtGoAlQFPFyOFAxndJZNfKDTwFIxisKTjyjchidXpYgLfoBOLriuIAHmAbQwoHBgbdUYBHlDQGZJASsHszOEPthLVnYbNqWegmONexfdsTVYHgtDmlyugefOBsqmgNDBoxkkhVHfvrYooVOyxDJQJLjYSngksbTopoPJFsKQzHePLukXyYTYCeW";
        String text = "tcswktLBAblojzStfjEqRaouXYcROiTfzSkSJVBgcFPIfAGQFXNkIyDjTAfRLbSAyySoXZjriJAPflCrKxPeqYJuGMmcSUrXsAAjlJmebkabJRogxHUrFXDzeJxdNyCrXHfezYJchHySQMmfTwuaCdlCAtgMDcgoLGQfjmmxbdlKrOPJQfIngOnscJxzrIWuaXToxZdZsLdhQSanyCqbSXtGQfrblWeQHMiMmFDNfIaxHrtTulOfjjSrRLnNouQOMhWsjUTOjYlvvfJqNBBNSHThiKPLhLnFaPJCleLNJtjVhAcnfFEHOwceZf";
        Scanner scanner = new Scanner(text);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(helper(str));
        }
        
        
    }

}
