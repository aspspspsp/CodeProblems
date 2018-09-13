package src.LeetCode.Algorithms.Easy;

import src.LeetCode.Algorithms.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        // �ҥ~�B�z
        if(head == null)
            return head;

        // ���o��list������
        int lengthOfList = 1;
        ListNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
            lengthOfList ++;
        }

        // ���o���I��index
        int middleIndex = (int)Math.ceil(lengthOfList / 2);

        // ��줤�I
        cur = head;
        for(int i = 0; i < middleIndex; i ++) {
            cur = cur.next;
        }

        // ��^
        return cur;
    }
}
