package Medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int returnValue = 0;
        String operators = "+-*/";
        
        Stack<String> stack = new Stack<>();
        
        for(String token : tokens) {
            //若是運算符則入堆棧
            if(operators.contains(token) == false) {
                stack.push(token);
                
            //若不是運算符則將堆棧推出a與b，再做運算，再入堆棧
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                
                switch(token) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(a - b));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }
        
        //推出最後結果
        returnValue = Integer.valueOf(stack.pop());
        return returnValue;
    }
}
