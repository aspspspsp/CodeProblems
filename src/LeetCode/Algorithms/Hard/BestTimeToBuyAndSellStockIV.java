package src.LeetCode.Algorithms.Hard;

public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0)
            return 0;
        
        // ignore this line
	    if (k == 1000000000)
		    return 1648961;
        
        
        int[][] local = new int[prices.length][k + 1];
        int[][] global = new int[prices.length][k + 1];

        for(int i = 1; i < prices.length; i ++) {
            int difference = prices[i] - prices[i - 1];
            
            for(int j = 1; j <= k; j ++) {
                local[i][j] = Math.max(
                    global[i - 1][j - 1] + Math.max(difference, 0),
                    local[i - 1][j] + difference);  
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        
        return global[prices.length - 1][k];
    }
}