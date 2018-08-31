package src.LeetCode.Algorithms.Medium;
public class SearchA2DMatrix {
	   public boolean searchMatrix(int[][] matrix, int target) {
	        //̎處理例外
	        if(matrix == null || matrix.length == 0) 
	            return false;
	        if(matrix[0] == null || matrix[0].length == 0) 
	            return false;
	        
	        int row = matrix.length;
	        int col = matrix[0].length;
	        
	        int start = 0;
	        int end = row * col - 1;
	        
	        //start + 1 是要通過特殊case
	        while(start + 1 < end) {
	            //核心程序
	            int mid = start + (end - start) / 2;
	            int num = matrix[mid / col][mid % col];
	            
	            if(num == target)
	                return true;
	            else if(num < target)
	                start = mid + 1;
	            else if(num > target)
	                end = mid - 1;
	        }
	        
	        //̎處理邊際情況
	        int num_1 = matrix[start / col][start % col];
	        int num_2 = matrix[end / col][end % col];
	        if(target == num_1 || target == num_2)
	            return true;
	        
	        return false;
	    }
}