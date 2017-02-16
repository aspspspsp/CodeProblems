package Medium;

import java.util.HashMap;

import Dependencies.TreeNode;

/**
 * 题目大意：对于给出的一棵二叉树的前序遍历和中序遍历，还原这棵二叉树
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
preorder				inorder
       1                 4
      / \               / \
     2   5             2   6
    / \ / \           / \ / \
   3  4 6  7         1  3 5  7
 相信学过数据结构的同学应该都对这道题目有深刻的印象，虽然它是二叉树的题目，但是其更多使用到的还是分治的思想。
对于给定的前序遍历preorder和中序遍历inorder，首先我们不难发现，这棵树的根结点(root)其实就是preorder[0]。
由于preorder和inorder是对同一棵树的遍历，我们可以知道preorder[0]在inorder中一定也存在，
不妨设preorder[0]==inorder[k]。
由于inorder是中序遍历，所以k左边的就是根节点左子树的中序遍历、k右边的就是根节点右子树的中序遍历。
并且，由于我们已经知道了根节点左子树的节点数（与中序遍历长度相同），不妨设为l，
我们可以知道preorder从1到l+1就是根节点左子树的前序遍历，剩下的最后一部分就是根节点右子树的前序遍历。
也就是说，我们可以计算出左子树、右子树的前序遍历和中序遍历，从而可以用分治的思想，
将规模较大的问题分解成为两个较小的问题，然后递归的进行处理，还原左子树和右子树，
最后连通根节点一起组成一棵完整的树。
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {  
        if(preorder == null || inorder == null)  
            return null;  
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // 利用hashMap存儲根节点在inorder中的位置
        for(int i = 0; i < inorder.length; i++)  
        {  
            map.put(inorder[i],i);  
        }  
        
        return helper(preorder, 0, preorder.length - 1,
                      inorder, 0, inorder.length - 1, map);  
    }
    private TreeNode helper(int[] preorder, int preL, int preR,
                            int[] inorder, int inL, int inR,
                            HashMap<Integer, Integer> map)  
    {  
        if(preL > preR || inL > inR)  
            return null;
        
        // 设置目前的根节点
        TreeNode root = new TreeNode(preorder[preL]);
        // 找到目前根节点在inorder中的位置
        int index = map.get(root.val);
        
        // 分治处理两棵子树(利用前序與中序的位置來找到下一個root的位置)
        root.left = helper(preorder, preL + 1, index - inL + preL,
                           inorder, inL, index - 1,
                           map);  
        root.right = helper(preorder, preL + index - inL + 1, preR,
                            inorder, index + 1, inR,
                            map);  
        return root;  
    }  
    
}