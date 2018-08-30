package src.LeetCode.Medium;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

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
public class FindLargestValueInEachTreeRow {
    //維護一個最大層數
    int max_level = 0;
    
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        helper(map, 0, root);
        
        //建立答案
        for(int i = 0; i <= max_level; i ++) {
            int cur_level_max = map.get(i);
            result.add(cur_level_max);
        }
        return result;
    }
    
    /**
        @para
        map: 維護每層中最大的數, key:level, value:每層中最大的數
        level: 目前層數
        root: 目前拜訪節點
    **/
    void helper(HashMap<Integer, Integer> map, int level, TreeNode root) {
        if(root == null)
            return;
        
        //維護目前最大層數
        if(max_level < level) {
            max_level = level;
        }
        
        //若這層是新拜訪的，則新增這一層
        if(map.get(level) == null) {
            map.put(level, root.val);
        }
        //反之則比較目前節點與之前這一層最大的值
        else {
            int curLevelMaxInt = map.get(level);
            if(curLevelMaxInt < root.val) {
                map.put(level, root.val);
            }
        }
        
        //拜訪左子樹
        if(root.left != null) {
            helper(map, level + 1, root.left);
        }
        
        //拜訪右子樹
        if(root.right != null) {
            helper(map, level + 1, root.right);
        }
    }
}
