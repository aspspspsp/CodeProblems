package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null)
            return result;
            
        Stack<TreeNode> stack = new Stack<>();
        
        //׷ۙĿǰ���L�Ĺ��c(ÿһ�ΰ��L�Ә䶼��׷ۙ������߅������Ĺ��c)
        TreeNode cur = root;
        
        while(stack.isEmpty() == false || cur != null) {
            //��Ŀǰ���c����գ��t����stack��Ȼ���^�m�����Ә���L(����)
            //**�󵽵�**
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            /*
            ��Ŀǰ���c���(�ѽ����L��Ŀǰ�Ә����������)
            �t�Ȍ�֮ǰ�İ��L�^�Ĺ��c�����ό��Ƴ�(tmp)��Ȼ���ٌ���(tmp)��ֵ����Y����
            Ȼ���ٰ��L��(tmp)���ҹ��c
            ��->��
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