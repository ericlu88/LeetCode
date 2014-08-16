package com.Eric.LeetCode.BestTimeToBuyAndSellStockII;

public class Solution
{
    public int maxProfit(int[] prices)
    {
        boolean bought = false;
        int profit = 0;
        if (prices == null || prices.length == 0)
            return 0;

        int currentPrice;
        int lastPrice = prices[0];
        int boughtPrice = 0;
        for (int i = 1; i < prices.length; i++ )
        {
            currentPrice = prices[i];
            if (!bought)
            {
                if (currentPrice > lastPrice)
                {
                    boughtPrice = lastPrice;
                    bought = true;
                }
            }
            else
            {
                if (currentPrice < lastPrice)
                {
                    bought = false;
                    profit += lastPrice - boughtPrice;
                }
            }
            lastPrice = currentPrice;
        }

        if (bought)
            profit += lastPrice - boughtPrice;

        return profit;
    }
}
