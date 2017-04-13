package LeetCode.Medium;
/*
 * 
 * ���à�Bģ�M��һ���ֵļ������L����������
 * 
 */
public class GameOfLife {
    //������B
    final int DEAD = 0; //��
    final int ALIVE = 1; //��
    
    final int DEAD_TO_DEAD = 2; //������ 
    final int DEAD_TO_ALIVE = 3; //������
    final int ALIVE_TO_DEAD = 4; //������
    final int ALIVE_TO_ALIVE = 5; //������
    
    public void gameOfLife(int[][] board) {
        board = nextRound(board);
        board = decodeBoardForNextRound(board);
    }
    
    //�����M������һ���A��
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
    
    //����P�M�н�a(�������������D����)
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
    
    //��P�еĸ����M����һ���A�εĽ���
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
    
    //�z����P�е�ĳ�����ӵ����ܣ��ف�Q��ԓ����Ҫ����ʲ�N��B
    int[][] checkSround(int[][] board, int curCell_d0, int curCell_d1) {
        int m = board.length;
        int n =  board[0].length;
        
        int live_num = 0;
        
        //�v�����܁K����ļ��������o�����
        for(int i = curCell_d0 - 1; i <= curCell_d0 + 1; i++) {
            for(int j = curCell_d1 - 1; j <= curCell_d1 + 1; j++) {
                if(i >= 0 && i < m) {
                    if(j >=0 && j < n) {
                        //�����Լ����Բ�Ӌ
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
        
        //�������ܻ�ļ�������������һ����B
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
    
    //�z����Ŀǰ��B�����Ƿ��ǻ��
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