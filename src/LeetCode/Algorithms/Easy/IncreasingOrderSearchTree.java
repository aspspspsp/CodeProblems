package src.LeetCode.Algorithms.Easy;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        if(root == null)
            return new TreeNode(0);

        // �����Ǿ��M�A���o�Ҧ�����(�ɧ�)
        List<Integer> temp = new ArrayList<>();
        helper(root, temp);

        // �}�l�c�y����BST
        TreeNode result = new TreeNode(temp.get(0)); // �n��^�����G����
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
