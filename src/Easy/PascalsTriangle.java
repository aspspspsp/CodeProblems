package Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(numRows == 0)
            return result;
        
        List<Integer> n1Res = new ArrayList<>();
        n1Res.add(1);
        result.add(n1Res);
        
        if(numRows == 1)
            return result;
            
        List<Integer> n2Res = new ArrayList<>();
        n2Res.add(1);
        n2Res.add(1);
        result.add(n2Res);
        
        if(numRows == 2)
            return result;
        
        for(int i = 2; i < numRows; i ++) {
            List<Integer> niRes = new ArrayList<>();
            for(int j = 0; j <= i; j ++) {
                int curElement = 1;
                if(j > 0 && j < i) {
                    curElement = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                }
                niRes.add(curElement);
            }
            result.add(niRes);
        }
        
        return result;
    }
}