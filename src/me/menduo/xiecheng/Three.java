package me.menduo.xiecheng;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-08 20:02
 **/
public class Three {
    /**
     *  5 /order/pnrList/pnrPriceList  111
     *    /order/pnrList/pnrPriceList/price 1111
     *    /order/pnrList/pnrPriceList/price 1221
     *    /order/pnrList/pnrPriceList 121
     *    /order/pnrList/pnrPriceList 131
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.next());
            String[] params = new String[n];
            for (int i = 0; i < n  ; i++) {
                params[i] = scanner.next();
            }
            StringBuilder stringBuilder = new StringBuilder();
            Map<String,int[]> map = new HashMap<>();
            for (int i = 0; i < params.length ; i++) {
                if(params[i].charAt(params[i].length()-1) == '/') params[i] = params[i].substring(0,params[i].length()-1);
                if(!map.containsKey(params[i])){
                    String[] x = params[i].split("/");
                    map.put(params[i],create(x.length-1));

                }else {
                    int[] array = map.get(params[i]);
                    update(array.length,array);
                }

                stringBuilder.append(generate(map.get(params[i]))).append(" ");
            }

            System.out.println(stringBuilder.toString().trim());
        }
    }

    private static  int[] update(int length,int[] tmp){
        if(length>2)
            for (int i = 1; i < length-1 ; i++) {
                tmp[i]++;
            }
        return tmp;
    }
    private static  int[] create(int length){
        int[]  tmp = new int[length];
        Arrays.fill(tmp,1);
        return tmp;
    }
    private static String generate(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
        }
        return stringBuilder.toString();
    }

}
