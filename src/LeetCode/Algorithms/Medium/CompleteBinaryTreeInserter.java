package src.LeetCode.Algorithms.Medium;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

public class CompleteBinaryTreeInserter {
    TreeNode root = null;
    int lastNodeNo = 0;
    public CompleteBinaryTreeInserter(TreeNode root) {
        if(root == null)
            return;

        this.root = root;
        // 找到最後一個元素的編號
        this.lastNodeNo = getLastNodeNo(root, 1);
    }

    // 取得二叉樹最後一個元素的編號
    int getLastNodeNo(TreeNode root, int curNo) {
        int max = curNo;

        if(root.left != null) // 左子節點編號為 當前*2
            max = Math.max(max, getLastNodeNo(root.left, curNo * 2));
        if(root.right != null) // 右子節點編號為 當前*2 + 1
            max = Math.max(max, getLastNodeNo(root.right, curNo * 2 + 1));

        return max;
    }

    public int insert(int v) {
        // root不為空的情況
        if(root != null) {
            int new_lastNodeNo = this.lastNodeNo + 1; // 取得要插入的下一個節點的編號
            int pV = insert(this.root, v, new_lastNodeNo, 1);
            this.lastNodeNo = new_lastNodeNo;

            return pV;
        }

        // root為空的情況
        this.lastNodeNo = 1;
        root = new TreeNode(v);
        return v;
    }

    int insert(TreeNode cur, int v, int new_lastNodeNo, int curNo) {
        // 當插入節點是左節點時
        if(cur.left == null && curNo * 2 == new_lastNodeNo) {
            TreeNode new_node = new TreeNode(v);
            cur.left = new_node;
            return cur.val;
        }

        // 當插入節點是右節點時
        if(cur.right == null && curNo * 2 + 1 == new_lastNodeNo) {
            TreeNode new_node = new TreeNode(v);
            cur.right = new_node;
            return cur.val;
        }

        int parentVal = Integer.MIN_VALUE; // MIN_VALUE是找不到節點的情況
        if(cur.left != null && parentVal == Integer.MIN_VALUE) // 利用Math.max函數將找不到節點的情況在找到節點的情況去掉
            parentVal = Math.max(parentVal, insert(cur.left, v, new_lastNodeNo, curNo * 2));

        if(cur.right != null && parentVal == Integer.MIN_VALUE) // 利用Math.max函數將找不到節點的情況在找到節點的情況去掉
            parentVal = Math.max(parentVal, insert(cur.right, v, new_lastNodeNo, curNo * 2 + 1));

        return parentVal;
    }

    public TreeNode get_root() {
        return this.root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */