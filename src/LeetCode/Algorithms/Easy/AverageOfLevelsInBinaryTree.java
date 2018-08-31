package src.LeetCode.Algorithms.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max_lv = helper(root, map, 0);
        
        for(int i = 0; i < max_lv; i ++) {
            double sum = 0;
            List<Integer> list = map.get(i);
            for(int j = 0; j < list.size(); j ++) {
                sum += list.get(j);
            }
            
            double average = (double)(sum / list.size());
            
            result.add(average);
        }
        return result;
    }
    
    int helper(TreeNode root, Map<Integer, List<Integer>> map, int cur_lv) {
        if(root == null)
            return cur_lv;
        
        int max_lv = 0;
        
        if(map.containsKey(cur_lv) == false) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(cur_lv, list);
        } else {
            List<Integer> list = map.get(cur_lv);
            list.add(root.val);
            map.put(cur_lv, list);
        }
        
        max_lv = Math.max(max_lv, helper(root.left, map, cur_lv + 1));
        max_lv = Math.max(max_lv, helper(root.right, map, cur_lv + 1));
        
        return max_lv;
    }
}
