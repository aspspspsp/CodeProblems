package src.LeetCode.Algorithms.Easy;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix == null)
            return false;

        // ���M���C(first row)�Ҧ�����
        for(int j = 0; j < matrix[0].length; j ++) {
            if(helper(matrix, 0, j) == false)
                return false;
        }

        // ���M����(first column)�Ҧ�����
        for(int i = 1; i < matrix.length; i ++) {
            if(helper(matrix, i, 0) == false)
                return false;
        }

        return true;
    }

    boolean helper(int[][] matrix, int i, int j) {
        int cur = matrix[i][j];

        // �﨤���M
        while(i < matrix.length && j < matrix[0].length) {
            if(matrix[i][j] != cur)
                return false;
            i ++;
            j ++;
        }

        return true;
    }
}
