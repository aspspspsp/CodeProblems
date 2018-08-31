package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.List;

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
/*
i=0, count[0]=1 //empty tree
--------------------------------------------
i=1, count[1]=1 //one tree
--------------------------------------------
i=2, count[2]=count[0]*count[1] // 0 is root
            + count[1]*count[0] // 1 is root
--------------------------------------------
i=3, count[3]=count[0]*count[2] // 1 is root
            + count[1]*count[1] // 2 is root
            + count[2]*count[0] // 3 is root
--------------------------------------------
i=4, count[4]=count[0]*count[3] // 1 is root
            + count[1]*count[2] // 2 is root
            + count[2]*count[1] // 3 is root
            + count[3]*count[0] // 4 is root
..
..
..

i=n, count[n] = sum(count[0..k]*count[k+1...n]) 0 <= k < n-1
*/
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if(n == 0)
            return result;
        
        return helper(1, n);
    }
    
    public List<TreeNode> helper(int m, int n) {
        List<TreeNode> result = new ArrayList<>();
        if(m > n) {
            result.add(null);
            return result;
        }
        
        for(int i = m; i <= n; i ++) {
            List<TreeNode> ls = helper(m, i - 1);
            List<TreeNode> rs = helper(i + 1, n);
            for(TreeNode l : ls) {
                for(TreeNode r : rs) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = l;
                    curr.right = r;
                    result.add(curr);
                }
            }
        }
        
        return result;
    }
}