package src.LeetCode.Algorithms.Medium;

import src.LeetCode.Algorithms.Dependencies.TreeLinkNode;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
同之前的简化版本不同，本题的区别在于二叉树并不完整
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        TreeLinkNode tem = root.next;
        
        //找到需要與目前節點連接的右邊子樹的節點(或在當前節點的右邊節點)
        while(tem != null) {
            if(tem.left != null) {
                tem = tem.left;
                break;
            } else if(tem.right != null) {
                tem = tem.right;
                break;
            }
            
            //沒找到則往右邊找
            tem = tem.next;
        }
        
        //若當前節點有右子節點，則連接
        if(root.right != null) {
            root.right.next = tem;
        }
        
        //若當前節點有左子節點，則連接(左邊子節點要做的處理比較多)
        if(root.left != null) {
            if(root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = tem;
            }
        }
        
        //先歷遍左再歷遍右
        connect(root.right);
        connect(root.left);
    }
}