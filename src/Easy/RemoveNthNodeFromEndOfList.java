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
public class RemoveNthNodeFromEndOfList {
    ListNode firstOfListNodes;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        //紀錄ListNode的頭
        firstOfListNodes = new ListNode(0);
        firstOfListNodes.next = head;
        
        //計算list node長度
        int sizeOfListNode = 1;
        while(head.next != null) {
            head = head.next;
            sizeOfListNode ++;
        }
        
        //回到頭
        head = firstOfListNodes;
        
        //再從新歷遍整個list node
        for(int i = 0; i < sizeOfListNode; i ++) {
            head = head.next;
            //遇到指定號碼的元素，掠過她
            if(sizeOfListNode - n == i + 1) {
                head.next = head.next.next;
                i = i + 1;
            }
            else
                head.next = head.next;
        }
        
        //特殊case，處理需要刪除頭元素的狀況
        if(sizeOfListNode == n)
            return firstOfListNodes.next.next;
        
        return firstOfListNodes.next;
    }
}