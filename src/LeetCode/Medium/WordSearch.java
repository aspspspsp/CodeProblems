package src.LeetCode.Medium;
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] word_chars = word.toCharArray();
        
        //若要搜索的字串的長度大於整個文字板的長度，則返回false
        if(word_chars.length > board.length * board[0].length)
            return false;
        
        //對整個字板進行歷遍，然後再進行dfs
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                if(board[i][j] == word_chars[0]) {
                    if(dfs(board, word_chars, 0, i, j) == true)
                        return true;
                }
            }
        }
        
        //都沒有找到，故返回false
        return false;
    }
    
    boolean dfs(char[][] board, char[] word_chars, int k, int i, int j) {
        //若已經找到該字串則返回true
    	if(k == word_chars.length - 1)
            return true;
            
        //在進行完該步dfs後，都要回退上一步的結果
        char temp = board[i][j];
        
        //標記這一步是否已經走過
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
        
        //回退上一步
        board[i][j] = temp;
        
        //返回找到的結果
        return isFound;
    }
}