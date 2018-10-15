package src.LeetCode.Algorithms.Medium;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 利用Binary Tree構建圖，並找到target成為圖的源節點，
 然後再從圖中的Target節點出發，依序拜訪各點，然後將距
 離為k的節點加入答案
 */
public class AllNodesDistanceKInBinaryTree {
    class GtraphNode {
        public List<GtraphNode> children;
        public int val;
        public boolean isVisited = false;
        public GtraphNode(int val) {
            this.val = val;
            children = new ArrayList<>();
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null || K < 0)
            return result;

        // 構建圖，並找到源節點(從target出發)
        GtraphNode rootNode = new GtraphNode(root.val);
        GtraphNode source = constructGraph(root, rootNode, target);

        // 找到與target距離為k的節點
        getNodeOfDistanceK(source, 0, K, result);

        // 返回結果
        return result;
    }

    // 拜訪圖
    void getNodeOfDistanceK(GtraphNode curG, int step, int K, List<Integer> result) {
        // 設置已經拜訪過
        curG.isVisited = true;

        // 將距離為k的節點記錄下來，並且結束這個路徑的拜訪
        if(step == K) {
            result.add(curG.val);
            return;
        }

        // 拜訪所有尚未拜訪過的相鄰節點
        for(GtraphNode child : curG.children) {
            if(child.isVisited == false) {
                getNodeOfDistanceK(child, step + 1, K, result);
            }
        }
    }

    // 將Tree構建為Graph
    GtraphNode constructGraph(TreeNode cur, GtraphNode curG, TreeNode target) {
        // 源節點為target
        GtraphNode source = null;
        if(cur.val == target.val)
            source = curG;

        // 構建左子樹
        if(cur.left != null) {
            GtraphNode _newL = new GtraphNode(cur.left.val);
            // 將父子關係連起來(父連子，子連父)
            _newL.children.add(curG);
            curG.children.add(_newL);

            GtraphNode left = constructGraph(cur.left, _newL, target);
            if(left != null)
                source = left;
        }

        // 構建右子樹
        if(cur.right != null) {
            // 將父子關係連起來(父連子，子連父)
            GtraphNode _newR = new GtraphNode(cur.right.val);
            _newR.children.add(curG);
            curG.children.add(_newR);

            GtraphNode right = constructGraph(cur.right, _newR, target);
            if(right != null)
                source = right;
        }

        return source;
    }
}
