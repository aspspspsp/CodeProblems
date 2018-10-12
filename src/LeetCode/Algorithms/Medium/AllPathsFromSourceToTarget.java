package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        if(graph == null || graph.length == 0 || graph[0].length == 0)
            return result;

        // 紀錄走過的路徑
        List<Integer> path = new ArrayList<>();
        path.add(0); // 從0開始

        // 開始歷遍
        dfs(graph, 0, path, result);

        return result;
    }

    void dfs(int[][] graph, int curNode, List<Integer> curPath, List<List<Integer>> pathList) {
        // 走到底則放入結果
        if(curNode == graph.length - 1) {
            pathList.add(new ArrayList<>(curPath));
            return;
        }

        // 拜訪該節點連接的所有節點
        for(int nextNode : graph[curNode]) {
            curPath.add(nextNode);
            dfs(graph, nextNode, curPath, pathList);
            curPath.remove(curPath.size() - 1);
        }
    }
}
