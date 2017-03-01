package Medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int returnValue = 0;
        String operators = "+-*/";
        
        Stack<String> stack = new Stack<>();
        
        for(String token : tokens) {
            //�����\����t��ї�
            if(operators.contains(token) == false) {
                stack.push(token);
                
            //�������\����t���ї��Ƴ�a�cb�������\�㣬����ї�
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
        
        //�Ƴ�����Y��
        returnValue = Integer.valueOf(stack.pop());
        return returnValue;
    }
}
