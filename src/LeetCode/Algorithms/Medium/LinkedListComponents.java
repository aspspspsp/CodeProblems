package src.LeetCode.Algorithms.Medium;

import src.LeetCode.Algorithms.Dependencies.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {
/*
掃描整個鍊表，如果符合下列所有條件:
1.當前結點的值有在G當中
2.下一個節點的值不在G中或者下一個節點為null
則表示這個節點為一個連通分量(connected component)的結尾。
例如：
list:
0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
G:
[0, 2, 3, 5, 7]
歷遍完結點後，我們找到了符合上述條件的節點如下:
0, 3, 5, 7
所以答案為4
*/
    public int numComponents(ListNode head, int[] G) {

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < G.length; i ++) {
            set.add(G[i]);
        }

        int ans = 0;
        while (head != null) {
            // 檢查是否符合條件，是的話+1
            if(set.contains(head.val) == true &&
                    (head.next == null || set.contains(head.next.val) == false))
                ans ++;

            // 移動指針
            head = head.next;
        }

        return ans;
    }
}
