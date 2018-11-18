package me.menduo.leetcode;

public class NO121BestTimeToBuyAndSellStock {
    /**
     * 时刻记录最小的地方买入
     * 然后计算最大利润
     *
     * @param prices
     * @return
     */

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int buyPos = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPos) {
                buyPos = prices[i];
            }
            //if 比最小位置小 prices[i] - 原buyPos 一定 < 0;
            profit = Math.max(profit, prices[i] - buyPos);

        }
        return profit;
    }

    public static void main(String[] args) {
        NO121BestTimeToBuyAndSellStock no121BestTimeToBuyAndSellStock = new NO121BestTimeToBuyAndSellStock();
        System.out.println(no121BestTimeToBuyAndSellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(no121BestTimeToBuyAndSellStock.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
