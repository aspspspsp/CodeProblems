package LeetCode.Easy;
import LeetCode.Dependencies.ListNode;

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
        
        //�o�ListNode���^
        firstOfListNodes = new ListNode(0);
        firstOfListNodes.next = head;
        
        //Ӌ��list node�L��
        int sizeOfListNode = 1;
        while(head.next != null) {
            head = head.next;
            sizeOfListNode ++;
        }
        
        //�ص��^
        head = firstOfListNodes;
        
        //�ُ��v������list node
        for(int i = 0; i < sizeOfListNode; i ++) {
            head = head.next;
            //����ָ��̖�a��Ԫ�أ����^��
            if(sizeOfListNode - n == i + 1) {
                head.next = head.next.next;
                i = i + 1;
            }
            else
                head.next = head.next;
        }
        
        //����case��̎����Ҫ�h���^Ԫ�صĠ�r
        if(sizeOfListNode == n)
            return firstOfListNodes.next.next;
        
        return firstOfListNodes.next;
    }
}