package Medium;

import Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * 根结点:root
 * 左子树:lt
 * 右子树:rt
 * 最右子结点:x
 * 从root找lt中的x，将root的rt接到x的右子树上（x的右子树为空），root的左子树整体调整为右子树，root的左子树赋空。 
 */
public class FlattenBinaryTreeToLinkedList {
    //紀錄上一個經歷的最後一個節點
    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        //處理特殊情況
        if(root == null) {
            return;
        }
        
        //將最後一個節點的下一個節點(目前節點)從左移至右
        if(lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }
        
        //經過上一個步驟後，再繼續往下一層
        lastNode = root;
        
        //必須使用此種歷遍方式做垃圾回收，不然會報錯
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        //將左子樹做一樣的處理
        flatten(left);
        
        //將右子樹做一樣的處理
        flatten(right);
    }
}