package Medium;

public class UniquePaths {
    /*
    用一個2*2的表格，紀錄路徑數:
    ex:
    1 1 1 1
    1 2 3 4
    1 3 6 10
    1 4 10 20
    
    動態規劃公式為
    result[i][j] = result[i - 1][j] + result[i][j - 1];
    */
    public int uniquePaths(int m, int n) {
        int [][] result = new int[n][m];
        
        for(int j = 0; j < m; j ++) {
            result[0][j] = 1;
        }
        
        for(int i = 0; i < n; i ++) {
            result[i][0] = 1;
        }
        
        for(int i = 1; i < n; i ++) {
            for(int j = 1; j < m; j ++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        
        return result[n - 1][m - 1];
    }
}