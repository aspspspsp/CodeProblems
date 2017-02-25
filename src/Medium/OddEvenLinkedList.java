package Medium;

import Dependencies.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        //记录头
        ListNode result = head;
        
        //负责奇数一半的串接
        ListNode p1 = head;
        
        //负责偶数一半的串接
        ListNode p2 = head.next;
        
        //connect node的用途是把奇数的一半与偶数的一半拼在一起
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
        
        //把奇数的一半与偶数的一半拼在一起
        p1.next = connect_node;
        
        return result;
    }
}
