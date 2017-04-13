package LeetCode.Easy;

import java.util.LinkedList;
import java.util.Queue;

/*
���������У�push: O(1)��pop: O(n)��top: O(n)
����������queue1��queue2ʵ��һ��ջ��
pushʱ����Ԫ����ӵ�queue1�Ķ�β��
popʱ��queue1�г����һ��Ԫ���������ӵ�queue2�У�
Ȼ��pop��queue1�е����һ��Ԫ�أ�
Ȼ��ע��ǵ�queue1��queue2���Ա�֤�������Ԫ��ʱʼ����queue1����ӡ�
top�ĵ������ơ�
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
        
        //׌queue1�cqueue2����һ�£��@�Ӳ���׌����Ĳ��������M�в��e�`
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
        
        //׌queue1�cqueue2����һ�£��@�Ӳ���׌����Ĳ��������M�в��e�`
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