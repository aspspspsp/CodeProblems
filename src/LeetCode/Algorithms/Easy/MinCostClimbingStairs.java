package src.LeetCode.Algorithms.Easy;

public class MinCostClimbingStairs {
    /*
    如果我?用一???dp[]?存放到?每一?所需要的花?值。??最??果是求dp[cost.length]的值。因?每次可以走1?或者2?，并且可以?0或者?1?始，所以可以得到dp[0]?0，dp[1]?0。?2?始，dp[i]可以由通?dp[i-2]走2?或者通?dp[i-1]走一?到?，而?i-2和i-1?所要花?的值分??cost[i-2]和cost[i-1]，所以，dp[i] = min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1])。?算法的空?复?度?O(n)，??复?度?O(n)。
    dp[i] = min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1])
    */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i < dp.length; i ++) {
            //                從i-2爬到目前的高度         從i-1爬到目前的高度
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        return dp[dp.length - 1];
    }
}
