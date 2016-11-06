package Medium;
/*
我们遍历矩阵的每一个点，对每个点都尝试进行一次深度优先搜索，如果搜索到1，就继续向它的四周搜索。
同时我们每找到一个1，就将其标为0，这样就能把整个岛屿变成0。我们只要记录对矩阵遍历时能进入多少次
搜索，就代表有多少个岛屿。
*/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int result = 0;
        
        //歷遍整個地圖
        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[0].length; j ++) {
                //若找到1時，則進行深度優先搜索，將整座島嶼變為0
                if(grid[i][j] == '1') {
                    searchIslands(grid, i, j);
                    result ++;
                }
            }
        }
        
        return result;
    }
    
    void searchIslands(char[][] grid, int x, int y) {
        //將拜訪過的點標記為0
        grid[x][y] = '0';
        
        //搜尋右邊(若為1則拜訪)是否為地面'1'
        if(x + 1 < grid.length && grid[x + 1][y] == '1') {
            searchIslands(grid, x + 1, y);
        }
        
        //搜尋左邊(若為1則拜訪)是否為地面'1'
        if(x - 1 >= 0 && grid[x - 1][y] == '1') {
            searchIslands(grid, x - 1, y);
        }
        
        //搜尋上面(若為1則拜訪)是否為地面'1'
        if(y - 1 >= 0 && grid[x][y - 1] == '1') {
            searchIslands(grid, x, y - 1);
        }
        
        //搜尋下面(若為1則拜訪)是否為地面'1'
        if(y + 1 < grid[0].length && grid[x][y + 1] == '1') {
            searchIslands(grid, x, y + 1);
        }
    }
}