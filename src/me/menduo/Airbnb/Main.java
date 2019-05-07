package me.menduo.Airbnb;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String result = "";
            //todo
            result = generateBio(input);
            System.out.println(result);
        }
    }

    private static String generateBio(String input) {
        // first_name,last_name,email,interests,notes,city,age
        //"John ""Mo""",Smith,sfn@flkaei.km,biking and hiking,,"Seattle, WA",23
        // [first_name], [age] years old, is from [city] and is interested in [interests].
        // John "Mo", 23 years old, is from Seattle, WA and is interested in biking and hiking.
        List<String> bio = new ArrayList();
        doProcessInput(bio, input);
        //valid bio size()
        return generateOutput(bio);
    }

    private static void doProcessInput(List<String> bio, String input) {
        // 双引号里面有逗号 . 双引号后面有双引号 .
        char[] array = input.toCharArray();
        int cur = 0;
        while (cur < array.length) {
            //Elena,Martinez,emrt@lsofnbr.rt,"cooking, traveling",superhost,Valencia,42
            //"John ""Mo""",Smith,sfn@flkaei.km,biking and hiking,,"Seattle, WA",23
            StringBuilder sb = new StringBuilder();
            if (array[cur] == '"' ) {
                cur++;
                while(true) {
                    //""jonin, nihao"",
                    //""John ""Mo""",
                    if (array[cur] == '"' && array[cur + 1] == '"') {
                        cur++;
                        sb.append(array[cur++]);
                    } else if (array[cur] == '"' && (cur+1 >= array.length || array[cur + 1] == ',')) {
                        cur++;
                        break;
                    } else if (array[cur] == ',' && array[cur - 1] == '"') {
                        break;
                    } else {
                        sb.append(array[cur]);
                        cur++;
                    }
                }
            } else {
                while (cur < array.length && array[cur]!=',') {
                    sb.append(array[cur++]);
                }
            }
            bio.add(sb.toString());
            cur++; //这里处理最后的逗号
        }
    }

    private static String generateOutput(List<String> bio) {
        // [first_name], [age] years old, is from [city] and is interested in [interests].
        // John "Mo", 23 years old, is from Seattle, WA and is interested in biking and
        // hiking.
        // first_name,last_name,email,interests,notes,city,age
//        StringBuilder sb = new StringBuilder();
//        sb.append(bio.get(0)).append(", ")
//                .append(bio.get(6)).append(" years old, is from ")
//                .append(bio.get(5)).append(" and is interested in ")
//                .append(bio.get(3)).append(".");
        String sb = String.format("%s, %s years old, is from %s and is interested in %s",bio.get(0),bio.get(6),bio.get(5),bio.get(3));
        return sb;
    }


}

