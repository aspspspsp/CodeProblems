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
public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        helper(root, result);

        return result;
    }

    void helper(Node root, List<Integer> result) {
        // �[�J��e����
        result.add(root.val);

        // ���M�Ҧ��l�`�I
        if(root.children != null) {
            for(int i = 0; i < root.children.size(); i ++) {
                helper(root.children.get(i), result);
            }
        }
    }
}