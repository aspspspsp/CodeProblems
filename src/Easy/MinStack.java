package Easy;

import java.util.Stack;

public class MinStack {
	
	//存儲元素的棧
    Stack<Integer> elements;
    
    //存儲最小元素的棧
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        elements = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int x) {
        elements.push(x);
        
        //若為最小元素(x<=最小)則放入最小棧
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