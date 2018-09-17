package src.LeetCode.Algorithms.Medium;

import src.LeetCode.Algorithms.Dependencies.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {
/*
���y������A�p�G�ŦX�U�C�Ҧ�����:
1.��e���I���Ȧ��bG��
2.�U�@�Ӹ`�I���Ȥ��bG���Ϊ̤U�@�Ӹ`�I��null
�h��ܳo�Ӹ`�I���@�ӳs�q���q(connected component)�������C
�Ҧp�G
list:
0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
G:
[0, 2, 3, 5, 7]
���M�����I��A�ڭ̧��F�ŦX�W�z���󪺸`�I�p�U:
0, 3, 5, 7
�ҥH���׬�4
*/
    public int numComponents(ListNode head, int[] G) {

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < G.length; i ++) {
            set.add(G[i]);
        }

        int ans = 0;
        while (head != null) {
            // �ˬd�O�_�ŦX����A�O����+1
            if(set.contains(head.val) == true &&
                    (head.next == null || set.contains(head.next.val) == false))
                ans ++;

            // ���ʫ��w
            head = head.next;
        }

        return ans;
    }
}
