package Easy;

import java.util.LinkedList;
import java.util.Queue;

/*
用两个队列，push: O(1)，pop: O(n)，top: O(n)
用两个队列queue1、queue2实现一个栈。
push时把新元素添加到queue1的队尾。
pop时把queue1中除最后一个元素外逐个添加到queue2中，
然后pop掉queue1中的最后一个元素，
然后注意记得queue1和queue2，以保证我们添加元素时始终向queue1中添加。
top的道理类似。
*/
class ImplementStackUsingQueues {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        queue1.poll();
        
        //讓queue1與queue2保持一致，這樣才能讓以後的操作可以進行不錯誤
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Get the top element.
    public int top() {
        while(queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int top = queue1.peek();
        queue2.offer(queue1.poll());
        
        //讓queue1與queue2保持一致，這樣才能讓以後的操作可以進行不錯誤
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }
}