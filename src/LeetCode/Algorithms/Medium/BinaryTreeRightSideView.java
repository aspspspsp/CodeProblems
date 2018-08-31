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
 *
 * 我們可以知道，右視圖是看這棵樹的右邊，若按照前序法來歷遍這棵樹，則是每一層歷遍的最後一個元素，依照這個思路
 * 我們可以得出下面步驟:
 * 1.歷遍這棵樹，然後將元素記錄在他所在的層
 * 2.歷遍我們記錄下來的每一層，印出最後一個元素
 * 求一棵二叉树的右视图。用BFS的方式遍历二叉树，取每层的最后一个节点。
 */
public class BinaryTreeRightSideView {
    int current_layer;

    //紀錄每一層的元素
    List<List<Integer>> temp = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        traversal(0, root);

        //將每一層最後一個元素取出，並保存結果
        for(int i = 0; i < temp.size(); i ++) {
            List<Integer> cur_lv = temp.get(i);
            int right_int = cur_lv.get(cur_lv.size() - 1);
            result.add(right_int);
        }
        
        return result;
    }

    //依照前序法來歷遍
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