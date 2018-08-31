package src.LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

import src.LeetCode.Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PrintBinaryTree {
    /*
    依旧递归，先计算树的深度，先把List的空填满，接着对于每一个结点都安排在区间的中间即可。
    */
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        
        if(root == null)
            return ans;
        
        int max_depth = getMaxDepth(root);
        int size = (1 << max_depth) - 1;
        
        for(int i = 0; i < max_depth; i ++) {
            ans.add(new ArrayList<>());
            for(int j = 0; j < size; j ++) {
                ans.get(i).add("");
            }
        }
        helper(ans, root, 0, 0, size);
        return ans;
    }
    
    void helper(List<List<String>> ans, TreeNode root, int depth, int left, int right) {
        if(root == null)
            return;
        
        int mid = (left + right) / 2;
        
        ans.get(depth).set(mid, root.val + "");
        
        helper(ans, root.left, depth + 1, left, mid - 1);
        helper(ans, root.right, depth + 1, mid + 1, right);
    }
    
    //取得數的最大深度
    int getMaxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = getMaxDepth(root.left) + 1;
        int right = getMaxDepth(root.right) + 1;
        
        int max_depth = Math.max(left, right);
        
        return max_depth;
    }
}