package Easy;

import Dependencies.ListNode;
/*
 * 
首先要实现一个单链表，因此需要定义一个节点类Node。
其次，实现向链表中添加结点的方法(使用尾插法)addNode

删除重复结点的实现思路：
定义两个指针：pre 和 next。初
始时，pre指向链表中的第一个元素，next指向链表中的第二个元素。
如果 pre 的值与 next 的值不相等，则两个指针分别都向后移一个结点；
若相等，则删除 next 指针指向的结点即可。
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