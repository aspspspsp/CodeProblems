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
        // �B�z�ҥ~���p
        if(head == null)
            return head;

        // (cur)�N�ثe�`�I���V�Y�`�I
        DoubledLinkedNode cur = head;

        // �}�l���M
        while(cur != null) {
            /* �J���l�`�I�h�N��l��list�P�ثe���`�I���W
            ex:
            1>2>5   => 1>2>3>4>5
             >3>4
            */
            if(cur.child != null) {
                // (next)�Ȧs��e�`�I���U�@�Ӹ`�I
                DoubledLinkedNode next = cur.next;

                // (child)�Ȧs��e�`�I����l�`�I
                DoubledLinkedNode child = cur.child;

                // ��l�`�I���U�@�Ӹ`�I
                child.prev = cur;
                cur.next = child;

                // child���w���V��l�`�I���̥�
                while(child.next != null)
                    child = child.next;

                // �Ynext�s�b���ܡA�h�Nchild�Pnext���s��
                if(next != null) {
                    child.next = next;
                    next.prev = child;
                }

                // �Ncur.child�]����
                cur.child = null;
            }

            // �󴫤U�@�Ӹ`�I
            cur = cur.next;

            // �קK�ҥ~���p
            if(cur == null)
                break;
        }

        return head;
    }
}
