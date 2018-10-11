package src.LeetCode.Algorithms.Medium;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

public class CompleteBinaryTreeInserter {
    TreeNode root = null;
    int lastNodeNo = 0;
    public CompleteBinaryTreeInserter(TreeNode root) {
        if(root == null)
            return;

        this.root = root;
        // ���̫�@�Ӥ������s��
        this.lastNodeNo = getLastNodeNo(root, 1);
    }

    // ���o�G�e��̫�@�Ӥ������s��
    int getLastNodeNo(TreeNode root, int curNo) {
        int max = curNo;

        if(root.left != null) // ���l�`�I�s���� ��e*2
            max = Math.max(max, getLastNodeNo(root.left, curNo * 2));
        if(root.right != null) // �k�l�`�I�s���� ��e*2 + 1
            max = Math.max(max, getLastNodeNo(root.right, curNo * 2 + 1));

        return max;
    }

    public int insert(int v) {
        // root�����Ū����p
        if(root != null) {
            int new_lastNodeNo = this.lastNodeNo + 1; // ���o�n���J���U�@�Ӹ`�I���s��
            int pV = insert(this.root, v, new_lastNodeNo, 1);
            this.lastNodeNo = new_lastNodeNo;

            return pV;
        }

        // root���Ū����p
        this.lastNodeNo = 1;
        root = new TreeNode(v);
        return v;
    }

    int insert(TreeNode cur, int v, int new_lastNodeNo, int curNo) {
        // ���J�`�I�O���`�I��
        if(cur.left == null && curNo * 2 == new_lastNodeNo) {
            TreeNode new_node = new TreeNode(v);
            cur.left = new_node;
            return cur.val;
        }

        // ���J�`�I�O�k�`�I��
        if(cur.right == null && curNo * 2 + 1 == new_lastNodeNo) {
            TreeNode new_node = new TreeNode(v);
            cur.right = new_node;
            return cur.val;
        }

        int parentVal = Integer.MIN_VALUE; // MIN_VALUE�O�䤣��`�I�����p
        if(cur.left != null && parentVal == Integer.MIN_VALUE) // �Q��Math.max��ƱN�䤣��`�I�����p�b���`�I�����p�h��
            parentVal = Math.max(parentVal, insert(cur.left, v, new_lastNodeNo, curNo * 2));

        if(cur.right != null && parentVal == Integer.MIN_VALUE) // �Q��Math.max��ƱN�䤣��`�I�����p�b���`�I�����p�h��
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