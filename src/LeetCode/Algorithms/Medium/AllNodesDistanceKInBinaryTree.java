package src.LeetCode.Algorithms.Medium;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 �Q��Binary Tree�c�عϡA�ç��target�����Ϫ����`�I�A
 �M��A�q�Ϥ���Target�`�I�X�o�A�̧ǫ��X�U�I�A�M��N�Z
 ����k���`�I�[�J����
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

        // �c�عϡA�ç�췽�`�I(�qtarget�X�o)
        GtraphNode rootNode = new GtraphNode(root.val);
        GtraphNode source = constructGraph(root, rootNode, target);

        // ���Ptarget�Z����k���`�I
        getNodeOfDistanceK(source, 0, K, result);

        // ��^���G
        return result;
    }

    // ���X��
    void getNodeOfDistanceK(GtraphNode curG, int step, int K, List<Integer> result) {
        // �]�m�w�g���X�L
        curG.isVisited = true;

        // �N�Z����k���`�I�O���U�ӡA�åB�����o�Ӹ��|�����X
        if(step == K) {
            result.add(curG.val);
            return;
        }

        // ���X�Ҧ��|�����X�L���۾F�`�I
        for(GtraphNode child : curG.children) {
            if(child.isVisited == false) {
                getNodeOfDistanceK(child, step + 1, K, result);
            }
        }
    }

    // �NTree�c�ج�Graph
    GtraphNode constructGraph(TreeNode cur, GtraphNode curG, TreeNode target) {
        // ���`�I��target
        GtraphNode source = null;
        if(cur.val == target.val)
            source = curG;

        // �c�إ��l��
        if(cur.left != null) {
            GtraphNode _newL = new GtraphNode(cur.left.val);
            // �N���l���Y�s�_��(���s�l�A�l�s��)
            _newL.children.add(curG);
            curG.children.add(_newL);

            GtraphNode left = constructGraph(cur.left, _newL, target);
            if(left != null)
                source = left;
        }

        // �c�إk�l��
        if(cur.right != null) {
            // �N���l���Y�s�_��(���s�l�A�l�s��)
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
