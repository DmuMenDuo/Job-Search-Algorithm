package me.menduo.jzoffer;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-08 12:08
 **/
public class LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1) return -1;
        int last = 0;
        for (int i = 2; i <=n ; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
