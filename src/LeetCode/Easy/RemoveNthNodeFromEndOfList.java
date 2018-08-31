package src.LeetCode.Easy;
import src.LeetCode.Dependencies.ListNode;

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
        
        //設置一個假結點，代表頭節點
        firstOfListNodes = new ListNode(0);
        firstOfListNodes.next = head;
        
        //先歷遍整個ListNode，取得ListNode的長度
        int sizeOfListNode = 1;
        while(head.next != null) {
            head = head.next;
            sizeOfListNode ++;
        }
        
        //指標，來歷遍
        head = firstOfListNodes;
        
        //開始再次歷遍節點
        for(int i = 0; i < sizeOfListNode; i ++) {
            head = head.next;
            //若指標取得預刪除的前一個節點，則將指標鍊結到域刪除的節點的下一個節點
            if(sizeOfListNode - n == i + 1) {
                head.next = head.next.next;
                i = i + 1;
            }
            else
                head.next = head.next;
        }
        
        //若式刪除的節點為頭節點，則返回頭節點的下一個
        if(sizeOfListNode == n)
            return firstOfListNodes.next.next;
        
        return firstOfListNodes.next;
    }
}