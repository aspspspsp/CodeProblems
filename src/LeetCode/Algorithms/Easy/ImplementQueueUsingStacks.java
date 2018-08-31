package src.LeetCode.Algorithms.Easy;

import java.util.Stack;

//這題是使用Stack來暫存另一個Stack的數據
//Stack暫存步驟ex:
// val = a1, a2, a3, a4;   temp = none
//-----------暫存並清空val-----------
//1. val = a1, a2, a3;     temp = a4
//2. val = a1, a2;         temp = a4, a3
//3. val = a1;             temp = a4, a3, a2
//4. val = none;           temp = a4, a3, a2, a1
//-----------還原val-----------------
// val = none;             temp = a4, a3, a2, a1
//1. val = a1;             temp = a4, a3, a2
//2. val = a1, a2;         temp = a4, a3
//3. val = a1, a2, a3;     temp = a4
//4. val = a2, a2, a3, a4; temp = none
class ImplementQueueUsingStacks {
    //用來儲存Queue
    Stack<Integer> value = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        //若value為空可以直接放入stack
        if(value.isEmpty() == true) {
            value.push(x);
        //若value不為空
        } else {
            //就需要一個temp stack來暫存
            Stack<Integer> temp = new Stack<Integer>();
            
            //因為stack為後進先出，而queue為先進先出，故要模擬queue
            //要先將所有的value按照stack的特性來至temp來暫存(並清空value)
            while(value.isEmpty() == false) {
                temp.push(value.pop());
            }
            
            //因為stack為後進先出，而queue為先進先出，故要模擬queue
            //要再把要加入的元素放入第一個(讓它依照queue的特性最後排出)
            //(因為queue最先排出第一個放入元素)
            //(因為stack最先排出第最後一個放入元素)
            value.push(x);
            
            //再將其他按照順序押入value
            while(temp.isEmpty() == false) {
                value.push(temp.pop());
            }
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        //stack與queue類似
        value.pop();
    }

    // Get the front element.
    public int peek() {
        //stack與queue類似
        return value.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        //stack與queue類似
        return value.isEmpty();
    }
}