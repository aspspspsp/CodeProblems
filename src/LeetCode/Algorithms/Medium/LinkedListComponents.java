package src.LeetCode.Algorithms.Medium;

import src.LeetCode.Algorithms.Dependencies.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {
/*
Scanning through the list, if node.val is in G and node.next.val isn't (including if node.next is null), then this must be the end of a connected component.

For example, if the list is 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7, and G = [0, 2, 3, 5, 7], then when scanning through the list, we fulfill the above condition at 0, 3, 5, 7, for a total answer of 4.
*/
    public int numComponents(ListNode head, int[] G) {

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < G.length; i ++) {
            set.add(G[i]);
        }

        int ans = 0;
        while (head != null) {
            if(set.contains(head.val) == true &&
                    (head.next == null || set.contains(head.next.val) == false))
                ans ++;

            head = head.next;
        }

        return ans;
    }
}
