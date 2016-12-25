package Easy;

import Dependencies.ListNode;
import Dependencies.TreeNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertSortedListToBinarySearchTree {
    //這棵樹的最上面節點
    ListNode visitedListNode;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        
        //
        visitedListNode = head;
        
        //找到List node的長度
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            len ++;
            temp = temp.next;
        }
        
        //利用二分法來構建BST
        TreeNode treeTop = constructBST(0, len - 1);
        return treeTop;
    } 
    
    // build tree bottom-up
    TreeNode constructBST(int start, int end) {
        if(start > end) {
            return null;
        }
        
        //先找出此區間的中間點
        int middle = (start + end) / 2;
        
        //*****自頂向上構建樹(左(小) -> 中 -> 右(大))*****
        //因為要維持每次遞歸都要按照小中大的次序，故小結點要第一個做
        //找出子樹的左子樹(構建左BST -- 小)
        TreeNode left = constructBST(start, middle - 1);
        //因為要維持每次遞歸都要按照小中大的次序，故中結點要第二個做
        //將目前拜訪的節點構建一個樹節點(中)
        TreeNode root = new TreeNode(visitedListNode.val);
        visitedListNode = visitedListNode.next;
        //因為要維持每次遞歸都要按照小中大的次序，故大結點要第三個做
        //找出子樹的右子樹(構建右BST -- 大)
        TreeNode right = constructBST(middle + 1, end);
        
        //將左右子樹與之前建構的樹節點連接
        root.left = left;
        root.right = right;
        
        return root;
    }
}