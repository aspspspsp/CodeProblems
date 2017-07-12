package LeetCode.Easy;

import LeetCode.Dependencies.ListNode;
import LeetCode.Dependencies.TreeNode;

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
        
        //*****自頂向上構建樹(左中右)*****
        //找出子樹的左子樹(構建左BST)
        TreeNode left = constructBST(start, middle - 1);
        //將目前拜訪的節點構建一個樹節點(中)
        TreeNode root = new TreeNode(visitedListNode.val);
        visitedListNode = visitedListNode.next;
        //找出子樹的右子樹(構建右BST)
        TreeNode right = constructBST(middle + 1, end);
        
        //將左右子樹與之前建構的樹節點連接
        root.left = left;
        root.right = right;
        
        return root;
    }
}