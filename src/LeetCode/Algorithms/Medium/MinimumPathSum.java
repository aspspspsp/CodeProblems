package src.LeetCode.Algorithms.Medium;
/*
這題是要找出從左上到右下的最小路徑成本，但只可以兩種方向前進(向右、向下):
Ex:
題目給出以下路徑數據，每一格代表路徑成本:
1 2 3
1 2 3
1 2 3

而我們希望產生一個從左上到當前的總路徑成本的二維數組:
1 3 6
2 4 7 
3 5 8
每一格都代表當前所花費的路徑總成本

而依照上面要求，我們可以構造下面的動態規劃公式來求解:
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