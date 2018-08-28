package LeetCode.Medium;
public class SearchA2DMatrixII {
/*
题解 - 自右上而左下
假設如果从左上角开始搜索，由于元素升序为自左向右和自上而下，因此如果target大于当前搜索元素时还有两个方向需要搜索，不太合适。
如果从右上角开始搜索，由于左边的元素一定不大于当前元素，而下面的元素一定不小于当前元素，因此每次比较时均可排除一列或者一行元素（大于当前元素则排除当前行，小于当前元素则排除当前列，由矩阵特点可知），可达到题目要求的复杂度。*/
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        
        if(matrix == null || matrix[0].length == 0)
            return false;
        
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        //列指標在右上，行指標在左下，逐漸夾逼
        int index_row = 0, index_col = col;
        
        //若目標數不在範圍內則返回flase
        if(target < matrix[0][0] || target > matrix[row][col])
            return false;
        
        //開始搜索
        while(index_row < row + 1 && index_col + 1 > 0) {
            int cur_num = matrix[index_row][index_col];
            //搜索到目標
            if(target == cur_num) 
                return true;
            //若目標數小於目前搜索到的數則行指標向左一步
            else if(target < cur_num)
                index_col --;
            //若目標數大於目前搜索到的數則列指標向上一步
            else if(target > cur_num)
                index_row ++;
        }
        
        //若都找不到目標數，則返回false
        return false;
    }
}