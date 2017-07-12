package LeetCode.Easy;

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
 
 /*
 本题的不同点是path可以不从root开始，不到leaf结束。但由于可以存在负数节点，所以没法通过比较大小来缩进节点，
 所以我们就只能考虑从每一个节点开始的情况。
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        
        //因為要考慮每個路徑(不一定從root開始)，
        //故要對最上面的3個點分別進行拜訪
        int pathCount = visitPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return pathCount;
    }
    
    public int visitPath(TreeNode root, int sum) 
    {
        if(root == null)
            return 0;
        
        int pathCount = 0;
        if(root.val == sum)
            pathCount ++;
        
        //目前路徑數 = 左子樹路徑數 + 右子樹路徑數
        pathCount = pathCount + visitPath(root.left, sum - root.val) + visitPath(root.right, sum - root.val);
        return pathCount;
    }
}