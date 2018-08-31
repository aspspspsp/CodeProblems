package src.LeetCode.Easy;

import java.util.Stack;

public class MinStack {
	
	//�惦Ԫ�صė�
    Stack<Integer> elements;
    
    //�惦��СԪ�صė�
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        elements = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int x) {
        elements.push(x);
        
        //������СԪ��(x<=��С)�t������С��
        if(min.isEmpty() == true || min.peek() >= x)
            min.push(x);
    }
    
    public void pop() {
        if(elements.isEmpty() == true)
            return;
        
        int popVal = elements.peek();
        if(popVal == min.peek())
            min.pop();
        
        elements.pop();
    }
    
    public int top() {
        return elements.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */