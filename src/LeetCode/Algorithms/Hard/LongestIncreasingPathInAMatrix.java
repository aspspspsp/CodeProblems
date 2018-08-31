package src.LeetCode.Algorithms.Hard;

public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int max = 1;
        int [][] memo = new int[n][m];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                max = Math.max(helper(i, j, matrix, memo), max);
            }
        }
        
        return max;
    }
    
    int helper(int i, int j, int[][] matrix, int[][] memo) {
        if(memo[i][j] > 0) //走過了(因為該格已經有答案，可以直接套用，也在走到起點這一格時，直接使用起點這一格的答案)
            return memo[i][j];
        
        //走訪方向
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        //依序對4個方向進行走訪
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
                continue;
            if(matrix[x][y] <= matrix[i][j])
                continue;
            
            memo[i][j] = Math.max(memo[i][j], helper(x, y, matrix, memo) + 1);
        }
        
        //每一格都至少為1
        memo[i][j] = Math.max(memo[i][j], 1);
        
        return memo[i][j];
    }
}