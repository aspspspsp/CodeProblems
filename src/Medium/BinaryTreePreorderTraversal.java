package Medium;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * The key is using a stack to store left and right children, and push right child first so that it is processed after the left child.
 * 這題考的是前序遍歷一顆tree
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        //結果list
        List<Integer> ans = new ArrayList<Integer>();
        
        //若root為null表示一開始為空
        if(root == null)
            return ans;
        
        //新增一個stack存放暫存結果(ㄇ)
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        //將root放入stack表示root先訪問
        stack.push(root);
        
        while(stack.empty() == false) {
            //將目前經歷的節點排出
            TreeNode node = stack.pop();
            
            //將目前經歷的節點放入結果lost內
            ans.add(node.val);
            
            //將右節點放入stack(右節點先訪問)
            if(node.right != null) {
                stack.push(node.right);
            }
            
            //將右節點放入stack(左節點再訪問)
            if(node.left != null) {
                stack.push(node.left);
            }
            
        }
        
        //返回答案
        return ans;
    }
}