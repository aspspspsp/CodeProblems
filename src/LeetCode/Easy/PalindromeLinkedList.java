package src.LeetCode.Easy;

import src.LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * ex: 1 2 3 2 1
 * 1.找到中點 3
 * 2.翻轉 2 1 -> 1 2
 * 3.比較鏈表的左右兩邊 1 2 3, 1 2是否長度一樣(除中點外)，數字是否一致
 * 3.1. 1 2 3, 1 2 <-比較1, 1一致
 * 3.2. 2 3, 2<-比較2, 2一致
 * 3.3. 3 <- 右邊為空，跳出
 * 4.比較完成，右邊為空，返回true，若右邊不為空返回false
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        
        //找到中點
        ListNode middle = findMiddle(head);
        
        //將鏈表右邊的一半翻轉(中點的下一個鏈表)
        middle.next = reverse(middle.next);
        
        
        ListNode half_right = middle.next; //指針指到右半邊的頭
        ListNode half_left = head; //指針指到左半邊的頭
        
        //比較左右兩半的鏈表是否一致
        while(half_right != null && half_left != null &&
              half_right.val == half_left.val) {
            half_right = half_right.next;
            half_left = half_left.next;
        }
        
        //若右半邊到達鏈表尾端(half_right == null)時，則為回文
        //因為左半邊會有中間點的問題(左半邊會含有中間點)
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
    
    //翻轉鏈表
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