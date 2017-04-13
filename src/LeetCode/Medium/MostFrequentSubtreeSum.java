package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
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
public class MostFrequentSubtreeSum {
  /*
    5       子樹為:2,-3,  5      故子樹和為[2, -3, 4]
   / \                   / \
  2  -3                 2  -5
  */
    HashMap<Integer, Integer> sums = new HashMap<Integer, Integer>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        int[] res;
        if(root == null) {
            res = new int[0];
            return res;
        }
        
        helper(root);
        
        //找到最大出現次數的子樹和
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> entry: sums.entrySet()) {
            int val = entry.getValue();
            int key = entry.getKey();
            if(max == val) {
                result.add(key);
            }
        }
        
        //輸出子樹和
        res = new int[result.size()];
        for(int i = 0; i < result.size(); i ++) {
            res[i] = result.get(i);
        }
        
        return res;
    }
    
    //窮舉所有子樹
    int helper(TreeNode root) {
        if(root == null)
            return 0;
        
        int val = root.val + helper(root.left) + helper(root.right);
        
        //對該子樹的和加入map
        if(sums.containsKey(val) == false) {
            sums.put(val, 1);
        } else {
            sums.put(val, sums.get(val) + 1);
        }
        
        if(max < sums.get(val))
            max = sums.get(val);
            
        return val;
    }
}