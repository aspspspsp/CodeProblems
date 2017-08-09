package LeetCode.Hard;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) {
            return 0;
        }
        
        //將這個數組進行倒排
        Arrays.sort(envelopes, new Comparator<int []>() {
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
        
        //存儲每個信封的最大容納信封的數量
        /*
        ex:
        [5,4] [4,3] [4,2] [3, 1] [3, 1]
        =======================================
        3     2     2     1      1
        */
        int[] dp = new int[envelopes.length];
        //紀錄最大數量
        int max = 1;
        for(int i = 0; i < envelopes.length; i ++) {
            dp[i] = 1;
            //往下找尋比較小的信封，若符合條件，則計入數量當中
            for(int j = i - 1; j >= 0; j --) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //維護最大數量
            max = Math.max(dp[i], max);
        }
        
        
        return max;
    }
}