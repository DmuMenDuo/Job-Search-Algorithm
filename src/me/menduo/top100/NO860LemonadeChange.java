package me.menduo.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * User: menduo email:demon9607@163.com
 * Date: 2018-07-03
 * Time: 14:30
 */
public class NO860LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        map.put(20, 0);
        for (int i : bills) {
            //收钱
            map.put(i, map.get(i) + 1);
            if (i == 5) continue;
            else if (i == 10) {
                if (map.get(5) == 0) return false;
                else map.put(5, map.get(5) - 1);
            } else {
                if (map.get(10) >= 1 && map.get(5) >= 1) {
                    map.put(10, map.get(10) - 1);
                    map.put(5, map.get(5) - 1);
                    continue;
                }

                if (map.get(10) == 0 && map.get(5) >= 3) {
                    map.put(5, map.get(5) - 3);
                    continue;
                }

                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        NO860LemonadeChange no860LemonadeChange = new NO860LemonadeChange();
        System.out.println(no860LemonadeChange.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
        System.out.println(no860LemonadeChange.lemonadeChange(new int[]{5, 5, 10}));
    }
}
