package LeetCode.Medium;

import LeetCode.Dependencies.TreeLinkNode;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        
        
        //連接同子樹下的左右節點
        if(root.left != null) {
            root.left.next = root.right;
        }
        
        //連接同層，但不同子樹的節點
        if(root.right != null) {
            if(root.next != null){
                root.right.next = root.next.left;
            }
        }
        
        //繼續做下去
        connect(root.left);
        connect(root.right);
    }
}
