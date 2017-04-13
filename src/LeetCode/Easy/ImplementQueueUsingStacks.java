package LeetCode.Easy;

import java.util.Stack;

/*
Stack���沽�Eex
 val = a1, a2, a3, a4;   temp = none
-----------����K���val-----------
1. val = a1, a2, a3;     temp = a4
2. val = a1, a2;         temp = a4, a3
3. val = a1;             temp = a4, a3, a2
4. val = none;           temp = a4, a3, a2, a1
-----------߀ԭval-----------------
 val = none;             temp = a4, a3, a2, a1
1. val = a1;             temp = a4, a3, a2
2. val = a1, a2;         temp = a4, a3
3. val = a1, a2, a3;     temp = a4
4. val = a2, a2, a3, a4; temp = none
*/
class ImplementQueueUsingStacks {
    //�Á탦��Queue
    Stack<Integer> value = new Stack<Integer>();
    //Push element x to the back of queue.
    public void push(int x) {
        //��value��տ���ֱ�ӷ���stack
        if(value.isEmpty() == true) {
            value.push(x);
        //��value�����
        } else {
            //����Ҫһ��temp stack�핺��
        	Stack<Integer> temp = new Stack<Integer>();
            
            //���stack�����M�ȳ�����queue�����M�ȳ�����Ҫģ�Mqueue
            //Ҫ�Ȍ����е�value����stack�����ԁ���temp�핺��(�K���value)
            while(value.isEmpty() == false) {
                temp.push(value.pop());
            }
            
            //���stack�����M�ȳ�����queue�����M�ȳ�����Ҫģ�Mqueue
            //Ҫ�ٰ�Ҫ�����Ԫ�ط����һ��(׌������queue�����������ų�)
            //(���queue�����ų���һ������Ԫ��)
            //(���stack�����ų�������һ������Ԫ��)
            value.push(x);
            
            //�ٌ������������Ѻ��value
            while(temp.isEmpty() == false) {
                value.push(temp.pop());
            }
        }
    }

    //Removes the element from in front of queue.
    public void pop() {
        //stack�cqueue���
        value.pop();
    }

    //Get the front element.
    public int peek() {
        //stack�cqueue���
        return value.peek();
    }

    //Return whether the queue is empty.
    public boolean empty() {
        //stack�cqueue���
        return value.isEmpty();
    }
}