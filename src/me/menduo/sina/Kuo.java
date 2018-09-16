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
    /**
     * 括号匹配问题 找出最少需要添加几个括号让字符串中所有括号完全匹配
     * <p>
     * （） 0
     * ([]) 0
     * ((] 3
     * ([)] 2
     *
     * @param args
     */
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
