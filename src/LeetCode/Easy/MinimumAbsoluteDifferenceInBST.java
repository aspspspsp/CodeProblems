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
public class MinimumAbsoluteDifferenceInBST {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        if(root == null)
            return min;
        
        List<Integer> elements = new ArrayList<>();
        helper(root, elements);
        //將得到的有序序列進行最小差的歷遍
        for(int i = 0; i < elements.size() - 1; i ++) {
            //計算差
            int curMin = Math.abs(elements.get(i + 1) - elements.get(i));
            min = Math.min(curMin, min);
        }
        return min;
    }
    
    //中序歷遍
    void helper(TreeNode root, List<Integer> elements) {
        if(root == null)
            return;
        
        helper(root.left, elements);
        elements.add(root.val);
        helper(root.right, elements);
    }
}