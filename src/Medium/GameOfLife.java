package Medium;
/*
 * 
 * 利用狀態模擬下一部分的細菌生長、存活或死亡
 * 
 */
public class GameOfLife {
    //六個狀態
    final int DEAD = 0; //死
    final int ALIVE = 1; //活
    
    final int DEAD_TO_DEAD = 2; //死至死 
    final int DEAD_TO_ALIVE = 3; //死至活
    final int ALIVE_TO_DEAD = 4; //活至死
    final int ALIVE_TO_ALIVE = 5; //活至活
    
    public void gameOfLife(int[][] board) {
        board = nextRound(board);
        board = decodeBoardForNextRound(board);
    }
    
    //細菌進入至下一個階段
    int[][] nextRound(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                board = checkSround(board, i, j);
            }
        }
        return board;
    }
    
    //將棋盤進行解碼(將例如死至死轉成死)
    int[][] decodeBoardForNextRound(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                board[i][j] = decodeForNextState(board[i][j]);
            }
        }
        return board;
    }
    
    //棋盤中的格子進行下一個階段的解析
    int decodeForNextState(int state) {
        if(state == DEAD_TO_DEAD)
            return DEAD;
        else if(state == DEAD_TO_ALIVE) 
            return ALIVE;
        else if(state == ALIVE_TO_DEAD)
            return DEAD;
        else if(state == ALIVE_TO_ALIVE)
        	return ALIVE;
        else if(state == DEAD_TO_ALIVE)
        	return ALIVE;
        return DEAD;
    }
    
    //檢查棋盤中的某個格子的四周，再來決定該格子要填入什麼狀態
    int[][] checkSround(int[][] board, int curCell_d0, int curCell_d1) {
        int m = board.length;
        int n =  board[0].length;
        
        int live_num = 0;
        
        //歷遍四周並將活的細菌數量紀錄起來
        for(int i = curCell_d0 - 1; i <= curCell_d0 + 1; i++) {
            for(int j = curCell_d1 - 1; j <= curCell_d1 + 1; j++) {
                if(i >= 0 && i < m) {
                    if(j >=0 && j < n) {
                        //遇到自己忽略不計
                        if(i == curCell_d0 && j == curCell_d1) {
                            continue;
                        }
                        if(checkCurCellLife(board[i][j]) == true) {
                             live_num = live_num + 1;
                        }
                    }
                }
            }
        }
        
        //根據四周活的細菌數量填入下一步狀態
        if(checkCurCellLife(board[curCell_d0][curCell_d1]) == true) {
            if(live_num < 2) {
                board[curCell_d0][curCell_d1] = ALIVE_TO_DEAD;
            } else if(live_num >= 2 && live_num <= 3) {
                board[curCell_d0][curCell_d1] = ALIVE_TO_ALIVE;
            } else if(live_num > 3) {
                board[curCell_d0][curCell_d1] = ALIVE_TO_DEAD;
            }
        } else {
            if(live_num < 3) {
                board[curCell_d0][curCell_d1] = DEAD_TO_DEAD;
            } else if(live_num == 3) {
                board[curCell_d0][curCell_d1] = DEAD_TO_ALIVE;
            } else if(live_num > 3) {
                board[curCell_d0][curCell_d1] = DEAD_TO_DEAD;
            }
        }
        return board;
    }
    
    //檢查在目前狀態細菌是否是活的
    boolean checkCurCellLife(int curCell) {
        if(curCell == ALIVE)
            return true;
        else if(curCell == ALIVE_TO_DEAD)
            return true;
        else if(curCell == ALIVE_TO_ALIVE)
            return true;
        else if(curCell == DEAD_TO_DEAD)
        	return false;
        else if(curCell == DEAD_TO_ALIVE)
            return false;
        else if(curCell == DEAD)
        	return false;
        return false;
    }
    
}