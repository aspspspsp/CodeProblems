package LeetCode.Medium;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
        ����һ��result��ꇱ�ʾÿһ���е�·����
        
        ���ȳ�ʼ��result���
        ex:           
        1 1 1
        1
        1
        
        ���� obstacleGrid��ꇵĵ�0�л��0�О�1�r��Ҫ���@һ�����µ�Ԫ�ض��Ğ�0
        ex: 
        obstacleGrid    result
        ------------    ------
        0 1 0           1 0 0
        1 0 0       =>  0 
        0 0 0           0
        
        Ȼ����Mʣ��result�Ĳ���
        ��obstacleGrid[i][j] = 1�tresult[i][j] = 0
        ��obstacleGrid[i][j] = 0�tresult[i][j] = result[i - 1][j] + result[i][j - 1]
        ��ʾ�ϵK�Л]���κ�·��
        ex:
        obstacleGrid    result
        ------------    ------
        0 0 0           1 1 1
        0 1 0       =>  1 0 1
        0 0 0           1 1 2
        
        ���᷵��result[n][m]
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