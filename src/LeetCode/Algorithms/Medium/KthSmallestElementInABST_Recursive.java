package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.List;
import src.LeetCode.Algorithms.Dependencies.TreeNode;
/**
 * 利用中序歷遍即可得到第k小的元素，經過k次歷遍過程，返回答案即可
 */
public class KthSmallestElementInABST_Recursive {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;

        List<TreeNode> list = new ArrayList<>();
        helper(root, list);

        int result = list.get(k - 1).val;

        return result;
    }

    void helper(TreeNode root, List<TreeNode> list) {
        if(root.left != null)
            helper(root.left, list);
        list.add(root);
        if(root.right != null)
            helper(root.right, list);
    }
}
