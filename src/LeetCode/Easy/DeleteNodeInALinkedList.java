package LeetCode.Easy;

import LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * �����������ɾ�������һ���ڵ㣬��ͨ����ͬ����:
 * û�и������������㣬ֻ��������һ��Ҫɾ�Ľڵ�
 * �����Ĵ��������Ȱѵ�ǰ�ڵ��ֵ����һ���ڵ��ֵ�����ˣ�Ȼ������ɾ����һ���ڵ㼴��
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        //��Ҫ�h���Ĺ��cnode������һ�����c���w���_���h�����c��Ч��
        
        //���w�˹��c��ֵ
        node.val = node.next.val;
        
        //���w�˹��c��.next
        node.next = node.next.next;
    }
}