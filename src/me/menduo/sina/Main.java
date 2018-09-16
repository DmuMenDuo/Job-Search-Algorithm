package me.menduo.sina;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @email: menduo96@gmail.com
 * @author: menduo
 * @create: 2018-09-16 21:40
 **/
public class Main {
    public static void main(String[] args) {
        while (true) {
            Map<Integer, Integer> map = new HashMap<>();
            int i = 1;

            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            if (x == y || x == z || y == z) {
                System.out.println("fail");
                continue;
            }
            if (x >= 3 || y >= 5 || z >= 7) {
                System.out.println("fail");
                continue;
            }
            while (true) {
                int tmpx = i * 3 + x;
                int tmpy = i * 5 + y;
                int tmpz = i * 7 + z;
                if (map.containsKey(tmpx)) {
                    map.put(tmpx, map.get(tmpx) + 1);
                } else {
                    map.put(tmpx, 1);
                }

                if (map.containsKey(tmpy)) {
                    map.put(tmpy, map.get(tmpy) + 1);
                } else {
                    map.put(tmpy, 1);
                }

                if (map.containsKey(tmpz)) {
                    map.put(tmpz, map.get(tmpz) + 1);
                } else {
                    map.put(tmpz, 1);
                }
                if (map.get(tmpx) == 3) {
                    System.out.println(i * 3 + x);
                    break;
                }
                if (map.get(tmpy) == 3) {
                    System.out.println(i * 5 + y);
                    break;
                }
                if (map.get(tmpz) == 3) {
                    System.out.println(i * 7 + z);
                    break;
                }
                i++;
            }
        }
    }
}
