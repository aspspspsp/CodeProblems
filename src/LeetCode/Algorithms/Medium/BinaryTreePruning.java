package src.LeetCode.Algorithms.Medium;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        // 到葉節點下面則不做任何事(表示這個子樹已經歷遍完畢)
        if(root == null)
            return root;

        // 構造樹(由底向上構造樹)
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // 三種情況返回(由底向上構造樹)
        if(root.val == 1)
            return root;
        if(root.left != null)
            return root;
        if(root.right != null)
            return root;

        // 其他情況剪枝
        return null;
    }
}
