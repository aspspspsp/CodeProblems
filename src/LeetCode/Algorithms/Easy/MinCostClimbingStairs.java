package src.LeetCode.Algorithms.Easy;

public class MinCostClimbingStairs {
    /*
    �p�G��?�Τ@???dp[]?�s���?�C�@?�һݭn����?�ȡC??��??�G�O�Ddp[cost.length]���ȡC�]?�C���i�H��1?�Ϊ�2?�A�}�B�i�H?0�Ϊ�?1?�l�A�ҥH�i�H�o��dp[0]?0�Adp[1]?0�C?2?�l�Adp[i]�i�H�ѳq?dp[i-2]��2?�Ϊ̳q?dp[i-1]���@?��?�A��?i-2�Mi-1?�ҭn��?���Ȥ�??cost[i-2]�Mcost[i-1]�A�ҥH�Adp[i] = min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1])�C?��k����?�`?��?O(n)�A??�`?��?O(n)�C
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
