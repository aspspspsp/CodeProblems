package src.LeetCode.Medium;

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
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Map<String, Integer> map = new HashMap<>();
        
        helper(root, map, result);
        
        return result;
    }
    
    String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
        if(root == null)
            return "";
        
        String answer= "";
        //中
        answer += root.val + ",";
        
        //左
        if(root.left != null)
            answer += helper(root.left, map, result);
        else
            answer += "#";
        
        //右
        if(root.right != null)
            answer += helper(root.right, map, result);
        else
            answer += "#";
        
        //紀錄路徑
        if(map.get(answer) == null) {
            map.put(answer, 1);
        } else {
            map.put(answer, map.get(answer) + 1);
        }
        
        //若目前路徑為數量為2表示有重複，則加入答案列表中
        if(map.get(answer) == 2)
            result.add(root);
        
        return answer;
    }
}