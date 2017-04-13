package LeetCode.Medium;

import java.util.LinkedList;

/*
�mȻ�@�}�cNumber of Islands��ƣ�������һ���yԇ������󔵓���ʹ��һ��ķ����������
���@�}ʹ��Flood fill�㷨������@�ӵĆ��}
*/
public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) 
            return;
            
        // **������һȦ������'O'��ǳ�'#'����Щ���ǲ����������ģ�������'O'**
        // �z����
        for(int i = 0; i < board.length; i ++) {
            fill(board, i, 0); //������е�0��
            fill(board, i, board[0].length - 1); //����������1��
        }
        // �z����
        for(int j = 0; j < board[0].length; j ++) {
            fill(board, 0, j); //������е�0��;
            fill(board, board.length - 1, j); //����������1��
        }
        
        // **��'O'׃��'X'��'#'׃��'O'(��鲻��׃��'X'��'O'�ѽ���ӛ��'#'����ʣ�µ�'O'����'X')**
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    
    //��ͬһƬ��'O'���'#',ʹ��һ��queue����BFS
    void fill(char[][] board, int i, int j) {
        if(board[i][j] != 'O')
            return;
        
        board[i][j] = '#'; //��Ŀǰ��'O'���'#'��
        
        //����queue����flood fill
        LinkedList<Integer> queue = new LinkedList<>();
        int code = generateCode(i, j, board[0].length);//����code�������c�У�������board[0].length�����ָ�
        
        queue.offer(code); //'#'����һ��queue
        
        while(!queue.isEmpty()) {
            code = queue.poll();
            
            //�������c��
            int row = code / board[0].length;
            int col = code % board[0].length;
            
            //Ȼ�����������ң���ʼflood fill
            if(row > 0 && board[row - 1][col] == 'O') {
                code = generateCode(row - 1, col, board[0].length);
                queue.offer(code);
                board[row - 1][col] = '#'; //��Ŀǰ��'O'���'#'��
            }
            if(row + 1 < board.length - 1 && board[row + 1][col] == 'O') {
                code = generateCode(row + 1, col, board[0].length);
                queue.offer(code);
                board[row + 1][col] = '#'; //��Ŀǰ��'O'���'#'��
            }
            if(col > 0 && board[row][col - 1] == 'O') {
                code = generateCode(row, col - 1, board[0].length);
                queue.offer(code);
                board[row][col - 1] = '#'; //��Ŀǰ��'O'���'#'��
            }
            
            if(col + 1 < board[0].length - 1 && board[row][col + 1] == 'O') {
                code = generateCode(row, col + 1, board[0].length);
                queue.offer(code);
                board[row][col + 1] = '#'; //��Ŀǰ��'O'���'#'��
            }
        }
    }
    
    int generateCode(int i, int j, int mask) {
        return i * mask + j;
    }
}