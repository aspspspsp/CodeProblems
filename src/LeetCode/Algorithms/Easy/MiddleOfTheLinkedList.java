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
        // 例外處理
        if(head == null)
            return head;

        // 找到這個list的長度
        int lengthOfList = 1;
        ListNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
            lengthOfList ++;
        }

        // 取得中點的index
        int middleIndex = (int)Math.ceil(lengthOfList / 2);

        // 找到中點
        cur = head;
        for(int i = 0; i < middleIndex; i ++) {
            cur = cur.next;
        }

        // 返回
        return cur;
    }
}
