package LeetCode.Easy;

import LeetCode.Dependencies.ListNode;
/*
 * 
歷遍整個List，因為元素都是已經排序好的，故遇到一樣的元素就是重複的元素，則可以略過，
而遇到不一樣的元素，則把它串接起來
ex:
=====================================================================
1. 1->2->2->2->3->4 拜訪1
2. 1->2->2->2->3->4 拜訪2 比較 1,2
3. 1->2->2->2->3->4 拜訪2 比較 2,2 一樣則將目前的節點與下一個節點串再一起
4. 1->2->2->3->4  拜訪2 比較 2,2 一樣則將目前的節點與下一個節點串再一起
5. 1->2->3->4 拜訪3 比較 2,3
6. 1->2->3->4 拜訪4 比較 3,4
結束
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