package me.menduo.jzoffer;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-26 21:57
 **/
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        int len = str.length()-1;
        for (int i = 0; i <= len; i++) {
            if(str.charAt(i)==' ')
                str.append("  ");
        }
        int new_len = str.length()-1;
        while(len>=0 && new_len > len){
            if(str.charAt(len)!=' ')
                str.setCharAt(new_len--,str.charAt(len));
            else {
                str.setCharAt(new_len--, '0');
                str.setCharAt(new_len--, '2');
                str.setCharAt(new_len--, '%');
            }
            len--;
        }
        return str.toString();

    }
}
