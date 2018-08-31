package src.LeetCode.Hard;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
    
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] height = new int[n];//对每一列构造数组
    
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(matrix[i][j] == '0') { //如果遇见0，这一列的高度就为0了
                    height[j] = 0;
                } else {
                    height[j] += 1;
                }
            }
            
            max = Math.max(largestRectangleArea(height), max);
        }
        return max;
    }
    
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        
        h = Arrays.copyOf(height, height.length + 1);
        
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i);
                i ++;
            } else {
                int t = stack.pop();
                int square = -1;
                if(stack.isEmpty() == true) {
                    square = h[t] * i;
                } else {
                    int x = i - stack.peek() - 1;
                    square = h[t] * x;
                }
                
                maxArea = Math.max(maxArea, square);
            }
        }
        return maxArea;
    }
}
