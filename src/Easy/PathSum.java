package Easy;

import Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 此題就是驗證某一個二叉樹是否有一條路徑的加總合乎要求
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return pathSum(root, 0, sum);
    }
    
    boolean pathSum(TreeNode root, int curSum, int sum) {
        //表示此節點為無效節點，加總起來絕對不會為sum
        if(root == null)
            return false;
        
        curSum = curSum + root.val;
        //若到樹葉節點，則檢查sum是否為預想的值
        if(root.left == null && root.right == null) {
            return curSum == sum;
        } else {
            //若是其他節點則繼續往該節點的左右節點進行拜訪
            //若左右子樹的加總其中一個合乎要求，代表整個子樹的是合法的，故用OR
            return pathSum(root.left, curSum, sum) || pathSum(root.right, curSum, sum);
        }
    }
}