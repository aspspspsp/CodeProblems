package src.LeetCode.Medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    /*
     * 
     * 將非符號的數字放入棧當中，若遇到符號便排出，進行運算後再放入棧中
     * 
    注意先進後出，故b會比a早排出
    */
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
            return 0;
        
        Stack stack = new Stack<Integer>();
        
        for(int i = 0; i < tokens.length; i ++) {
            if(tokens[i].equals("+")) {
                int b = (int) stack.pop();
                int a = (int) stack.pop();
                stack.push(a + b);
            } else if(tokens[i].equals("-")) {
                int b = (int) stack.pop();
                int a = (int) stack.pop();
                stack.push(a - b);
            } else if(tokens[i].equals("*")) {
                int b = (int) stack.pop();
                int a = (int) stack.pop();
                stack.push(a * b);
            } else if(tokens[i].equals("/")) {
                int b = (int) stack.pop();
                int a = (int) stack.pop();
                //注意處以零的問題
                if(b == 0)
                    return 0;
                stack.push(a / b);
             } else {
                int num = Integer.parseInt(tokens[i]);
                stack.push(num);
            }
        }
        
        int result = (int) stack.pop();
        if(stack.isEmpty() == false)
            return 0;
        
        return result;
    }
}