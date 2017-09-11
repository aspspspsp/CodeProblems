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
public class TwoSumIV_InputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)
            return false;
        
        //利用中序歷遍來得到有序數組
        List<Integer> elements = new ArrayList<Integer>();
        helper(root, elements);
        
        //若elements只有一個元素，則不滿足two sum的性質，則返回false
        if(elements.size() < 2)
            return false;
        
        //一般two sum解法
        for(int i = 0; i < elements.size(); i ++) {
            for(int j = i + 1; j < elements.size(); j ++) {
                if(elements.get(i) + elements.get(j) == k)
                    return true;
            }
        }
        
        return false;
    }
    
    void helper(TreeNode root, List<Integer> elements) {
        if(root == null)
            return;
        
        helper(root.left, elements);
        elements.add(root.val);
        helper(root.right, elements);
    }
}