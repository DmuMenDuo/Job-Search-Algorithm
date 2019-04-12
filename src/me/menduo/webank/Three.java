package me.menduo.webank;

import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-11 19:52
 **/
public class Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] array = new int[T];
        for (int i = 0; i < T ; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < array.length ; i++) {
            int tmp = array[i];
            int count = 0;
            while (tmp != 1){
                if(tmp % 2 != 0){
                    tmp = tmp * 3 + 1;
                }else {
                    tmp /=2;
                }
                count++;
            }
            System.out.println(count);

        }

    }

}
