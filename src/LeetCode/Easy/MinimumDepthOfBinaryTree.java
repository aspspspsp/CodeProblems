package src.LeetCode.Easy;
import src.LeetCode.Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//歷遍整棵樹，然後到最末節點返回深度，再選擇一個最小的深度，即可
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        //處理例外情況
        if(root == null)
            return 0;

        int minimum_depth = helper(root, 1);
        return minimum_depth;
    }

    int helper(TreeNode root, int curDepth) {
        //若已經是最末節點，則返回深度
        if(root.left == null && root.right == null)
            return curDepth;

        //紀錄最大深度
        int left_depth = Integer.MAX_VALUE;
        int right_depth = Integer.MAX_VALUE;

        //若左邊有子節點則繼續歷遍，並且返回得到左邊子樹的最淺深度
        if(root.left != null)
            left_depth = helper(root.left, curDepth + 1);

        //若右邊有子節點則繼續歷遍，並且返回得到左邊子樹的最淺深度
        if(root.right != null)
            right_depth = helper(root.right, curDepth + 1);

        int minimum_depth = Math.min(left_depth, right_depth);

        //返回最小深度
        return minimum_depth;
    }
}