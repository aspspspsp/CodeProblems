package LeetCode.Medium;
import java.util.Stack;

import LeetCode.Dependencies.TreeNode;

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
    //�惦binary tree����A���stack(�������߅���������Ԫ��һ������С��)
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BinarySearchTreeIterator(TreeNode root) {
        //��ʼ����A��
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    //�z���Ƿ�����һ����С��ֵ�����Ǚz���@�Ø��Ƿ���
    public boolean hasNext() {
        if(stack.isEmpty() == false)
            return true;
        else
            return false;
    }

    /** @return the next smallest number */
    //ݔ����һ����Сֵ
    public int next() {
        //ݔ����Сֵ(�������)��Ҳ����Ŀǰ���L�Ĺ��c
        TreeNode node = stack.pop();
        
        //��Сֵ�Ĕ�
        int result = node.val;
        
        //��Ŀǰ���L�Ĺ��c�Ƶ��˹��c�����Ә���(Ҳ���ǰ��L��һ����Сֵ)
        if(node.right != null) {
            node = node.right;
            
            //�����Ә����A�������A��stack��
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        
        //ݔ���Y��
        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */