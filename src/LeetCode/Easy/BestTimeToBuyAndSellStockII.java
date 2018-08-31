package src.LeetCode.Easy;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 0; i < prices.length - 1; i ++) {
            int difference = prices[i + 1] - prices[i];
            if(difference > 0) {
                profit += difference;
            }
        }
        return profit;
    }
}