package me.menduo.jrtt;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-16 10:24
 **/
public class Two {
//    2 helloo wooooooow
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n  ; i++) {
                String str= sc.next();
                char[] chars= str.toCharArray();
                List<Character> list = new LinkedList<>();
                for (int j = 0; j <chars.length ; j++) {
                    list.add(chars[j]);
                }
                int head = 0;
                int tail = 1;
                while(tail<list.size()) {
                    if(list.get(tail) == list.get(head)){
                        if(tail+1<list.size() && list.get(tail+1)==list.get(tail)){
                            list.remove(tail+1);
                            continue;
                        }
                        if(tail+2<list.size() && list.get(tail+1)==list.get(tail+2)){
                            list.remove(tail+2);
                            continue;
                        }
                        head++;
                        tail++;
                    }else {
                        head++;
                        tail++;
                    }
                }
                for (int j = 0; j <list.size() ; j++) {
                    System.out.print(list.get(j));
                }
                System.out.println();
            }

        }
    }
}
