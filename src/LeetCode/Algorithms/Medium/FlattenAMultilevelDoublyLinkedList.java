package src.LeetCode.Algorithms.Medium;

import src.LeetCode.Algorithms.Dependencies.DoubledLinkedNode;
/*
class DoubledLinkedNode {
    public int val;
    public DoubledLinkedNode prev;
    public DoubledLinkedNode next;
    public DoubledLinkedNode child;

    public DoubledLinkedNode() {}

    public DoubledLinkedNode(
            int _val,
            DoubledLinkedNode _prev,
            DoubledLinkedNode _next,
            DoubledLinkedNode _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
 */

public class FlattenAMultilevelDoublyLinkedList {
    public DoubledLinkedNode flatten(DoubledLinkedNode head) {
        // 處理例外情況
        if(head == null)
            return head;

        // (cur)將目前節點指向頭節點
        DoubledLinkedNode cur = head;

        // 開始歷遍
        while(cur != null) {
            /* 遇到兒子節點則將兒子的list與目前的節點接上
            ex:
            1>2>5   => 1>2>3>4>5
             >3>4
            */
            if(cur.child != null) {
                // (next)暫存當前節點的下一個節點
                DoubledLinkedNode next = cur.next;

                // (child)暫存當前節點的兒子節點
                DoubledLinkedNode child = cur.child;

                // 兒子節點當做下一個節點
                child.prev = cur;
                cur.next = child;

                // child指針指向兒子節點的最末
                while(child.next != null)
                    child = child.next;

                // 若next存在的話，則將child與next做連接
                if(next != null) {
                    child.next = next;
                    next.prev = child;
                }

                // 將cur.child設為空
                cur.child = null;
            }

            // 更換下一個節點
            cur = cur.next;

            // 避免例外情況
            if(cur == null)
                break;
        }

        return head;
    }
}
