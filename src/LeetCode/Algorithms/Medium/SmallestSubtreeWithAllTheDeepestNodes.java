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

    // Pair<��e�̤j�`��, ��e�`�I>
    Pair<Integer, TreeNode> helper(TreeNode root) {
        // �Y�O���l�`�I�A�h��^�ۤv�A�M��`�׬�0
        if(root.left == null && root.right == null) {
            Pair<Integer, TreeNode> leafNodePair =
                    new Pair<Integer, TreeNode>(0, root);

            return leafNodePair;
        }

        // ���M���k�l��
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
        // ���k�l��`�פ@�ˡA��^��e���I
        if(leftDepth > -1 && rightDepth > -1 && leftDepth == rightDepth) {
            curNodePair =
                    new Pair<Integer, TreeNode>(leftDepth + 1, root);

            // ���l��`�׸��j�A�h��^���l��`�I(�H�Υ��l�𪺳̤j�`��)
        } else if(leftDepth > -1 && leftDepth > rightDepth) {
            curNodePair =
                    new Pair<Integer, TreeNode>(leftDepth + 1, leftPair.getValue());

            // �k�l��`�׸��j�A�h��^�k�l��`�I(�H�Υk�l�𪺳̤j�`��)
        } else if(rightDepth > -1 && leftDepth < rightDepth) {
            curNodePair =
                    new Pair<Integer, TreeNode>(rightDepth + 1, rightPair.getValue());
        }

        return curNodePair;
    }
}
