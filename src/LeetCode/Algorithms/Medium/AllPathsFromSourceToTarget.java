package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        if(graph == null || graph.length == 0 || graph[0].length == 0)
            return result;

        // �������L�����|
        List<Integer> path = new ArrayList<>();
        path.add(0); // �q0�}�l

        // �}�l���M
        dfs(graph, 0, path, result);

        return result;
    }

    void dfs(int[][] graph, int curNode, List<Integer> curPath, List<List<Integer>> pathList) {
        // ���쩳�h��J���G
        if(curNode == graph.length - 1) {
            pathList.add(new ArrayList<>(curPath));
            return;
        }

        // ���X�Ӹ`�I�s�����Ҧ��`�I
        for(int nextNode : graph[curNode]) {
            curPath.add(nextNode);
            dfs(graph, nextNode, curPath, pathList);
            curPath.remove(curPath.size() - 1);
        }
    }
}
