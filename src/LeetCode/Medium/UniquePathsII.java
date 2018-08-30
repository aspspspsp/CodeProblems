package src.LeetCode.Medium;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
    result儲存著動態規劃的結果(每一格都代表到達此點可使用的路徑數量)
        
       先初始化result表格的第0行與第0列
        ex:           
        1 1 1
        1
        1
    
	而obstacleGrid代表著障礙物，故result需要配合obstacleGrid做出調整，
	故要將初始化的第0行第0列根據obstacleGrid的內容改變，例如以下例子:
        ex: 
        obstacleGrid    result
        ------------    ------
        0 1 0           1 0 0 (有障礙物則路徑為0)
        1 0 0       =>  0 
        0 0 0           0
        
 	動態規劃(result)公式如下:
 	若obstacleGrid[i][j] = 1 則 result[i][j] = 0 (有障礙物則路徑為0)
 	若obstacleGrid[i][j] = 0 則 result[i][j] = result[i - 1][j] + result[i][j - 1]
	所以做完動態規劃的結果會如以下所示:
        ex:
        obstacleGrid    result
        ------------    ------
        0 0 0           1 1 1
        0 1 0       =>  1 0 1
        0 0 0           1 1 2
        
 	返回最後一格的結果result[n][m]
        */
        if(obstacleGrid == null)
            return 0;
        
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        
        if(m == 0 || n == 0)
            return 0;
            
        int [][] result = new int[n][m];
        
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        boolean is_non_a_way = false;
        for(int j = 0; j < m; j ++) {
            if(obstacleGrid[0][j] == 1 && is_non_a_way == false) {
                result[0][j] = 0;
                is_non_a_way = true;
            } else if(obstacleGrid[0][j] == 0 && is_non_a_way == false)
                result[0][j] = 1;
            else
                result[0][j] = 0;
        }
        
        is_non_a_way = false;
        for(int i = 0; i < n; i ++) {
            if(obstacleGrid[i][0] == 1 && is_non_a_way == false) {
                result[i][0] = 0;
                is_non_a_way = true;
            } else if(obstacleGrid[i][0] == 0 && is_non_a_way == false)
                result[i][0] = 1;
            else
                result[i][0] = 0;
        }
        
        for(int i = 1; i < n; i ++) {
            for(int j = 1; j < m; j ++) {
                if(obstacleGrid[i][j] == 1) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }
        
        return result[n - 1][m - 1];
    }
}