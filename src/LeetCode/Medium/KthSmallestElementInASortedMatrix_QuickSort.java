package src.LeetCode.Medium;

import java.util.Arrays;

public class KthSmallestElementInASortedMatrix_QuickSort {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return -1;
        
        if(k < 1)
            return -1;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        if(m * n < k)
            return -1;
        
        int[] array = new int[m * n];
        
        int count = 0;
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                array[count] = matrix[i][j];
                count ++;
            }
        }
        
        Arrays.sort(array);
        
        return array[k - 1];
    }
}