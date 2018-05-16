package me.menduo.top100;

import java.util.ArrayList;
import java.util.List;

public class NO118PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) tmp.add(1);
                else tmp.add(res.get(i - 2).get(j - 1) + res.get(i - 2).get(j - 2));
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        NO118PascalsTriangle no118PascalsTriangle = new NO118PascalsTriangle();
        no118PascalsTriangle.generate(5);
    }
}
