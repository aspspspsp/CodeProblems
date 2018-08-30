package src.LeetCode.Medium;
import java.util.Stack;

import src.LeetCode.Dependencies.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BinarySearchTreeIterator {
    //存儲binary tree的左傾樹的stack(因為最左邊且最下面的元素一定是最小的)
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BinarySearchTreeIterator(TreeNode root) {
        //初始化左傾樹
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    //檢查是否有下一個最小的值，就是檢查這棵樹是否為空
    public boolean hasNext() {
        if(stack.isEmpty() == false)
            return true;
        else
            return false;
    }

    /** @return the next smallest number */
    //輸出下一個最小值
    public int next() {
        //輸出最小值(最上面的)，也就是目前拜訪的節點
        TreeNode node = stack.pop();
        
        //最小值的數
        int result = node.val;
        
        //將目前拜訪的節點移到此節點的右子樹上(也就是拜訪下一個最小值)
        if(node.right != null) {
            node = node.right;
            
            //將右子樹的左傾樹放入左傾樹stack中
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        
        //輸出結果
        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */