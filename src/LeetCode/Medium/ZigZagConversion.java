package src.LeetCode.Medium;

import java.util.HashMap;

public class ZigZagConversion {
    /*
    K = 3
    A   E   I
    B D F H J
    C   G   K
    
    curRow
    1  2  3  2  1  2  3  2  1  2  3
    A  B  C  D  E  F  G  H  I  J  K
    
    
    */
    enum Dir{
        UP,
        DOWN
    }

    public String convert(String s, int numRows) {
        if(s == "" || s == null)
            return "";
        if(numRows <= 1 || s.length() < numRows)
            return s;
        
        HashMap<Integer, String> res = new HashMap<>();
        
        Dir dir = Dir.DOWN;
        
        int curRow = 1;
        
        char[] ss = s.toCharArray();
        
        for(int i = 0; i < ss.length; i ++) {
            if(res.containsKey(curRow) == false)
                res.put(curRow, "" + ss[i]);
            else {
                String a = res.get(curRow);
                a += ss[i];
                res.put(curRow, a);
            }
            
            if(curRow >= numRows)
                dir = Dir.UP;
            else if(curRow <= 1)
                dir = Dir.DOWN;
            
            if(dir == Dir.DOWN)
                curRow ++;
            else
                curRow --;
        }
        
        String result = "";
        for(int i = 1; i <= numRows; i ++){
            result += res.get(i);
        }
        
        return result;
    }
}
