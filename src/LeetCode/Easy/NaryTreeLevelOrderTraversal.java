package src.LeetCode.Easy;

import src.LeetCode.Dependencies.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        // ��������
        List<List<Integer>> result = new ArrayList<>();

        // �B�z�ҥ~���p
        if(root == null)
            return result;

        // �o��map�O�O���C�@�h�����p
        Map<Integer, List<Integer>> map =  new HashMap<>();

        // ���M�o�ʾ�
        helper(root, map, 0);

        // �NhashMapŪ���X��
        for(int i = 0; i <= max_level; i ++) {
            List cur_l = map.get(i);
            result.add(cur_l);
        }

        return result;
    }

    // �����̤j�`��
    int max_level = 0;
    void helper(Node root, Map<Integer, List<Integer>> map, int cur_level) {
        // ��s�̤j�`��
        if(max_level < cur_level)
            max_level = cur_level;

        // �N���פ��h��Jmap��
        if(map.containsKey(cur_level) == false) {
            List new_list = new ArrayList<Integer>();
            new_list.add(root.val);
            map.put(cur_level, new_list);
        } else {
            List existed_list = map.get(cur_level);
            existed_list.add(root.val);
            map.put(cur_level, existed_list);
        }

        // ���l�`�I�~�򨫳X
        for(int i = 0; i < root.children.size(); i ++) {
            Node child = root.children.get(i);
            helper(child, map, cur_level + 1);
        }
    }
}
