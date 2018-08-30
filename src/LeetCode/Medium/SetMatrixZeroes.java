package src.LeetCode.Medium;

import java.util.Arrays;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		//紀錄該行是否需要為0
		boolean[] row = new boolean[m];
		//紀錄該列是否需要為0
		boolean[] col = new boolean[n];
		
		//標記需要填入0的行與列
		for(int i = 0; i < m; i ++) {
			for(int j = 0; j < n; j ++) {
				if(matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		//正式將矩陣填入0
		for(int i = 0; i < m; i ++) {
			//把該行填為0
			if(row[i] == true) {
				for(int j = 0; j < n; j ++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for(int j = 0; j < n; j ++) {
			//把該列填為0
			if(col[j] == true) {
				for(int i = 0; i < m; i ++) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
