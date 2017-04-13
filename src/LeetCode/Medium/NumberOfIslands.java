package LeetCode.Medium;
/*
���Ǳ��������ÿһ���㣬��ÿ���㶼���Խ���һ������������������������1���ͼ�������������������
ͬʱ����ÿ�ҵ�һ��1���ͽ����Ϊ0���������ܰ�����������0������ֻҪ��¼�Ծ������ʱ�ܽ�����ٴ�
�������ʹ����ж��ٸ����졣
*/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int result = 0;
        
        //�v�������؈D
        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[0].length; j ++) {
                //���ҵ�1�r���t�M����ȃ����������������u�Z׃��0
                if(grid[i][j] == '1') {
                    searchIslands(grid, i, j);
                    result ++;
                }
            }
        }
        
        return result;
    }
    
    void searchIslands(char[][] grid, int x, int y) {
        //�����L�^���c��ӛ��0
        grid[x][y] = '0';
        
        //�ь���߅(����1�t���L)�Ƿ�����'1'
        if(x + 1 < grid.length && grid[x + 1][y] == '1') {
            searchIslands(grid, x + 1, y);
        }
        
        //�ь���߅(����1�t���L)�Ƿ�����'1'
        if(x - 1 >= 0 && grid[x - 1][y] == '1') {
            searchIslands(grid, x - 1, y);
        }
        
        //�ь�����(����1�t���L)�Ƿ�����'1'
        if(y - 1 >= 0 && grid[x][y - 1] == '1') {
            searchIslands(grid, x, y - 1);
        }
        
        //�ь�����(����1�t���L)�Ƿ�����'1'
        if(y + 1 < grid[0].length && grid[x][y + 1] == '1') {
            searchIslands(grid, x, y + 1);
        }
    }
}