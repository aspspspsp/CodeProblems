package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

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
public class BinaryTreePaths {
    List<String> answer = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
       
        if(root == null)
            return answer;
        
        //���Lroot���c
        findBinaryTreePaths(root, String.valueOf(root.val));

        return answer;
    }
    
    public void findBinaryTreePaths(TreeNode root, String path) {
        //��ԓ���c�ă�߅���]���ӹ��c�r�t��ʾ����K�~�ӹ��c�ˣ��t�����
        if(root.left == null && root.right == null)
            answer.add(path);
        //���L��߅
        if(root.left != null)
            findBinaryTreePaths(root.left, path + "->" + root.left.val);
        
        //���L��߅
        if(root.right != null)
            findBinaryTreePaths(root.right, path + "->" + root.right.val);
        
    }
}