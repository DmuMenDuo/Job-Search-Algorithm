package me.menduo.top100;

public class NO672BulbSwitcherII {
    public int flipLights(int n, int m) {
        if (m == 0) return 1;
        if (n <= 0 || m < 0) return 0;
        if (n == 1) return 2;
        else if (n == 2) return m == 1 ? 3 : 4;
        else return m == 1 ? 4 : (m == 2 ? 7 : 8);
    }

    public static void main(String[] args) {
        /**
         * n == 1
         * Only 2 possibilities: 1 and 0.
         * n == 2
         * After one operation, it has only 3 possibilities: 00, 10 and 01.
         * After two and more operations, it has only 4 possibilities: 11, 10, 01 and 00。
         * n == 3
         * After one operation, it has only 4 possibilities: 000, 101, 010 and 011.
         * After two operations, it has 7 possibilities: 111,101,010,100,000,001 and 110。
         * After three and more operations, it has 8 possibilities, plus 011 on above case.
         * n >= 4
         * After one operation, it has only 4 possibilities: 0000, 1010, 0101 and 0110.
         * After two or more operations: it has 8 possibilities, 1111,1010,0101,0111,0000,0011, 1100 and 1001.
         */
    }
}
