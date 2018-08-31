package src.LeetCode.Algorithms.Easy;

public class JudgeRouteCircle {
	public boolean judgeCircle(String moves) {
        if(moves == null || moves.length() == 0)
            return false;
        
        int x = 0;
        int y = 0;
        
        moves.toUpperCase();
        char[] c_move = moves.toCharArray();
        for(int i = 0; i < c_move.length; i ++) {
            switch(c_move[i]) {
                case 'L':
                    x -= 1;
                    break;
                case 'R':
                    x += 1;
                    break;
                case 'U':
                    y -= 1;
                    break;
                case 'D':
                    y += 1;
                    break;
                default:
                    return false;
            }
        }
        
        return (x == 0 && y == 0);
    }
}
