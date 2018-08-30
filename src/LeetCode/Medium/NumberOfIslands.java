package src.LeetCode.Medium;
/*
這題可以用簡單的DFS來解
1.歷遍整個grid
2.遇到1則開始dfs
3.島嶼數量+1
4.dfs的過程將走過的地方標記為0(已經走過)，避免重複計算
*/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int result = 0;
        
        //歷遍整個grid
        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[0].length; j ++) {
                //若遇到陸地(1)則開始對這塊島嶼進行DFS，將拜訪過的點標記為0
                if(grid[i][j] == '1') {
                    searchIslands(grid, i, j);
                    result ++;
                }
            }
        }
        
        return result;
    }

    // 開始島嶼的dfs
    void searchIslands(char[][] grid, int x, int y) {
        //標記這裡已經走過了
        grid[x][y] = '0';
        
        //搜尋下面(若為1則拜訪)
        if(x + 1 < grid.length && grid[x + 1][y] == '1') {
            searchIslands(grid, x + 1, y);
        }
        
        //搜尋上面(若為1則拜訪)
        if(x - 1 >= 0 && grid[x - 1][y] == '1') {
            searchIslands(grid, x - 1, y);
        }

        //搜尋左邊(若為1則拜訪)
        if(y - 1 >= 0 && grid[x][y - 1] == '1') {
            searchIslands(grid, x, y - 1);
        }

        //搜尋右邊(若為1則拜訪)
        if(y + 1 < grid[0].length && grid[x][y + 1] == '1') {
            searchIslands(grid, x, y + 1);
        }
    }
}