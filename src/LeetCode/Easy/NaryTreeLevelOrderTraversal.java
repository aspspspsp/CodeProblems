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
        // 紀錄答案
        List<List<Integer>> result = new ArrayList<>();

        // 處理例外情況
        if(root == null)
            return result;

        // 這個map是記錄每一層的情況
        Map<Integer, List<Integer>> map =  new HashMap<>();

        // 歷遍這棵樹
        helper(root, map, 0);

        // 將hashMap讀取出來
        for(int i = 0; i <= max_level; i ++) {
            List cur_l = map.get(i);
            result.add(cur_l);
        }

        return result;
    }

    // 紀錄最大深度
    int max_level = 0;
    void helper(Node root, Map<Integer, List<Integer>> map, int cur_level) {
        // 更新最大深度
        if(max_level < cur_level)
            max_level = cur_level;

        // 將答案分層放入map中
        if(map.containsKey(cur_level) == false) {
            List new_list = new ArrayList<Integer>();
            new_list.add(root.val);
            map.put(cur_level, new_list);
        } else {
            List existed_list = map.get(cur_level);
            existed_list.add(root.val);
            map.put(cur_level, existed_list);
        }

        // 往子節點繼續走訪
        for(int i = 0; i < root.children.size(); i ++) {
            Node child = root.children.get(i);
            helper(child, map, cur_level + 1);
        }
    }
}
