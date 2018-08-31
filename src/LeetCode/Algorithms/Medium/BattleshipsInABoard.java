package src.LeetCode.Algorithms.Medium;

public class BattleshipsInABoard {
    /*
    戰艦只會有兩種方向: 直向、橫向，且不會有相鄰的情況，題目只會給出合法的輸入，所以我們不用排出戰艦相鄰的情況

    所以我們只要歷遍一遍表格，然後計算戰艦數量(只計算艦首，避免計算重複戰艦)，再返回答案即可

    ex1:
    X..X
    ...X   兩艘戰艦
    ...X

    ex2:
    ...X
    XXXX   相鄰的情況(輸入不會出現)，可以直接排除這種狀況
    ...X
    */
    public int countBattleships(char[][] board) {
        if(board.length == 0 || board[0].length == 0)
            return 0;

        int result = 0;

        //歷遍整個表格
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                if(board[i][j] == 'X') {
                    //因為我們的歷遍方式是由上->下(左->右)，所以若上面有'X'，表示是同一艘戰艦，不列入計算
                    if(i > 0 && board[i - 1][j] == 'X')
                        continue;
                    //因為我們的歷遍方式是由左->右(上->下)，所以若左邊有'X'，表示是同一艘戰艦，不列入計算
                    if(j > 0 && board[i][j - 1] == 'X')
                        continue;
                    //若都不是以上情況，則是戰艦的船首，我們則開始計算
                    result ++;
                }
            }
        }

        return result;
    }
}
