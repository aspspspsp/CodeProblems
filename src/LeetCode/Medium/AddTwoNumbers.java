package LeetCode.Medium;

import LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val; //ȡ�î�ǰλ��
 *     ListNode next; //�M����һλ
 *     ListNode(int x) { val = x; } //������
 * }
 */
public class  AddTwoNumbers {	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //����һ��ListNode����0λ��0 = 0(��ɶ���o���^������н��������Ա�������cɶ)
        ListNode result = new ListNode(0);
        
        //�������ListNode�cresult�Y����ͬ�����Ҫ׌ָᘞ�1�𰸲ŕ����_(��resultָᘚw0)
        ListNode dummy = result;
        
        //��춃�λ����ӣ�һ�_ʼ��0
        int carrier = 0;

        //��l1��l2�����
        while(l1 != null || l2 != null) {
            
            //��l1�����
            if(l1 != null) {
                //l1�c��ǰλ���ccarrier�M�����
                carrier = l1.val + carrier;
                //��l1��ָ�������һλ
                l1 = l1.next;
            }
            
            if(l2 != null) {
                //l2�c��ǰλ���ccarrier�M�����
                carrier = l2.val + carrier;
                //��l2��ָ�������һλ
                l2 = l2.next;
            }
            
            //��̎����Į�ǰλ������Y���Į�ǰλ��(��ǰλ�� = (l1��ǰλ�� + l2 ��ǰλ��) % 10)
            result.next = new ListNode(carrier % 10);
            //�M���Mλ(����)������ʣ��Ĕ����´΃ɔ����ʹ��
            carrier = carrier / 10;

            //׌�Y���Mλ
            result = result.next;
        }
        //�z������һλ�Ƿ���Ҫ�Mλ
        if(carrier == 1) {
            //����Ҫ��λ�r�����Y������һλ���K��1
            result.next = new ListNode(1);
        }
        
        //��dummy��ָ�ָ���1λ(dummy�ĵ�0λһ����0����Ҫ���_)
        dummy = dummy.next;
                
        return dummy;
    }
}