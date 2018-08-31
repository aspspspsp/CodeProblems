package src.LeetCode.Easy;

import src.LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * 这道题让我们删除链表的一个节点，更通常不同的是:
 * 没有给我们链表的起点，只给我们了一个要删的节点
 * 这道题的处理方法是先把当前节点的值用下一个节点的值覆盖了，然后我们删除下一个节点即可
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        //將要刪除的節點node利用下一個節點來覆蓋，達到刪除節點的效果
        
        //覆蓋此節點的值
        node.val = node.next.val;
        
        //覆蓋此節點的.next
        node.next = node.next.next;
    }
}