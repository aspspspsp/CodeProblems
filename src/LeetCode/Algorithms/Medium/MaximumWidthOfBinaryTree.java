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
        利用id來得到最大寬度

            1                        root=1
          2   3                  2=2*1, 3=2*1+1
         4 5 6 7         4=2*2, 5=2*2+1, 6=2*3, 7=2*3+1
    */
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;

        int depth = 0;
        int id = 0;

        int max_width = helper(root, depth, id, new HashMap<Integer, Integer>());

        return max_width;
    }

    int helper(TreeNode root, int depth, int id, Map<Integer, Integer> leftMost) {

        // 更新最左邊的id(當層)
        if(leftMost.containsKey(depth) == true) {
            int leftMostId = leftMost.get(depth);
            if(leftMostId > id) {
                leftMost.put(depth, id);
            }
        } else {
            leftMost.put(depth, id);
        }

        // 得到目前最大width (當前id - 最左id + 1)
        int max_width = id - leftMost.get(depth) + 1;

        // 從下一層得到最大width並做比較
        if(root.left != null) {
            // 左節點id = 2 * 當前id
            int leftId = 2 * id;
            max_width = Math.max(max_width,
                    helper(root.left, depth + 1, leftId, leftMost));
        }
        if(root.right != null) {
            // 右節點id = 2 * 當前id + 1
            int rightId = 2 * id + 1;
            max_width = Math.max(max_width,
                    helper(root.right, depth + 1, rightId, leftMost));
        }

        // 返回全局最大wdith
        return max_width;
    }
}
