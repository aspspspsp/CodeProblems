package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
        if(root == null)
            return new int[0]; //回傳[]
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int length = helper(root, map);
        
        Set<Integer> keys = map.keySet();
        
        int max_length = -1;
        List<Integer> res = new ArrayList<>();
        for(Integer key : keys) {
            int cur_length = map.get(key);
            if(cur_length > max_length) {
                max_length = cur_length;
                res.clear();
                res.add(key);
            } else if(cur_length == max_length) {
                res.add(key);
            }
        }
        
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i ++) {
            result[i] = res.get(i);
        }
        
        return result;
    }
    
    int helper(TreeNode root, HashMap<Integer, Integer> map) {
        if(root == null) {
            return 0;
        }
        
        int length = 0;
        length += 1;
        //左
        length += helper(root.left, map);
        //中
        if(map.get(root.val) == null)
            map.put(root.val, 1);
        else
            map.put(root.val, map.get(root.val) + 1);
        //右
        length += helper(root.right, map);
        
        return length;
    }
}