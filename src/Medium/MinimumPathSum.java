package Medium;
/*
構造一個最小路徑矩陣
Ex:
路徑成本矩陣:
1 2 3
1 2 3
1 2 3

得出的最小路徑矩陣:
1 3 6
2 4 7 
3 5 8
返回最右下的元素即可

動態規劃式子如下:
res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
*/
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null)
            return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        
        int[][] res = new int[row][col];
        
        //構造最小路徑矩陣的左上邊
        res[0][0] = grid[0][0];
        
        //構造最小路徑矩陣的最左邊的列
        for(int i = 1; i < row; i ++) {
            res[i][0] = res[i - 1][0] + grid[i][0];
        }
        
        //構造最小路徑矩陣的最上面的行
        for(int j = 1; j < col; j ++) {
            res[0][j] = res[0][j - 1] + grid[0][j];
        }
        
        //構造最小路徑矩陣的其餘部分
        for(int i = 1; i < row; i ++) {
            for(int j = 1; j < col; j ++) {
                int perv_top = res[i - 1][j];
                int perv_left = res[i][j - 1];
                res[i][j] = Math.min(perv_top, perv_left) + grid[i][j];
            }
        }
        
        return res[row - 1][col - 1];
    }
}