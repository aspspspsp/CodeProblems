package Medium;

import Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode p1 = new ListNode(0); //���С�x��ListNode
        ListNode p1_first = p1;
        ListNode p2 = new ListNode(0); //��Ŵ�춵��x��ListNode
        ListNode p2_first = p2;
        
        ListNode cur = head;
        
        //�Դ˱���ԭ��������ڵ��ֵ��춵��x�����B��p2���棬��֮��ŵ�p1
        while(cur != null) {
            if(cur.val >= x) {
                p2.next = cur;
                p2 = p2.next; //ָ��Ƶ���һ�����������ֻ����һ���ط�
            } else {
                p1.next = cur;
                p1 = p1.next;
            }
            cur = cur.next;
        }
        
        //��p2�����Ǭ�Q
        p2.next = null;
        
        //��p2����p1����
        p1.next = p2_first.next;
        
        return p1_first.next;
        
    }
}