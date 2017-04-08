public class Solution {
    int row_bound_hi;
    int row_bound_lo;
    int col_bound_hi;
    int col_bound_lo;
    
    public int[][] generateMatrix(int n) {
        int matrix = new int[n][n];
        int col = 0;
        int col_bound_hi = n;
        int col_bound_lo = 0;
        
        
        while() {
            if(col < col_bound_hi && row == row_bound_low)
                col ++;
                if(col == col_bound_hi - 1) {
                    row_bound_low = row_bound_low + 1
                }
            else if(col == col_bound_hi && row < row_bound_hi) {
                row ++;
                if(row == row_bound_hi - 1) {
                    col_bound_hi = col_bound_hi - 1;
                }
            } else if(col > col_bound_lo && row == row_bound_hi) {
                col --;
                if(col == col_bound_lo) {
                    col_bound_low = col_bound_low + 1;
                }
            } else if(col > col_bound_lo && row == row_bound_hi) {
                col --;
                if(col == col_bound_lo) {
                    col_bound_low = col_bound_low + 1;
                }
            }
        }
    }
    
}