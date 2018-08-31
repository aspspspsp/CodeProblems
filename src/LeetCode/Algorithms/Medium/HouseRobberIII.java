package src.LeetCode.Algorithms.Medium;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        //深度优先遍历二叉树，每次遍历返回两个值：分别表示偷窃或者不偷窃当前节点可以获得的最大收益。
        int[] result = {0, 0}; //紀錄有偷root, 紀錄沒有偷root
        
        result = helper(root);
        
        return Math.max(result[0], result[1]);
    }
    
    /**
    @ root: 目前節點
    return: 目前最大結果{有偷root,沒有偷root}
    **/
    int[] helper(TreeNode root) {
        int[] tmp_result = {0, 0}; //預設都為0
        if(root == null)
            return tmp_result;
        
        //偷竊左邊與右邊的最大成果
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        //有偷root，並偷下下一層
        tmp_result[0] = root.val + left[1] + right[1];
        
        //沒有投root，只偷左右子樹
        tmp_result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return tmp_result;
    }
}