package dev.manolovn.buyandsellstock;

/**
 * source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * difficulty: EASY
 * topic: ARRAYS
 */
public class BuyAndSellStock {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            if (price < buy) {
                buy = price;
            } else if (profit < price - buy) {
                profit = price - buy;
            }
        }

        return Math.max(profit, 0);
    }
}
