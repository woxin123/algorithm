package com.example.base.dynamicprogramming;

/**
 * @author mengchen
 * @time 18-10-12 下午7:06
 */
public class 买卖股票的最佳时机 {

    public static void main(String[] args) {
        买卖股票的最佳时机 a = new 买卖股票的最佳时机();
        int result = a.maxProfit(new int[]{5, 1, 2, 3});
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int result = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            result = Math.max(result, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return result;
    }

}
