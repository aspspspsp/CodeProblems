package Easy;

import Dependencies.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        //��head�O���һ�����L���c
        ListNode visit_node = head;
        
        //��һ���L�������cֱ���Y�c���
        while(visit_node != null) {
            
            //�z��˹��c����Ĺ��c�Ƿ������}�����и����c�����}�t���^
            ListNode tmp = visit_node.next;
            while(tmp != null && tmp.val == visit_node.val) {
                tmp = tmp.next;
            }
            
            //����ȥ�ص�����һ�����c���ϰ��L���c
            visit_node.next = tmp;
            
            //���L��һ���c
            visit_node = visit_node.next;
        }
        
        return head;
    }
}