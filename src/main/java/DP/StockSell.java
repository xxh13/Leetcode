package DP;

/**
 * num : 121
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * Created by XXH on 2016/8/20.
 */
public class StockSell {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;

        int maxProfit = prices[1] - prices[0];
        int minLeft = prices[0];

        for(int i=2; i<prices.length; i++){
            if(prices[i-1] < minLeft) minLeft = prices[i-1];
            if(maxProfit < prices[i] - minLeft) maxProfit = prices[i] - minLeft;
        }

        return maxProfit > 0 ? maxProfit : 0;
    }
}
