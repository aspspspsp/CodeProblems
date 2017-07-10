package LeetCode.Medium;
/*
����һ����С·�����
Ex:
·���ɱ����:
1 2 3
1 2 3
1 2 3

�ó�����С·�����:
1 3 6
2 4 7 
3 5 8
���������µ�Ԫ�ؼ���

�ӑBҎ��ʽ������:
res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
*/
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null)
            return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        
        int[][] res = new int[row][col];
        
        //������С·����ꇵ�����߅
        res[0][0] = grid[0][0];
        
        //������С·����ꇵ�����߅����
        for(int i = 1; i < row; i ++) {
            res[i][0] = res[i - 1][0] + grid[i][0];
        }
        
        //������С·����ꇵ����������
        for(int j = 1; j < col; j ++) {
            res[0][j] = res[0][j - 1] + grid[0][j];
        }
        
        //������С·����ꇵ����N����
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