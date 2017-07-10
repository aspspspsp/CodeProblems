package LeetCode.Hard;

import java.util.ArrayList;
import java.util.List;
/*
 * n個皇后擺放在n*n的棋盤上
 */
public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		int[] loc = new int[n]; // 記錄皇后處於哪一列，列數組
		
		dfs(result, loc, 0, n);
		return result;
	}
    
	/**
	 * dfs的循环是指这一行里，从第一列到最后一列放置的所有可能，
	 * 如果放置的地点通过isValid验证，通过cur+1进入下一行进行递
	 * 归， 如果没通过验证，试下一个位置，如果所有位置都不Valid，
	 * 跳回上一层
	 * @param result 存儲結果
	 * @param loc 最后loc［］里面记录的是解的信息（如果有解）
	 *        我们把它转换成String, 输出Board即可
	 * @param cur 目前擺到第幾個皇后
	 * @param n 共要擺幾個皇后
	 */
	void dfs(List<List<String>> result, int[] loc, int cur, int n) {
		if(cur == n) {
			//皇后已經擺到足夠數量了，就打印棋盤
			printBoard(result, loc, n);
		} else {
			//再依照列的次序擺放皇后
			for(int i = 0; i < n; i ++) {
				loc[cur] = i;
				if(isValid(loc, cur)) {
					dfs(result, loc, cur + 1, n); 
					/* 再放皇后m+1, 如果皇后m+1放完并返回了    
                                                 两种可能：  
                               1.冲突，返回了
                               2.一直将所有的皇后全部放完并安全返回了    
                                                 将皇后m回溯，探索新的可能或者安全的位置  
					 */
				}
				
			}
		}
	}
	
	//打印其中一種棋盤結果
	void printBoard(List<List<String>> result, int[] loc, int n) {
		List<String> answer = new ArrayList<>();
		for(int i = 0; i < n; i ++) { //n*n
			String row = new String(); //行的結果
			for(int j = 0; j < n; j ++) {
				if(j == loc[i]) {
					row += "Q";
				} else {
					row += ".";
				}
			}
			answer.add(row);
		}
		
		result.add(answer);
	}
	
	boolean isValid(int[] loc, int cur) {
		//保證新添加的皇后與那些已就位的皇后不衝突，共需要做cur次比較
		for(int i = 0; i < cur; i ++) {
			//驗證不在同一直線上
			if(loc[i] == loc[cur]) {
				return false;
			}
			//验证不在同一对角线上，根据对角线性质，长 ＝ 宽
			//i為目前的長，cur為目前的寬
			if(Math.abs(loc[i] - loc[cur]) == (cur - i)) {
				return false;
			}
		}
		
		//若都不在同一直線或對角線上，此次擺放為合法
		return true;
	}
}