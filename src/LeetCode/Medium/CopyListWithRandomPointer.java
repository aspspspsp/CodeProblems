package src.LeetCode.Medium;

import src.LeetCode.Dependencies.RandomListNode;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        RandomListNode p = head;
        
        //複製每個節點並插入鍊表當中
        /*
        ex:
        -------       ---------------
        |     |       |             |
        1->2->3->4 => 1->1'->2->2'->3->3'->4->4'
        */
        while(p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }
        
        //對每個節點複製隨機指針
        /*
        ex:
                                         ---------------
        ---------------               ---|-----------  |
        |             |               |  |          |  |
        1->1'->2->2'->3->3'->4->4' => 1->1'->2->2'->3->3'->4->4'
        */
        p = head;
        while(p != null) {
            if(p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        
        //把兩個鍊表斷開
        /*
        ex:
            ---------------
         ---|-----------  |             -------     ---------
         |  |          |  |             |     |     |       |
         1->1'->2->2'->3->3'->4->4'  => 1->2->3->4, 1'->2'->3'->4'
        */
        p = head;
        RandomListNode newHead = head.next;
        while(p != null) {
            RandomListNode temp = p.next;
            p.next = temp.next;
            if(temp.next != null) {
                temp.next = temp.next.next;
            }
            p = p.next;
        }
        
        return newHead;
    }
}