package src.LeetCode.Algorithms.Easy;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        if(root == null)
            return 0;

        List<Integer> list = new ArrayList<>();

        // 中序歷遍取得有序數組
        helper(root, list);

        // 找到最小的差
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i ++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }

        return min;
    }

    void helper(TreeNode root, List<Integer> list) {
        if(root.left != null)
            helper(root.left, list);
        list.add(root.val);
        if(root.right != null)
            helper(root.right, list);
    }
}
