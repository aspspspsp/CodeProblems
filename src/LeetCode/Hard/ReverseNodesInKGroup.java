package LeetCode.Hard;

import LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * ������ǰ�ԭ����ֳ�����С��(k-group)��Ȼ��ֱ������з�ת��
 * ��ô�϶��ܹ���Ҫ����������һ���������ֶεģ�һ������
 * ����ת�ģ����Ǿ�����Ŀ�и����������������ڸ�������
 * 1->2->3->4->5��һ���ڴ�����������ʱ�����Ǵ��ʱ��
 * �����ڿ�ͷ�ټ�һ��dummy node����Ϊ��ת����ʱͷ���
 * ���ܻ�仯��Ϊ�˼�¼��ǰ���µ�ͷ����λ�ö������
 * dummy node����ô���Ǽ���dummy node��������Ϊ
 * -1->1->2->3->4->5�����kΪ3�Ļ������ǵ�Ŀ���ǽ�
 * 1,2,3��תһ�£���ô������ҪһЩָ�룬pre��next�ֱ�
 * ָ��Ҫ��ת�������ǰ���λ�ã�Ȼ��ת��pre��λ�ø�
 * �µ������µ�λ�ã�
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int i = 0;
        
        ListNode p = head;
        while(p != null) {
            i ++;
            //��k��������һ��group���M�з��D
            if(i % k == 0) {
                prev = reverse(prev, p.next);
                p = prev.next;
            } else {
                p = p.next;
            }
        }
        
        return dummy.next;
    }
    
    /*
     * 0->1->2->3->4->5->6
     * |           |   
     * pre        next
     *
     * after calling pre = reverse(pre, next)
     * 
     * 0->3->2->1->4->5->6
     *          |  |
     *          pre next 
     */
    ListNode reverse (ListNode prev, ListNode next) {
        ListNode last = prev.next;
        ListNode curr = last.next;
        
        while(curr != next) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }
        
        return last;
    }
}