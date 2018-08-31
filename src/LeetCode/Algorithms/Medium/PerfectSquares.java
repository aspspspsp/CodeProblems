package src.LeetCode.Algorithms.Medium;

import java.util.Arrays;
/*
 * This is a dp problem. The key is to find the relation
 *  which is dp[i] = min(dp[i], dp[i-square]+1).
 *   For example, dp[5] = dp[4] + 1 = 1 + 1 = 2.
 */
public class PerfectSquares {
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		
		// 將dp中的結果設置為最大(假設數量不存在)，保證之後比較的時候不被選中
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		// 從小到大找到任意數a
		for(int a = 0; a <= n; a ++) {
			// 從小到大找到任意平方數b * b
			for(int b = 0; a + b * b <= n; b ++) {
				// 因為a + b * b可能就是平方數，所以我們要取兩個中比較小的
				dp[a + b * b] = Math.min(dp[a] + 1, dp[a + b * b]);
			}
		}
		
		return dp[n];
	}
}