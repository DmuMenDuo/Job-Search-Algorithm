package me.menduo.leetcode;

/**
 * @author: menduo
 * @description:
 * @date: Created on 18-1-17
 * @modified by:
 */
public class Top6ZigZagConversion {
    public String convert(String s, int numRows) {

        if(numRows==1){
            return s;
        }
        char[][] tmp = new char[s.length()+1][numRows];
        char[] chars = s.toCharArray();
        int i=0,x=0,y=0;
        while(i<chars.length){
            if(y==0) {
                while(y<numRows){
                    if(i==chars.length){
                        break;
                    }
                    tmp[x][y++] = chars[i++];

                }
                y--;
                continue;
            }
            for(int n=0;n<numRows-2;n++){
                x++;
                y--;
                if(i==chars.length){
                    break;
                }
                tmp[x][y] = chars[i++];
            }
            y--;
            x++;
        }
        String result="";
        for(int q=0;q<numRows;q++){
            for(int p=0;p<tmp.length;p++){
                if(tmp[p][q]!='\u0000') result += tmp[p][q];
            }
        }
        return result;
    }
    public String convert2(String s, int numRows) {
        char[] chars = s.toCharArray();
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int m=0;m<numRows;m++) sbs[m] = new StringBuilder();
        int i=0;
        while(i<s.length()){
            for(int j=0;j<numRows&&i<s.length();j++)
                sbs[j].append(chars[i++]);

            for(int j=numRows-2;j>0&&i<s.length();j--){
                sbs[j].append(chars[i++]);
            }
        }

        for(int j=1;j<sbs.length;j++){
            sbs[0].append(sbs[j]);
        }
        return sbs[0].toString();
    }
    public static void main(String[] args) {
        //convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"

        Top6ZigZagConversion top6ZigZagConversion = new Top6ZigZagConversion();
        String eg1 = "PAYPALISHIRING";
        System.out.println(top6ZigZagConversion.convert2(eg1,3));
        String eg2 = "ABCDE";
        System.out.println(top6ZigZagConversion.convert2(eg2,4));
        String eg3 = "AB";
        System.out.println(top6ZigZagConversion.convert2(eg3,1));

    }
}
