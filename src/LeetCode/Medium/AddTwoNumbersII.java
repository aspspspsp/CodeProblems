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
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        if(l1 == null || l2 == null)
            return result;
        
        //得到兩個鏈表的長度
        int l1len = getLength(l1);
        int l2len = getLength(l2);
        
        //若l2長度大於l1的長度，就交換它們
        if(l2len > l1len) {
            ListNode tmp = l2;
            l2 = l1;
            l1 = tmp;
            
            int lenTmp = l2len;
            l2len = l1len;
            l1len = lenTmp;
        }
        
        //設置l1的頭指針
        ListNode l1head = l1;
        
        //將l1的指針與l2的頭指針進行對齊，以方便相加
        int moveStep = l1len - l2len;
        for(int i = 0; i < moveStep; i ++) {
            l1 = l1.next;
        }
        
        //將l1與l2相加
        while(l1 != null && l2 != null) {
            l1.val += l2.val;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        //處理第一位之後的進位，並檢查每一位都有確實進位
        boolean needCheck = true;
        while(needCheck == true) {
            l1 = l1head;
            needCheck = false;
            while(l1 != null) {
                if(l1.next != null) {
                    if(l1.next.val > 9) {
                        l1.next.val = l1.next.val % 10;
                        l1.val += 1;
                        needCheck = true;
                    }
                }
                l1 = l1.next;
            }
        }
        
        //處理第一位進位，若第一位需要進位則在前面多一個節點
        l1 = l1head;
        if(l1.val > 9) {
            ListNode head = new ListNode(1);
            l1.val = l1.val % 10;
            head.next = l1;
            
            return head;
        }
            
        return l1;
    }
    
    
    int getLength(ListNode list) {
        int length = 0;
        while(list != null) {
            length ++;
            list = list.next;
        }
        
        return length;
    }
}