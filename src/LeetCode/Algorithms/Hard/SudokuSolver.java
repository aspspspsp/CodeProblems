package src.LeetCode.Algorithms.Hard;

public class SudokuSolver {
/*
第一反应就是N皇后问题。就是一点点尝试着填数，不行的话就回溯，直到都填满就返回。 
如果对一个格子尝试从0~9都不行，那么说明整个sudoku无解，返回false就好。
对整个棋盘所有'.'都填完了，那么就可以返回true了。
*/
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        helper(board);
    }
    
    boolean helper(char[][] board) {
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                
                //開始找起始點，從'.'開始向下深搜
                if(board[i][j] == '.') {
                    //嘗試1~9的數字填入
                    for(char num = '1'; num <= '9'; num ++) {
                        //檢查是否合法，若合法則繼續深搜
                        if(isValid(board, i, j, num)) {
                            board[i][j] = num;
                            
                            //繼續遞歸深搜
                            if(helper(board) == true) {
                                return true;
                            } else {
                                board[i][j] = '.'; //若下一步不合法則回到上一步
                            }
                        }
                    }
                    return false; //若無法填入1~9的數字表示此數獨不合法
                }
            }
        }
        return true;
    }
    
    boolean isValid(char[][] board, int i, int j, char c) {
        //檢查行
        for(int col = 0; col < 9; col ++) {
            //若行裡面有與要填入的數字一樣的時候則不合法(有重複)
            if(board[i][col] == c) {
                return false;
            }
        }
    
        //檢查列
        for(int row = 0; row < 9; row ++) {
            //若列裡面有與要填入的數字一樣的時候則不合法(有重複)
            if(board[row][j] == c) {
                return false;
            }
        }
        
        //檢查填入數字附近的3*3的方塊是否有重複
        for(int row = i / 3 * 3; row < i / 3 * 3 + 3; row ++) {
            for(int col = j / 3 * 3; col < j / 3 * 3 + 3; col ++) {
                if(board[row][col] == c) {
                    return false;
                }
            }
        }
        
        //通過檢查
        return true;
    }
}
