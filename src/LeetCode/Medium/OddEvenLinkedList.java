package LeetCode.Medium;

import LeetCode.Dependencies.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        //��¼ͷ
        ListNode result = head;
        
        //��������һ��Ĵ���
        ListNode p1 = head;
        
        //����ż��һ��Ĵ���
        ListNode p2 = head.next;
        
        //connect node����;�ǰ�������һ����ż����һ��ƴ��һ��
        ListNode connect_node = head.next;
        
        while(p1 != null && p2 != null) {
            ListNode tmp = p2.next;
            if(tmp == null)
                break;
            
            p1.next = p2.next;
            p1 = p1.next;
            
            p2.next = p1.next;
            p2 = p2.next;
        }
        
        //��������һ����ż����һ��ƴ��һ��
        p1.next = connect_node;
        
        return result;
    }
}
