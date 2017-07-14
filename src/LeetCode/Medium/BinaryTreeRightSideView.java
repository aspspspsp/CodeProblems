package LeetCode.Medium;

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
 * 
 * ���}Ҫ�c
 * 1.�����ӱ�v�����
 * 2.����v��ĽY��������һ��Ԫ��(������߅)����Y����
 * 求一棵二叉树的右视图。用BFS的方式遍历二叉树，取每层的最后一个节点。
 */
public class BinaryTreeRightSideView {
    int current_layer;
    
    List<List<Integer>> temp = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null)
            return result;
            
        traversal(0, root);
        
        for(int i = 0; i < temp.size(); i ++) {
            List<Integer> cur_lv = temp.get(i);
            int right_int = cur_lv.get(cur_lv.size() - 1);
            result.add(right_int);
        }
        
        return result;
    }
    
    void traversal(int level, TreeNode root) {
        if(level >= temp.size())
        {
            temp.add(new ArrayList<Integer> ());
        }
        
        temp.get(level).add(root.val);
        
        if(root.left != null) {
            traversal(level + 1, root.left);
        }
        
        if(root.right != null) {
            traversal(level + 1, root.right);
        }
    }
}