package LeetCode.Hard;

public class SudokuSolver {
/*
��һ��Ӧ����N�ʺ����⡣����һ��㳢�������������еĻ��ͻ��ݣ�ֱ���������ͷ��ء� 
�����һ�����ӳ��Դ�0~9�����У���ô˵������sudoku�޽⣬����false�ͺá�
��������������'.'�������ˣ���ô�Ϳ��Է���true�ˡ�
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
                
                //�_ʼ����ʼ�c����'.'�_ʼ��������
                if(board[i][j] == '.') {
                    //�Lԇ1~9�Ĕ�������
                    for(char num = '1'; num <= '9'; num ++) {
                        //�z���Ƿ�Ϸ������Ϸ��t�^�m����
                        if(isValid(board, i, j, num)) {
                            board[i][j] = num;
                            
                            //�^�m�f�w����
                            if(helper(board) == true) {
                                return true;
                            } else {
                                board[i][j] = '.'; //����һ�����Ϸ��t�ص���һ��
                            }
                        }
                    }
                    return false; //���o������1~9�Ĕ��ֱ�ʾ�˔������Ϸ�
                }
            }
        }
        return true;
    }
    
    boolean isValid(char[][] board, int i, int j, char c) {
        //�z����
        for(int col = 0; col < 9; col ++) {
            //�����e�����cҪ����Ĕ���һ�ӵĕr��t���Ϸ�(�����})
            if(board[i][col] == c) {
                return false;
            }
        }
    
        //�z����
        for(int row = 0; row < 9; row ++) {
            //�����e�����cҪ����Ĕ���һ�ӵĕr��t���Ϸ�(�����})
            if(board[row][j] == c) {
                return false;
            }
        }
        
        //�z�����딵�ָ�����3*3�ķ��K�Ƿ������}
        for(int row = i / 3 * 3; row < i / 3 * 3 + 3; row ++) {
            for(int col = j / 3 * 3; col < j / 3 * 3 + 3; col ++) {
                if(board[row][col] == c) {
                    return false;
                }
            }
        }
        
        //ͨ�^�z��
        return true;
    }
}
