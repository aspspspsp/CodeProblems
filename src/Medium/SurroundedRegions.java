package Medium;

import java.util.LinkedList;

/*
雖然這題與Number of Islands類似，但最後一個測試樣例為大數據，使用一般的方法會溢出，
故這題使用Flood fill算法來避免這樣的問題
*/
public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) 
            return;
            
        // **把四周一圈的所有'O'标记成'#'，这些都是不符合条件的，最后会变会'O'**
        // 檢查列
        for(int i = 0; i < board.length; i ++) {
            fill(board, i, 0); //检查所有第0列
            fill(board, i, board[0].length - 1); //检查所有最后1列
        }
        // 檢查行
        for(int j = 0; j < board[0].length; j ++) {
            fill(board, 0, j); //检查所有第0行;
            fill(board, board.length - 1, j); //检查所有最后1行
        }
        
        // **將'O'變成'X'，'#'變成'O'(因為不會變成'X'的'O'已經標記為'#'，故剩下的'O'就是'X')**
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    
    //把同一片的'O'变成'#',使用一个queue来做BFS
    void fill(char[][] board, int i, int j) {
        if(board[i][j] != 'O')
            return;
        
        board[i][j] = '#'; //将目前的'O'变成'#'；
        
        //利用queue來做flood fill
        LinkedList<Integer> queue = new LinkedList<>();
        int code = generateCode(i, j, board[0].length);//利用code儲存行與列，而利用board[0].length來做分隔
        
        queue.offer(code); //'#'放入一个queue
        
        while(!queue.isEmpty()) {
            code = queue.poll();
            
            //解密行與列
            int row = code / board[0].length;
            int col = code % board[0].length;
            
            //然后检查上下左右，开始flood fill
            if(row > 0 && board[row - 1][col] == 'O') {
                code = generateCode(row - 1, col, board[0].length);
                queue.offer(code);
                board[row - 1][col] = '#'; //将目前的'O'变成'#'；
            }
            if(row + 1 < board.length - 1 && board[row + 1][col] == 'O') {
                code = generateCode(row + 1, col, board[0].length);
                queue.offer(code);
                board[row + 1][col] = '#'; //将目前的'O'变成'#'；
            }
            if(col > 0 && board[row][col - 1] == 'O') {
                code = generateCode(row, col - 1, board[0].length);
                queue.offer(code);
                board[row][col - 1] = '#'; //将目前的'O'变成'#'；
            }
            
            if(col + 1 < board[0].length - 1 && board[row][col + 1] == 'O') {
                code = generateCode(row, col + 1, board[0].length);
                queue.offer(code);
                board[row][col + 1] = '#'; //将目前的'O'变成'#'；
            }
        }
    }
    
    int generateCode(int i, int j, int mask) {
        return i * mask + j;
    }
}