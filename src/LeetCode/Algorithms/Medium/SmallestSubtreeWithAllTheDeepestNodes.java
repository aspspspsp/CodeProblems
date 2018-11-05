package src.LeetCode.Algorithms.Medium;
import javafx.util.Pair;
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
public class SmallestSubtreeWithAllTheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null)
            return root;

        Pair<Integer, TreeNode> result = helper(root);

        return result.getValue();
    }

    // Pair<當前最大深度, 當前節點>
    Pair<Integer, TreeNode> helper(TreeNode root) {
        // 若是葉子節點，則返回自己，然後深度為0
        if(root.left == null && root.right == null) {
            Pair<Integer, TreeNode> leafNodePair =
                    new Pair<Integer, TreeNode>(0, root);

            return leafNodePair;
        }

        // 歷遍左右子樹
        Pair<Integer, TreeNode> leftPair = null;
        Pair<Integer, TreeNode> rightPair = null;
        if(root.left != null)
            leftPair = helper(root.left);

        if(root.right != null)
            rightPair = helper(root.right);

        int leftDepth = -1;
        if(root.left != null)
            leftDepth = leftPair.getKey();

        int rightDepth = -1;
        if(root.right != null)
            rightDepth = rightPair.getKey();

        Pair<Integer, TreeNode> curNodePair = null;
        // 左右子樹深度一樣，返回當前結點
        if(leftDepth > -1 && rightDepth > -1 && leftDepth == rightDepth) {
            curNodePair =
                    new Pair<Integer, TreeNode>(leftDepth + 1, root);

            // 左子樹深度較大，則返回左子樹節點(以及左子樹的最大深度)
        } else if(leftDepth > -1 && leftDepth > rightDepth) {
            curNodePair =
                    new Pair<Integer, TreeNode>(leftDepth + 1, leftPair.getValue());

            // 右子樹深度較大，則返回右子樹節點(以及右子樹的最大深度)
        } else if(rightDepth > -1 && leftDepth < rightDepth) {
            curNodePair =
                    new Pair<Integer, TreeNode>(rightDepth + 1, rightPair.getValue());
        }

        return curNodePair;
    }
}
