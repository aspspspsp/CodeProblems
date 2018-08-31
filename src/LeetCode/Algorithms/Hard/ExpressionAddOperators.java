package src.LeetCode.Algorithms.Hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(num, target, result, "", 0, 0, 0);
        
        return result;
    }
    
    void helper(String num, int target, List<String> result, String path, int pos, long eval, long mult) {
        if(pos == num.length()) {
            if(eval == target) {
                result.add(path);
            }
            
            return;
        }
        
        for(int i = pos; i < num.length(); i ++) {
            if(i != pos && num.charAt(pos) == '0') {
                break;
            }
            
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0) {
                helper(num, target, result, path + cur, i + 1, cur, cur);
            } else {
                helper(num, target, result, path + "+" + cur, i + 1, eval + cur, cur);
                helper(num, target, result, path + "-" + cur, i + 1, eval - cur, -cur);
                /* 唯一需要注意的就是乘法的情況，"345"可以產生出3+4*5，
                   到達5的時候，eval = 7, mul = 4
                   eval - mult算出不包含4的值，這裡是7-4=3，4是乘號以前的算式值，
                   4*5算乘法部分。
                */
                helper(num, target, result, path + "*" + cur, i + 1, (eval - mult) + mult * cur, mult * cur);
            }
        }
    }
}