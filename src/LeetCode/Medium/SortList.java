package LeetCode.Medium;

import LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        return margeSort(head);
    }
    
    ListNode margeSort(ListNode head) {
        //handel special case
        if(head == null || head.next == null)
            return head;
            
        ListNode walker = head;
        ListNode runner = head;
        
        //��runner�v������ListNode��,walker����ListNode�����g(walker�������c)
        while(runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        
        //������������
        ListNode right = walker.next;
        walker.next = null;
        ListNode left = head;
        
        //��������ֱ�����
        right = margeSort(right);
        left = margeSort(left);
        
        //�ρ����҃�߅
        return marge(left, right);
    }
    
    //�ρ����҃�߅
    ListNode marge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        dummy.next = left;
        ListNode previous = dummy;
        
        //�M������(��������)
        /*
        ���Y�Ϸֳ�������δ����ɲ���
        ������δ�����еĵ�һ�P(��̎���ֵ)�����뵽�������е��m��λ��
        ����r���Ҷ�����^��ֱ��������һ������̎���ֵС��ֵ���ٲ���
        ���^�r����������ֵ����̎���ֵ�����ȣ��t��ֵ������
        */
        while(left != null && right != null) {
            //�@߅���M���������
            if(left.val < right.val) {
                left = left.next;
            } else {
                ListNode next = right.next;
                right.next = previous.next;
                previous.next = right;
                right = next;
            }
            
            previous = previous.next;
        }
        
        //����©������һ��
        if(right != null) {
            previous.next = right;
        }
        
        return dummy.next;
    }
}