package me.menduo.others;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-05 21:40
 **/
public class ShortUrl {

    private static final String[] ARRAY = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    public static void main(String[] args) {
        ShortUrl shortUrl = new ShortUrl();
        System.out.println(shortUrl.generate("http://tool.oschina.net/commons"));
    }

    private String generate(String url){
        String key = "webide";
        String[] chars = new String[] {"a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" ,
                "i" , "j" , "k" , "l" , "m" , "n" , "o" , "p" , "q" , "r" , "s" , "t" ,
                "u" , "v" , "w" , "x" , "y" , "z" , "0" , "1" , "2" , "3" , "4" , "5" ,
                "6" , "7" , "8" , "9" , "A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" ,
                "I" , "J" , "K" , "L" , "M" , "N" , "O" , "P" , "Q" , "R" , "S" , "T" ,
                "U" , "V" , "W" , "X" , "Y" , "Z"};
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String hashString = bytes2HashString(messageDigest.digest((url+key).getBytes())); //32位hashString
        String aResult[] = new String[4];
        for (int i = 0; i <4 ; i++) {

            String tmp = hashString.substring(i*8,i*8+8);

            long num = 0x3FFFFFFF & Long.parseLong(tmp,16);
            String output = "";
            for (int j = 0; j < 6 ; j++) {
                long index = 0x0000003D & num;
                output+=chars[(int)index];
                num = num>>5;
            }
            aResult[i]=output;
            System.out.println(output);
        }
        return aResult[0];
    }

    private String bytes2HashString(byte[] bytes){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b:bytes) {
            stringBuilder.append(byte2HashString(b));
        }
        return stringBuilder.toString();
    }
    private String byte2HashString(byte b) {
        int n = b;
        if(n<0) n+=256;

        int d1 = n/16;
        int d2 = n%16;
        return ARRAY[d1] + ARRAY[d2];
    }


}
