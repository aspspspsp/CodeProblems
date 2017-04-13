package LeetCode.Medium;
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] word_chars = word.toCharArray();
        
        if(word_chars.length > board.length * board[0].length)
            return false;
        
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                if(board[i][j] == word_chars[0]) {
                    if(dfs(board, word_chars, 0, i, j) == true)
                        return true;
                }
            }
        }
        
        return false;
    }
    
    boolean dfs(char[][] board, char[] word_chars, int k, int i, int j) {
        if(k == word_chars.length - 1)
            return true;
            
        //�e��ӛdfs���Е���
        char temp = board[i][j];
        board[i][j] = '*';
        
        boolean isFound = false;
        if(i + 1 < board.length && k < word_chars.length && board[i + 1][j] == word_chars[k + 1]) //��
            isFound = isFound || dfs(board, word_chars, k + 1, i + 1, j);
        if(j + 1 < board[0].length && k < word_chars.length && board[i][j + 1] == word_chars[k + 1]) //��
            isFound = isFound || dfs(board, word_chars, k + 1, i, j + 1);
        if(j - 1 >= 0 && k < word_chars.length && board[i][j - 1] == word_chars[k + 1]) //��
            isFound = isFound || dfs(board, word_chars, k + 1, i, j - 1);
        if(i - 1 >= 0 && k < word_chars.length && board[i - 1][j] == word_chars[k + 1]) //��
            isFound = isFound || dfs(board, word_chars, k + 1, i - 1, j);
        
        board[i][j] = temp;
        
        return isFound;
    }
}