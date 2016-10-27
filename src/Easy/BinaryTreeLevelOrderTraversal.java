package Easy;

import java.util.ArrayList;
import java.util.List;

import Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return result;
        
        //層數, 頂節點
        traversal(0, root);
        
        return result;
    }
    
    public void traversal(int level, TreeNode root) {
        //增加一層
        if(level >= result.size()) {
            result.add(new ArrayList<Integer>());
        }
        
        //利用get得到目前所遍歷的層數
        result.get(level).add(root.val);
        
        //左歷遍
        if(root.left != null)
            traversal(level + 1, root.left);
        
        //右歷遍
        if(root.right != null)
            traversal(level + 1, root.right);
    }
}