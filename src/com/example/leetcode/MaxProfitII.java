package com.example.leetcode;

/**
 * @author mengchen
 * @time 19-2-14 上午11:31
 */
public class MaxProfitII {
    /**
     * 暴力法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        return cacluate(prices, 0);
    }

    public int cacluate(int[] prices, int index) {
        if (index >= prices.length) {
            return 0;
        }
        int max = 0;
        for (int start = index; start < prices.length; start++) {
            int maxProfit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = cacluate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }
            if (maxProfit > max) {
                max = maxProfit;
            }
        }
        return max;
    }

    /**
     * 差值法
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int max = 0;
        int valley;
        int peek;
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peek = prices[i];

            max += peek - valley;
        }
        return max;
    }

    /**
     * 贪心
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }
}

