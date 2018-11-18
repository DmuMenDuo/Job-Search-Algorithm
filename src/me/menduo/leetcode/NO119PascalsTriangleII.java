package me.menduo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO119PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) res.add(1);
        for (int i = 2; i <= rowIndex; i++)
            for (int j = i - 1; j > 0; j--)
                res.set(j, res.get(j) + res.get(j - 1));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NO119PascalsTriangleII().getRow(3));
    }
}
