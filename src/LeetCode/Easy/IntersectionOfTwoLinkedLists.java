package LeetCode.Easy;

import LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 
1. �õ�2�������ĳ��ȡ�
2. ������������ǰ�ƶ���ֵ��len1 - len2��
3. ����ָ��һ��ǰ����������ͬ�ļ��ǽ��㣬���û�ҵ�������null.
�൱ֱ�۵Ľⷨ���ռ临�Ӷ�O(1)�� ʱ�临�Ӷ�O(m+n)

 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        
        int sizeOfListNodeA = getSize(headA);
        int sizeOfListNodeB = getSize(headB);
        
        //��ɂ�listNode�L�Ȳ�ͬ�t���ɂ�listNode�L��׃��һ��
        if(sizeOfListNodeA > sizeOfListNodeB) {
            while(sizeOfListNodeA > sizeOfListNodeB) {
                headA = headA.next;
                sizeOfListNodeA --;
            }
        } else {
            while(sizeOfListNodeB > sizeOfListNodeA) {
                headB = headB.next;
                sizeOfListNodeB --;
            }
        }
        
        //��������^�̣�����headA���L��=headB���L��,�ʿ���ֱ���M��ListNode�Ăz�z���^
        while(headA != null) {
            //��ɂ�listNodeһ���Ǆt��ʾ�Ĵ��_ʼ��intersection���Ϳ��Է��ؽ��e�Ĳ���
            if(headA == headB) {
                return headA;
            }
            
            //������^ListNode��Ԫ��
            headA = headA.next;
            headB = headB.next;
        }
        
        //���]�н��e�Ĳ��քt����null
        return null;
    }
    
    //ȡ��ListNode���L�ȴ�С
    int getSize(ListNode node) {
        int size = 0;
        while(node != null) {
            size = size + 1;
            node = node.next;
        }
        
        return size;
    }
}