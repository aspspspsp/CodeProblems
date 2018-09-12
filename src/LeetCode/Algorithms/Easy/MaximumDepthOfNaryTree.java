package src.LeetCode.Algorithms.Easy;

import src.LeetCode.Algorithms.Dependencies.Node;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
public class MaximumDepthOfNaryTree {
    public int maxDepth(Node root) {
        if(root == null)
            return 0;

        return helper(root, 1);
    }

    int helper(Node root, int depth) {
        // �Y���M��l�`�I�ɡA��^��e�`��
        if(root.children.size() == 0)
            return depth;

        int max = 0;
        // ���M�Ҧ��l�`�I�A�ño��C�@���l�𪺳̤j�`��
        if(root.children != null) {
            for(int i = 0; i < root.children.size(); i ++) {
                max = Math.max(max, helper(root.children.get(i), depth + 1));
            }
        }

        // ��^��e�`�I���̤j�`��
        return max;
    }
}
}
