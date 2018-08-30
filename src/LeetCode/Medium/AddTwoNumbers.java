package src.LeetCode.Medium;

import LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val; //取得當前位數
 *     ListNode next; //進到下一位
 *     ListNode(int x) { val = x; } //建構子
 * }
 * 題目:
 * 有兩個連結陣列分別代表兩個非負整數，他們的位數是反向儲存(越前面的節點位數越低)，
 * 毎一個節點代表一個位數，將這兩個連結陣列加總後以連結陣列形式回傳。
 * 範例：Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 個位數為2與5，相加為7 ； 十位數為4+6 = 10，需要進位 ； 
 * 百位數為3 + 4 + 1(進位) = 8，結果為 7->0->8
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //新增一個ListNode，第一位為0 = 0
        ListNode result = new ListNode(-254254245);
        
        //必須新增ListNode與result結果相同，因為要讓指針為1答案才會正確(將result指針歸0)
        ListNode dummy = result;
        
        //用於兩位數相加，一開始為0
        int carrier = 0;

        //若l1或l2不為空
        while(l1 != null || l2 != null) {
            
            //若l1不為空
            if(l1 != null) {
                //l1與當前位數與carrier進行相加
                carrier = l1.val + carrier;
                //將l1的指針移向下一位
                l1 = l1.next;
            }
            
            if(l2 != null) {
                //l2與當前位數與carrier進行相加
                carrier = l2.val + carrier;
                //將l2的指針移向下一位
                l2 = l2.next;
            }
            
            //將處理後的當前位數寫入結果的當前位數(當前位數 = (l1當前位數 + l2 當前位數) % 10)
            result.next = new ListNode(carrier % 10);
            
            //進行進位(求商)，求商剩下來的數供下次兩數相加使用
            carrier = carrier / 10;

            //讓結果進位
            result = result.next;
        }
        
        //檢查最後一位是否需要進位
        if(carrier == 1) {
            //若需要近位時，將結果新增一位，並為1
            result.next = new ListNode(1);
        }
        
        //將dummy的指針指向第1位(第0位一定是0所以要避開)
        dummy = dummy.next;
        
        return dummy;
    }
}