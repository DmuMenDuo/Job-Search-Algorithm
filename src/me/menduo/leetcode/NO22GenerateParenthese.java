package me.menduo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: menduo email:demon9607@163.com
 * Date: 2018-07-01
 * Time: 15:42
 */
public class NO22GenerateParenthese {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) return result;
        general(result, "", n, n);
        return result;
    }

    private void general(List<String> result, String tmp, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(tmp);
        } else {
            if (tmp.equals("") || left == right) {
                general(result, tmp + "(", left - 1, right);
            } else if (left < right && left > 0) {
                general(result, tmp + "(", left - 1, right);
                general(result, tmp + ")", left, right - 1);
            } else {
                general(result, tmp + ")", left, right - 1);
            }
        }
    }

    public static void main(String[] args) {
        NO22GenerateParenthese no22GenerateParenthese = new NO22GenerateParenthese();
        List<String> re = no22GenerateParenthese.generateParenthesis(3);
        System.out.println(Arrays.toString(re.toArray()));
    }
}
