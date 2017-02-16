package Medium;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
            
        int m = matrix.length;
        int n = matrix[0].length;
        
        //每一個格子儲存最大的正方形面積
        int[][] dp = new int[m][n];  
        
        // 處理第一列
        for(int i = 0; i < m; i ++) {
            if(matrix[i][0] == '1')
                dp[i][0] = 1;
            else
                dp[i][0] = 0;
        }
        
        // 處理第一行
        for(int j = 0; j < n; j ++) {
            if(matrix[0][j] == '1')
                dp[0][j] = 1;
            else
                dp[0][j] = 0;
        }
        
        //處理其餘每一行與列
        for(int i = 1; i < m; i ++) {
            for(int j = 1; j < n; j ++) {
                /*
                matrix:     dp:
                0 0 0 0     0 0 0 0
                1 1 1 1     1 1 1 1
                1 1 1 0     1 2 2 0
                1 1 1 0     1 2 3 0           
                */
                if(matrix[i][j] == '1') {
                    //檢查左上，上以及左邊的情況
                    int min = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    min = Math.min(min, dp[i][j - 1]);
                    dp[i][j] = min + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        //找最大
        int max = 0;
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(dp[i][j] > max)
                    max = dp[i][j];
            }
        }
        
        //輸出面積
        return max * max;
    }
}