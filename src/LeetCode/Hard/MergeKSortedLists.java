package LeetCode.Hard;

import LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
 * 最常用的方法是采用“二分”的思想进行两两合并：
 * 第一轮循环:
 * 有序表lists[0]与lists[(K+1)/2]
 * ，lists[1]与lists[(K+1)/2+1]，lists[2]与
 * lists[(K+1)/2+2]....，lists[K/2-1]与
 * lists[K-1]。这样K个有序表就被组合成了K/2个有序表；
 * 第二轮循环后将减少为K/4个有序表；直到组合成一个具有N个元素的有序表。
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        
        if(lists == null || len == 0)
            return null;
        
        if(len == 1)
            return lists[0];
        
        //基於二分的思想來進行鏈表的兩兩組合
        while(len > 1) {
            int mid = (len + 1) / 2;
            for(int i = 0; i < len / 2; i ++) {
            	//合併左大半邊與右大半邊
                lists[i] = mergeList(lists[i], lists[mid + i]);
            }
            len = mid;
        }
        return lists[0];
    }
    
    //進行兩個鏈表的合併
    public ListNode mergeList(ListNode l1, ListNode l2) {
        if(l1 == null) 
            return l2;
        if(l2 == null)
            return l1;
        
        ListNode dummy = new ListNode(0); // 保存結果的鏈表，頭結點初始化
        ListNode head = dummy;
        
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                head.next = l1; //接入結果鏈表
                head = head.next; //移動指針
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        
        //把剩餘的鏈表接在後面
        if(l1 != null)
            head.next = l1;
        else
            head.next = l2;
        
        return dummy.next;
    }
    
}