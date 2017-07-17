package LeetCode.Medium;

public class UniquePaths {
    /*
  動態規劃的儲存格式如下:(每一格都代表到達此點可使用的路徑數量)
    ex:
    1 1 1 1
    1 2 3 4
    1 3 6 10
    1 4 10 20
    
 動態規劃公式如下:
 	此格的路徑數量 = 上面那格的路徑數量 + 左邊那格的路徑數量
    result[i][j] = result[i - 1][j] + result[i][j - 1];
    */
    public int uniquePaths(int m, int n) {
        int [][] result = new int[n][m];
        
        //初始化第0行
        for(int j = 0; j < m; j ++) {
            result[0][j] = 1;
        }
        
        //初始化第0列
        for(int i = 0; i < n; i ++) {
            result[i][0] = 1;
        }
        
        //完成剩下的
        for(int i = 1; i < n; i ++) {
            for(int j = 1; j < m; j ++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        
        return result[n - 1][m - 1];
    }
}