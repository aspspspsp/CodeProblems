class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int [0];
        
        boolean up = true;
        
        // 取得行與列
        int m = matrix.length;
        int n = matrix[0].length;
        
        // 行與列的指標
        int i = 0;
        int j = 0;
        
        // 存儲答案
        int[] result = new int[m * n];
        
        for(int k = 0; k < m * n; k ++) {
            result[k] = matrix[i][j];
            // 往右上走
            if(up == true) {
                // 往右下走(正常情況)
                if((i - 1) >= 0 && (j + 1) < n) {
                    i --;
                    j ++;
                    
                // 到了第一行，不能再往上了
                } else if((j + 1) < n) {
                    j ++;
                    up = false;
                    
                // 到了最右边列，不能再往右了；
                } else if((i + 1) < m) {
                    i ++;
                    up = false;
                    
                // 到了最右下角的元素，这时候要全部结束遍历。
                } else {
                    break;
                }
                
            // 往左下走
            } else {
                // 往左下走(正常情況)
                if((i + 1) < m && (j - 1) >= 0) {
                    i ++;
                    j --;
                    
                // 到了第一列，不能在往左了
                } else if((i + 1) < m) {
                    i ++;
                    up = true;
                    
                // 到了最下边的行，不能再往下了；
                } else if((j + 1) < n) {
                    j ++;
                    up = true;
                
                //到了最右下角的元素，这时候要全部结束遍历。
                } else {
                    break;
                }
            }
        }
        
        return result;
    }
}
