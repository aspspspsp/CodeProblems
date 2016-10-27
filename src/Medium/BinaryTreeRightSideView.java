package Medium;

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
 * 
 * 此題要點
 * 1.先逐層遍歷二叉樹
 * 2.將遍歷後的結果的最後一個元素(在最右邊)放入結果中
 */
public class BinaryTreeRightSideView {
    int current_layer;
    
    List<List<Integer>> temp = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null)
            return result;
            
        traversal(0, root);
        
        for(int i = 0; i < temp.size(); i ++) {
            List<Integer> cur_lv = temp.get(i);
            int right_int = cur_lv.get(cur_lv.size() - 1);
            result.add(right_int);
        }
        
        return result;
    }
    
    void traversal(int level, TreeNode root) {
        if(level >= temp.size())
        {
            temp.add(new ArrayList<Integer> ());
        }
        
        temp.get(level).add(root.val);
        
        if(root.left != null) {
            traversal(level + 1, root.left);
        }
        
        if(root.right != null) {
            traversal(level + 1, root.right);
        }
    }
}