package src.LeetCode.Algorithms.Easy;

public class MinCostClimbingStairs {
    /*
    dp[i] = min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1])
    */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i < dp.length; i ++) {
            //                �qi-2����ثe������         �qi-1����ثe������
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        return dp[dp.length - 1];
    }
}
