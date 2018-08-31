package src.LeetCode.Algorithms.Medium;

public class ValidSudoku {
    /**
      * @param board: 棋盤
        @return: 回傳是否存在重複的情況
      */
    public boolean isValidSudoku(char[][] board) {
    	//處理棋盤為空的情況
    	if(board == null || board.length != 9 || board[0].length != 9) {
    		return false;
    	}
  
    	//檢查行是否有符合數獨的性質
    	for(int i = 0; i < 9; i ++) {
    		boolean[] numUsed = new boolean[9];
    		for(int j = 0; j < 9; j ++) {
    			if(isDuplicate(board[i][j], numUsed)) {
    				return false;
    			}
    		}
    	}
    	
    	//檢查列是否有符合數獨的性質
    	for(int i = 0; i < 9; i ++) {
    		boolean[] numUsed = new boolean[9];
    		for(int j = 0; j < 9; j ++) {
    			if(isDuplicate(board[j][i], numUsed)) {
    				return false;
    			}
    		}
    	}
    	
    	// 檢查九宮格是否有重複的情況
    	for(int i = 0; i < 9; i = i + 3) { //類似於滑窗，一次向左或向下移動3格
    		for(int j = 0; j < 9; j = j + 3) {
    			if(isValidSubBox(board, i, j) == false) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
    /**
     * 檢查該九宮格的重複情況
     * @param board 棋盤
     * @param start_x 從哪個x開始檢查
     * @param start_y 從哪個y開始檢查
     * @return 回傳是否存在重複的情況
     */
	boolean isValidSubBox(char[][] board, int start_x, int start_y) {
		//紀錄九宮格內的數字使用情況
		boolean[] numUsed = new boolean[9];
		
		for(int i = start_x; i < start_x + 3; i ++) {
			for(int j = start_y; j < start_y + 3; j ++) {
				if(isDuplicate(board[i][j], numUsed) == true) {
					return false;
				}
			}
		}
		
		return true;
	}
    
    /**
     * 檢查是否有數字重複
     * @param c 該格的字符
     * @param numUsed 紀錄行或列的數字的使用情況
     * 	 flase未使用，true已使用
     * @return 回傳是否存在重複的情況
     */
    boolean isDuplicate(char numChar, boolean[] numUsed) {
    	//該格子若沒有填入數字，則不存在重複的情況
    	if(numChar == '.') {
    		return false;
    	}
    	// 數字有重複的情況下，則返回true
    	else if(numUsed[numChar - '1'] == true) {
    		return true;
    	}
    	// 若該格有數字卻沒有重複，標記它已經存在
    	else {
    		numUsed[numChar - '1'] = true;
    		return false;
    	}
    }
}