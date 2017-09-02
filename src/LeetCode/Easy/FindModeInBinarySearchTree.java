package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class FindModeInBinarySearchTree {
    public int[] findMode(TreeNode root) {
        if(root == null) {
            int[] result = new int[0];
            return result;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        
        List<Integer> res = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max)
                res.add(entry.getKey());
        }
        
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i ++) {
            result[i] = res.get(i);
        }
        
        return result;
    }
    
    int max = 0;
    void helper(TreeNode root, Map<Integer, Integer> map) {
        if(root == null)
            return;
        
        int cur = root.val;
        
        if(map.containsKey(cur) == true)
            map.put(cur, map.get(cur) + 1);
        else
            map.put(cur, 1);
        
        if(map.get(cur) > max)
            max = map.get(cur);
        
        helper(root.left, map);
        helper(root.right, map);
    }
}
