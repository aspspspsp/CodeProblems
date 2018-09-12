package src.LeetCode.Algorithms.Easy;

import src.LeetCode.Algorithms.Dependencies.Node;

import java.util.ArrayList;
import java.util.List;

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
public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        helper(root, result);

        return result;
    }

    void helper(Node root, List<Integer> result) {
        // 歷遍所有子節點
        if(root.children != null) {
            for(int i = 0; i < root.children.size(); i ++) {
                helper(root.children.get(i), result);
            }
        }

        // 加入當前元素
        result.add(root.val);
    }
}
