package Hard;

import Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 这道题是把原链表分成若干小段(k-group)，然后分别对其进行翻转，
 * 那么肯定总共需要两个函数，一个是用来分段的，一个是用
 * 来翻转的，我们就以题目中给的例子来看，对于给定链表
 * 1->2->3->4->5，一般在处理链表问题时，我们大多时候
 * 都会在开头再加一个dummy node，因为翻转链表时头结点
 * 可能会变化，为了记录当前最新的头结点的位置而引入的
 * dummy node，那么我们加入dummy node后的链表变为
 * -1->1->2->3->4->5，如果k为3的话，我们的目标是将
 * 1,2,3翻转一下，那么我们需要一些指针，pre和next分别
 * 指向要翻转的链表的前后的位置，然后翻转后pre的位置更
 * 新到如下新的位置：
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int i = 0;
        
        ListNode p = head;
        while(p != null) {
            i ++;
            //把k個數當成一個group，進行翻轉
            if(i % k == 0) {
                prev = reverse(prev, p.next);
                p = prev.next;
            } else {
                p = p.next;
            }
        }
        
        return dummy.next;
    }
    
    /*
     * 0->1->2->3->4->5->6
     * |           |   
     * pre        next
     *
     * after calling pre = reverse(pre, next)
     * 
     * 0->3->2->1->4->5->6
     *          |  |
     *          pre next 
     */
    ListNode reverse (ListNode prev, ListNode next) {
        ListNode last = prev.next;
        ListNode curr = last.next;
        
        while(curr != next) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }
        
        return last;
    }
}