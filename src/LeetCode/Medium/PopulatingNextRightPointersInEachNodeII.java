package LeetCode.Medium;

import LeetCode.Dependencies.TreeLinkNode;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
同之前的简化版本不同，本题的区别在于二叉树并不完整，之前算法中可以
将当前结点的右子结点与下一结点的左子结点相连的方法失效。因此这里选
用广度优先遍历，引入“层”的概念，需要储存两个值：
   1.遍历的当前结点
   2.本层上一个非空的结点(prev)
由于寻找遍历的下一个结点需要使用父层的next指针，因此算法设计为遍历
当前结点时完成三件事：
  1.如果左子结点存在，则更新prev的next指向左子结点
  2.如果右子结点存在，则更新左子结点(或prev)的next指向右子结点
  3.下一次循环的当前结点设定为父节点的next的孩子
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        TreeLinkNode tem = root.next;
        
        //找到需要與目前節點連接的右邊子樹的節點(或在當前節點的右邊節點)
        while(tem != null) {
            if(tem.left != null) {
                tem = tem.left;
                break;
            } else if(tem.right != null) {
                tem = tem.right;
                break;
            }
            
            //沒找到則往右邊找
            tem = tem.next;
        }
        
        //若當前節點有右子節點，則連接
        if(root.right != null) {
            root.right.next = tem;
        }
        
        //若當前節點有左子節點，則連接(左邊子節點要做的處理比較多)
        if(root.left != null) {
            if(root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = tem;
            }
        }
        
        //先歷遍左再歷遍右
        connect(root.right);
        connect(root.left);
    }
}