package Easy;

import Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 
1. 得到2个链条的长度。
2. 将长的链条向前移动差值（len1 - len2）
3. 两个指针一起前进，遇到相同的即是交点，如果没找到，返回null.
相当直观的解法。空间复杂度O(1)， 时间复杂度O(m+n)

 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        
        int sizeOfListNodeA = getSize(headA);
        int sizeOfListNodeB = getSize(headB);
        
        //若兩個listNode長度不同則將兩個listNode長度變得一樣
        if(sizeOfListNodeA > sizeOfListNodeB) {
            while(sizeOfListNodeA > sizeOfListNodeB) {
                headA = headA.next;
                sizeOfListNodeA --;
            }
        } else {
            while(sizeOfListNodeB > sizeOfListNodeA) {
                headB = headB.next;
                sizeOfListNodeB --;
            }
        }
        
        //因為以上過程，所以headA的長度=headB的長度,故可以直接進行ListNode的倆倆比較
        while(headA != null) {
            //若兩個listNode一樣是則表示從此開始為intersection，就可以返回交錯的部分
            if(headA == headB) {
                return headA;
            }
            
            //依序比較ListNode的元素
            headA = headA.next;
            headB = headB.next;
        }
        
        //若沒有交錯的部分則返回null
        return null;
    }
    
    //取得ListNode的長度大小
    int getSize(ListNode node) {
        int size = 0;
        while(node != null) {
            size = size + 1;
            node = node.next;
        }
        
        return size;
    }
}