package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
/*
当我们放置一个新的符号时，我们有两个选择:
放置左括号，或者放置右括号
但是按照题意我们最多放置n个左括号，放一个剩余可放置左括号就少一个，
但剩余可放置右括号则多了一个。而对于右括号，必须前面放了一个左括号，
我们才能放一个右括号。所以我们根据剩余可放置左括号，和剩余可放置右括
号，代入递归，就可以求解。    
*/
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int left = n;
        int right = 0;
        String tmp = "";
        
        helper(left, right, result, tmp);
        return result;
    }
    
    void helper(int left, int right, List<String> result, String tmp) {
        //如果左括號與右括號都放完了，則會得到一個結果
        if(left == 0 && right == 0) {
            result.add(tmp);
            return;
        }
        
        //對於每個位置，有兩個選擇:
        //1.放左括號
        //2.放右括號
        if(left > 0) {
            helper(left - 1, right + 1, result, tmp + "(");
        }
        if(right > 0) {
            helper(left, right - 1, result, tmp + ")");
        }
    }
}
