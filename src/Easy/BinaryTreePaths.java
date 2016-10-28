package Easy;

import java.util.ArrayList;
import java.util.List;

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
public class BinaryTreePaths {
    List<String> answer = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
       
        if(root == null)
            return answer;
        
        //拜訪root節點
        findBinaryTreePaths(root, String.valueOf(root.val));

        return answer;
    }
    
    public void findBinaryTreePaths(TreeNode root, String path) {
        //若該節點的兩邊都沒有子節點時則表示到最終葉子節點了，則放入答案
        if(root.left == null && root.right == null)
            answer.add(path);
        //拜訪左邊
        if(root.left != null)
            findBinaryTreePaths(root.left, path + "->" + root.left.val);
        
        //拜訪右邊
        if(root.right != null)
            findBinaryTreePaths(root.right, path + "->" + root.right.val);
        
    }
}