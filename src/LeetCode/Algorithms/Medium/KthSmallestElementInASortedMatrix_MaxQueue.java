package src.LeetCode.Algorithms.Medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInASortedMatrix_MaxQueue {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> queue = new PriorityQueue<Integer>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                queue.add(matrix[i][j]);
            }
        }
        
        int result = -1;
        while(k > 0) {
            result = queue.poll();
            k --;
        }
        
        return result;
    }
}
