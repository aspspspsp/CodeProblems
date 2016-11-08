package Easy;
/*
 * 
 * 从前向后遍历数组，记录当前出现过的最低价格，作为买入价格，并计算以当天价格出售的收益，作为可能的最大收益，整个遍历过程中，出现过的最大收益就是所求。
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1)
            return 0;
            
        //最大利潤
        int maxProfit = 0;
        
        //當前出現最低價格
        int cur_lowestPrice = prices[0];
        
        for(int i = 0; i < prices.length; i ++) {
            //取得當前最低價格
            cur_lowestPrice = Math.min(cur_lowestPrice, prices[i]);
            
            //最大利潤就是"之前的最大利潤"與"目前利潤(prices[i] - cur_lowestPrice)"取其高
            maxProfit = Math.max(maxProfit, prices[i] - cur_lowestPrice);
        }
        
        return maxProfit;
    }
}