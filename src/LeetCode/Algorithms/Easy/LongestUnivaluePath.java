package src.LeetCode.Algorithms.Easy;

import src.LeetCode.Algorithms.Dependencies.TreeNode;
/*
¸Ô¸Ñ¬ÝµøÀW
https://www.youtube.com/watch?v=yX1hVhcHcH8
 */
public class LongestUnivaluePath {
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root);

        return ans;
    }

    int dfs(TreeNode root) {
        if(root == null)
            return 0;

        int l = dfs(root.left);
        int r = dfs(root.right);

        int pl = 0;
        int pr = 0;
        if(root.left != null && root.val == root.left.val)
            pl = l + 1;

        if(root.right != null && root.val == root.right.val)
            pr = r + 1;

        ans = Math.max(ans, pl + pr);

        return Math.max(pl, pr);
    }
}
