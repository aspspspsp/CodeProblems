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
        // 若歷遍到子節點時，返回當前深度
        if(root.children.size() == 0)
            return depth;

        int max = 0;
        // 歷遍所有子節點，並得到每一顆子樹的最大深度
        if(root.children != null) {
            for(int i = 0; i < root.children.size(); i ++) {
                max = Math.max(max, helper(root.children.get(i), depth + 1));
            }
        }

        // 返回當前節點的最大深度
        return max;
    }
}
}
