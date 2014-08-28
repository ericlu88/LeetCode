package com.Eric.LeetCode.BestTimeToBuyAndSellStock;

public class Solution
{
    public int maxProfit(int[] prices)
    {
        if (prices == null || prices.length == 0)
            return 0;

        int lowest = prices[0];
        int highest = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] > lowest)
            {
                highest = Math.max(prices[i], highest);
            }
            else
            {
                maxProfit = Math.max(highest - lowest, maxProfit);
                lowest = prices[i];
                highest = prices[i];
            }
        }
        maxProfit = Math.max(highest - lowest, maxProfit);
        return maxProfit;
    }
}
