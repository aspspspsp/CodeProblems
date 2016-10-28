package Easy;
import Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//此題與找尋最大深度不同的是
//最大深度為 max = 0
//最小深度為 min = Integer.max
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        
        //檢查是否一開始就為空
        if(root == null)
            return 0;
        
        //左右都沒有孩子表示為葉子節點，表示為最底層，最底層的深度為1
        if(root.left == null && root.right == null)
            return 1;
            
        //Integer.MAX_VALUE 為一個記號，表示此節點為空
        int minLeft = Integer.MAX_VALUE;
        int minRight = Integer.MAX_VALUE;
        
        //下面是避免對偏斜樹出現錯誤的答案ex:
        /*
            1           expect:2
           / \          wrong answer:1
         null 2
        */
        if(root.left != null) 
            minLeft = minDepth(root.left);
            
        if(root.right != null) 
            minRight = minDepth(root.right);
        
        //從左右兩子樹找到最小的深度
        return Math.min(minLeft, minRight) + 1;
    }
}