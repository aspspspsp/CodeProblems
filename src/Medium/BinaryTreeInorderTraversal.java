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
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null)
            return result;
            
        Stack<TreeNode> stack = new Stack<>();
        
        //追蹤目前拜訪的節點(每一次拜訪子樹都會追蹤到最左邊最下面的節點)
        TreeNode cur = root;
        
        while(stack.isEmpty() == false || cur != null) {
            //若目前節點不為空，則壓入stack，然後繼續向左子樹拜訪(先左)
            //**左到底**
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            /*
            若目前節點為空(已經拜訪到目前子樹的最左最下)
            則先將之前的拜訪過的節點的最上層推出(tmp)，然後再將它(tmp)的值放入結果，
            然後再拜訪它(tmp)的右節點
            中->右
            */
            } else if(cur == null){
                TreeNode tmp = stack.pop();
                result.add(tmp.val);
                cur = tmp.right;
            }
        }
        
        return result;
    }
}