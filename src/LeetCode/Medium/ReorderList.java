package LeetCode.Medium;

import LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *  
 * 1) �ÿ���ָ���ҵ��м�ڵ㣬������ֳ������֡�
 * 2) �Ժ���һ��������������Ҳ�ǳ�����������(����ת)��
 * 3) �ϲ���������
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
            
        //�ÿ���ָ���ҵ��м�ڵ㣬������ֳ������֡�
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            walker = walker.next;
        }
        
        //�����g���c������һ��ı��M������
        ListNode cur = walker;
        ListNode perv = null;
        while(cur != null) {
            ListNode nxt = cur.next;
            cur.next = perv;
            perv = cur;
            
            cur = nxt;
        }
        
        //�������朱�ρ㵽ǰ���朱�
        ListNode first = head;
        ListNode second = perv;
        while(first != null && second != null && first != second) {
            ListNode temp = second.next;
            
            second.next = first.next;
            first.next = second;
            
            //��first ��ָ��Ƶ���һ��
            first = second.next;
            
            //second ListNode��ָ��Ƶ���һ��
            second = temp;
        }
    }
}