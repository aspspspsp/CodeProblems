package src.LeetCode.Algorithms.Easy;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;

        // 取得root1的葉子序列
        List<Integer> seq1 = new ArrayList<>();
        helper(root1, seq1);

        // 取得root2的葉子序列
        List<Integer> seq2 = new ArrayList<>();
        helper(root2, seq2);

        // 比較root1與root2的葉子序列是否相同
        if(seq1.size() != seq2.size())
            return false;
        for(int i = 0; i < seq1.size(); i ++) {
            if(seq1.get(i) != seq2.get(i))
                return false;
        }

        return true;
    }

    void helper(TreeNode root, List<Integer> seq) {
        // 歷遍到葉子時，則添加該節點的值
        if(root.left == null && root.right == null) {
            seq.add(root.val);
        }

        if(root.left != null)
            helper(root.left, seq);
        if(root.right != null)
            helper(root.right, seq);
    }
}
