package src.LeetCode.Algorithms.Easy;

import java.util.HashMap;
import java.util.Stack;

/*
 ex:[()][]
    opt     stack 解釋
 1.push [ =>  [
 2.push ( =>  [(  
 3.pop  ( =>  [   因為遇到) 故要排出(
 4.check ()
 5.pop  [ =>      因為遇到] 故要排出[
 6.check []
 7.push [ =>  [
 8.pop  [ =>      因為遇到] 故要排出[
 9.check []
*/
public class ValidParentheses {
    HashMap<String, String> parentheses = new HashMap<String, String>();
    
    Stack<String> stack = new Stack<String>();
    public boolean isValid(String s) {
        
        // 對整個String逐步檢查
        for(int i = 0; i < s.length(); i ++) {
            String token = s.substring(i, i + 1);
            
            // 如果遇到前括号(Ex: "(", "[", "{")就压入栈 
            if(token.equals("(") || token.equals("[") || token.equals("{")) {
                stack.push(token);
            
            // 如果遇到後括号(Ex: ")", "]", "]")就排出栈
            } else if(token.equals(")") || token.equals("]") || token.equals("}")) {
                
                // 若stack為空，表示左右括號並不均等，故為false
                if(stack.isEmpty() == true)
                    return false;
                
                if(stack.isEmpty() == false) {
                    // 只排出一個括号
                    String check = stack.pop();
                    
                    // 若(,)則這個是正確的
                    if(check.equals("(") == true && token.equals(")") == true)
                        continue;
                    // 若[,]則這個是正確的 
                    else if(check.equals("[") == true && token.equals("]") == true)
                        continue;
                    // 若{,}則這個是正確的
                    else if(check.equals("{") == true && token.equals("}") == true)
                        continue;
                    // 都不是表示括號匹配錯誤
                    else
                        return false;
                }
            }
        }
        
        // 因為括號都是兩兩相對的，若還有剩餘的話表示左右括號並不均等，則為false
        if(stack.isEmpty() == true)
            return true;
        else 
            return false;
    }
}