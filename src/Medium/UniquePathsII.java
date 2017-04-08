package Medium;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
        構造一個result矩陣表示每一個中的路徑數
        
        首先初始化result矩陣
        ex:           
        1 1 1
        1
        1
        
        而若 obstacleGrid矩陣的第0行或第0列為1時就要將這一個底下的元素都改為0
        ex: 
        obstacleGrid    result
        ------------    ------
        0 1 0           1 0 0
        1 0 0       =>  0 
        0 0 0           0
        
        然後填滿剩下result的部分
        若obstacleGrid[i][j] = 1則result[i][j] = 0
        若obstacleGrid[i][j] = 0則result[i][j] = result[i - 1][j] + result[i][j - 1]
        表示障礙中沒有任何路徑
        ex:
        obstacleGrid    result
        ------------    ------
        0 0 0           1 1 1
        0 1 0       =>  1 0 1
        0 0 0           1 1 2
        
        最後返回result[n][m]
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