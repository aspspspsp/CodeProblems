package LeetCode.Medium;

import java.util.Arrays;
/*
 * 如果一个数x可以表示为一个任意数a加上一个平方数b * b，
 * 也就是x = a + b * b，那么能组成这个数x最少的平方数个数
 * ，就是能组成a最少的平方数个数加上1（因为b * b已经是平方
 * 数了）。
 */
public class PerfectSquares {
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
	
		// 將dp中的結果設置為最大(假設數量不存在)，保證之後比較的時候不被選中
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		// 將所有平方數的結果設置為1(自己就是平方數，數量至少為1)
		for(int i = 0; i * i <= n; i ++) {
			dp[i * i] = 1;
		}
		
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