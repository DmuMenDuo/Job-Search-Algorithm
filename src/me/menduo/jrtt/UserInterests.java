package me.menduo.jrtt;

import java.util.*;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-18 15:34
 **/
public class UserInterests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int user = scanner.nextInt();
        int[] value = new int[user];
        Map<Integer, List<Integer>> map  = new HashMap<>();
        for (int i = 0; i < user ; i++) {
            value[i] = scanner.nextInt();
            if(map.containsKey(value[i])){
                map.get(value[i]).add(i+1);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i+1);
                map.put(value[i],list);
            }
        }
        int query = scanner.nextInt();
        while (query>0){
            int result = 0;
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int habbit = scanner.nextInt();
            if(map.containsKey(habbit)){
                List<Integer> tmp = map.get(habbit);
                for (int x: tmp) {
                    if(x>=start&&x<=end) result++;
                }
            }
            System.out.println(result);
            query--;
        }
    }
}
