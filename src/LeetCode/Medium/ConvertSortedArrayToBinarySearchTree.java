package LeetCode.Medium;
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
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null)
            return null;
            
        int start = 0;
        int end = nums.length - 1;
        return buildTree(nums, start, end);
    }
    
    TreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        
        //將目前拜訪的值放入目前的樹節點中
        int curNodeIndex = (start + end) / 2;
        int curNodeVal = nums[curNodeIndex];
        TreeNode treeNode = new TreeNode(curNodeVal);
        
        //建立左子樹
        int leftEnd = curNodeIndex - 1;//�����������g
        treeNode.left = buildTree(nums, start, leftEnd);
        
        //建立右子樹
        int rightStart = curNodeIndex + 1;//�����������g
        treeNode.right = buildTree(nums, rightStart, end);
        
        return treeNode;
    }
}