package Easy;

import Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        
        //找到中點
        ListNode middle = findMiddle(head);
        
        //將鍊表右邊的一半翻轉
        middle.next = reverse(middle.next);
        ListNode half_right = middle.next;
        
        //左半邊與右半邊進行比較
        ListNode half_left = head;
        while(half_right != null && half_left != null &&
              half_right.val == half_left.val) {
            half_right = half_right.next;
            half_left = half_left.next;
        }
        
        //若half_right沒有歷遍完，表示不是回文
        if(half_right == null) {
            return true;
        }
        return false;
    }
    
    //找到中間點
    ListNode findMiddle(ListNode head) {
        if(head == null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    //翻轉鍊表
    ListNode reverse(ListNode head) {
        ListNode prev = null;
        
        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        
        return prev;
    }
    
}