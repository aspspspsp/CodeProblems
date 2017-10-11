package LeetCode.Easy;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
                
        int maxArea = 0;
        
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(grid[i][j] == 1)
                    maxArea = Math.max(maxArea, dfs(i, j, grid, m, n));
            }
        }
        
        return maxArea;
    }
    
    int[][] dirs = {{0, 1}, {1, 0}, {0 , -1}, {-1, 0}};
    int dfs(int i, int j, int[][]grid, int m, int n) {
        int area = 1;
        grid[i][j] = 0;
        
        for(int[] dir : dirs) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if(new_i < m && new_i >= 0 && new_j < n && new_j >= 0) {
                if(grid[new_i][new_j] == 1)
                    area += dfs(new_i, new_j, grid, m, n);
            }
        }
        
        //因為這個過程是單向的，不回頭，所以不回復上一個狀態(以避免重複計算數量)
        
        return area;
    }
}
