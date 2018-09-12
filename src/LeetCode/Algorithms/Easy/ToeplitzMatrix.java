package src.LeetCode.Algorithms.Easy;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix == null)
            return false;

        // 歷遍首列(first row)所有元素
        for(int j = 0; j < matrix[0].length; j ++) {
            if(helper(matrix, 0, j) == false)
                return false;
        }

        // 歷遍首行(first column)所有元素
        for(int i = 1; i < matrix.length; i ++) {
            if(helper(matrix, i, 0) == false)
                return false;
        }

        return true;
    }

    boolean helper(int[][] matrix, int i, int j) {
        int cur = matrix[i][j];

        // 對角歷遍
        while(i < matrix.length && j < matrix[0].length) {
            if(matrix[i][j] != cur)
                return false;
            i ++;
            j ++;
        }

        return true;
    }
}
