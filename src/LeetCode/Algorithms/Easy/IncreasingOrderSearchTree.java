package src.LeetCode.Algorithms.Easy;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        if(root == null)
            return new TreeNode(0);

        // 先中序歷遍，取得所有元素(升序)
        List<Integer> temp = new ArrayList<>();
        helper(root, temp);

        // 開始構造偏斜BST
        TreeNode result = new TreeNode(temp.get(0)); // 要返回的結果指標
        TreeNode cur = result;
        for(int i = 1; i < temp.size(); i ++) {
            cur.right = new TreeNode(temp.get(i));
            cur = cur.right;
        }

        return result;
    }

    void helper(TreeNode root, List<Integer> temp) {
        if(root.left != null)
            helper(root.left, temp);

        temp.add(root.val);

        if(root.right != null)
            helper(root.right, temp);
    }
}
