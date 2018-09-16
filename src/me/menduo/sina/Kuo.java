package me.menduo.sina;

import java.util.Scanner;
import java.util.Stack;

/**
 * @program: LeetCode
 * @email: menduo96@gmail.com
 * @author: menduo
 * @create: 2018-09-16 22:05
 **/
public class Kuo {
    public static void main(String[] args) {
        Stack<Character> x = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int cont = sc.nextInt();
        while (cont > 0) {
            int result = 0;
            String str = sc.next();
            char[] characters = str.toCharArray();
            for (int t = 0; t < characters.length; t++) {
                if (x.isEmpty() || characters[t] == '(' || characters[t] == '[') {
                    x.push(characters[t]);
                    continue;
                } else if (characters[t] == ']' && x.peek() == '[') {
                    x.pop();
                } else if (characters[t] == ')' && x.peek() == '(') {
                    x.pop();
                } else {
                    result++;
                }

            }

            while (!x.isEmpty()) {
                result++;
                x.pop();
            }

            System.out.println(result);
            cont--;
        }

    }
}
