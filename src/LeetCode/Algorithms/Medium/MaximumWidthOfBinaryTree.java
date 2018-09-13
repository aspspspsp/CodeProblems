package src.LeetCode.Algorithms.Medium;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaximumWidthOfBinaryTree {
    /*
        ノidㄓ眔程糴

            1                        root=1
          2   3                  2=2*1, 3=2*1+1
         4 5 6 7         4=2*2, 5=2*2+1, 6=2*3, 7=2*3+1

         程糴=7-4+1=4
    */
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;

        int depth = 0;
        int id = 0;

        int max_width = helper(root, depth, id, new HashMap<Integer, Integer>(), new HashMap<Integer, Integer>());

        return max_width;
    }

    int helper(TreeNode root, int depth, int id,
               Map<Integer, Integer> leftMost, Map<Integer, Integer> rightMost) {

        // 穝程オ娩id(讽糷)
        if(leftMost.containsKey(depth) == true) {
            int leftMostId = leftMost.get(depth);
            if(leftMostId > id) {
                leftMost.put(depth, id);
            }
        } else {
            leftMost.put(depth, id);
        }

        // 穝程娩id(讽糷)
        if(rightMost.containsKey(depth) == true) {
            int rightMostId = rightMost.get(depth);
            if(rightMostId < id) {
                rightMost.put(depth, id);
            }
        } else {
            rightMost.put(depth, id);
        }

        // 眔讽糷程width (程id - 程オid + 1)
        int max_width = rightMost.get(depth) - leftMost.get(depth) + 1;

        // 眖糷眔程width暗ゑ耕
        if(root.left != null) {
            // オ竊翴id = 2 * 讽玡id
            int leftId = 2 * id;
            max_width = Math.max(max_width,
                    helper(root.left, depth + 1, leftId, leftMost, rightMost));
        }
        if(root.right != null) {
            // 竊翴id = 2 * 讽玡id + 1
            int rightId = 2 * id + 1;
            max_width = Math.max(max_width,
                    helper(root.right, depth + 1, rightId, leftMost, rightMost));
        }

        // Ы程wdith
        return max_width;
    }
}
