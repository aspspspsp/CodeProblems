package src.LeetCode.Algorithms.Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        int numRows = rowIndex + 1;
        
        List<List<Integer>> temp = new ArrayList<>();
        
        if(numRows == 0)
            return temp.get(0);
        
        List<Integer> n1Res = new ArrayList<>();
        n1Res.add(1);
        temp.add(n1Res);
        
        if(numRows == 1)
            return temp.get(0);
            
        List<Integer> n2Res = new ArrayList<>();
        n2Res.add(1);
        n2Res.add(1);
        temp.add(n2Res);
        
        if(numRows == 2)
            return temp.get(1);
        
        for(int i = 2; i < numRows; i ++) {
            List<Integer> niRes = new ArrayList<>();
            for(int j = 0; j <= i; j ++) {
                int curElement = 1;
                if(j > 0 && j < i) {
                    curElement = temp.get(i - 1).get(j - 1) + temp.get(i - 1).get(j);
                }
                niRes.add(curElement);
            }
            temp.add(niRes);
        }
        
        return temp.get(temp.size() - 1);
    }
}
