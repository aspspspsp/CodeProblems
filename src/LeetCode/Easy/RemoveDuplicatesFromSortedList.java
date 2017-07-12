package LeetCode.Easy;

import LeetCode.Dependencies.ListNode;
/*
 * 
����Ҫʵ��һ�������������Ҫ����һ���ڵ���Node��
��Σ�ʵ������������ӽ��ķ���(ʹ��β�巨)addNode

ɾ���ظ�����ʵ��˼·��
��������ָ�룺pre �� next����
ʼʱ��preָ�������еĵ�һ��Ԫ�أ�nextָ�������еĵڶ���Ԫ�ء�
��� pre ��ֵ�� next ��ֵ����ȣ�������ָ��ֱ������һ����㣻
����ȣ���ɾ�� next ָ��ָ��Ľ�㼴�ɡ�
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        //將head設為第一個拜訪的點
        ListNode visit_node = head;
        
        //逐一拜訪其他節點直到結點為空
        while(visit_node != null) {
            
            //檢查此節點後面的節點是否有重複，若有跟此點有重複則略過
            ListNode tmp = visit_node.next;
            while(tmp != null && tmp.val == visit_node.val) {
                tmp = tmp.next;
            }
            
            //將以去重的最後一個節點接上拜訪的點
            visit_node.next = tmp;
            
            //拜訪下一個點
            visit_node = visit_node.next;
        }
        
        return head;
    }
}