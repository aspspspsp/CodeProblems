package src.LeetCode.Algorithms.Easy;

import java.util.Stack;
/*
在O(1)的時間複雜度取得Stack中的「最小值」資料
要實作出MinStack的關鍵就是在一個class MinStack中使用「兩個Stack」，
其中一個Stack用來存放資料(稱為datastack)，另一個用來記錄「目前最小值
」(稱為minstack)。
 */
public class MinStack {

    //存放資料(稱為datastack)
    Stack<Integer> datastack;
    
    //用來記錄目前最小值(稱為minstack)。
    Stack<Integer> minstack;
    /** initialize your data structure here. */
    public MinStack() {
        minstack = new Stack<Integer>();
        minstack = new Stack<Integer>();
    }
    
    public void push(int x) {
        datastack.push(x);

/*
minstack就必須判斷「欲新增的資料」是否有比「目前最上面」還要小。
如果有，就把「欲新增的資料」push()進minstack，此時該資料會位在Stack的「最上面」。
特例：如果原先minstack裏面沒有資料，那麼就直接將「欲新增的資料」push()進minstack。
透過這個步驟，可以保證minstack的「最上面」資料就是datastack中的「最小值」。
如果沒有，就把minstack「目前最上面」的資料，再push()進minstack一次，表示在新增資料
後，「最小值」不變。
*/
        if(minstack.isEmpty() == true || minstack.peek() >= x)
            minstack.push(x);
    }
    
    public void pop() {
        if(datastack.isEmpty() == true)
            return;
        
        int popVal = datastack.peek();
        if(popVal == minstack.peek())
            minstack.pop();

        datastack.pop();
    }
    
    public int top() {
        return datastack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
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