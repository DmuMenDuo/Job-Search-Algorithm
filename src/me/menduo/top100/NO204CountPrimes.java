package me.menduo.top100;

public class NO204CountPrimes {

    /**
     * 打表
     */
    public int countP(int n) {
        boolean[] notPrim = new boolean[n];
        int cont = 0;
        for (int i = 2; i < n; i++) {
            if (notPrim[i] == false) {
                cont++;
                for (int j = 2; i * j < n; j++) {
                    notPrim[i * j] = true;
                }
            }
        }
        return cont;
    }

    /**
     * TLE
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        int cont = 0;
        int j;
        for (int i = 2; i < n; i++) {
            int tmp = (int) Math.sqrt(i);
            for (j = 2; j <= tmp; j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j > tmp) cont++;
        }
        return cont;
    }

    public static void main(String[] args) {
        NO204CountPrimes no204CountPrimes = new NO204CountPrimes();
        System.out.println(no204CountPrimes.countP(10));
    }
}
