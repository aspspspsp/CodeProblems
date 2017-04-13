package LeetCode.Easy;
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        
        int x_length = grid.length;
        int y_length = grid[0].length;
        
        for(int i = 0 ; i < x_length; i ++) {
            for(int j = 0; j < y_length; j ++) {
                if(grid[i][j] == 1) {
                    int stripes = 4;
                    if(i + 1 < x_length && grid[i + 1][j] == 1) 
                        stripes = stripes - 1;
                    if(i - 1 >= 0 && grid[i - 1][j] == 1)
                        stripes = stripes - 1;
                    if(j + 1 < y_length && grid[i][j + 1] == 1) 
                        stripes = stripes - 1;
                    if(j - 1 >= 0 && grid[i][j - 1] == 1) 
                        stripes = stripes - 1;
                        
                    ans = ans + stripes;
                }
            }
        }
        
        return ans;
    }
}