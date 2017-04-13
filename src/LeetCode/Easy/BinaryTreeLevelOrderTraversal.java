package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

import LeetCode.Dependencies.TreeNode;

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
        
        //�Ӕ�, 픹��c
        traversal(0, root);
        
        return result;
    }
    
    public void traversal(int level, TreeNode root) {
        //����һ��
        if(level >= result.size()) {
            result.add(new ArrayList<Integer>());
        }
        
        //����get�õ�Ŀǰ����v�ČӔ�
        result.get(level).add(root.val);
        
        //��v��
        if(root.left != null)
            traversal(level + 1, root.left);
        
        //�Қv��
        if(root.right != null)
            traversal(level + 1, root.right);
    }
}