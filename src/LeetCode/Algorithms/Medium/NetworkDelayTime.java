package src.LeetCode.Algorithms.Medium;

import java.util.*;
/*
    這題用戴克斯特拉算法紀錄從K節點到每一個節點的距離，然後再找到從K出發的最大的距離即可
    步驟:
    1.建立鄰接表
    2.戴克斯特拉算法歷遍所有點，並記錄從K到所有點的距離
      (利用優先對列可以保證所有點的距離為最小)
    3.找到從K出發的最大距離

 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times.length == 0) {
            return -1;
        }

        /* 建立圖 (類似於鄰接表)
            格式:
            (u: {v1, w1}, {v2, w2}) 從u出發到v的所有路徑
        */
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            List<int[]> edges = graph.get(u);
            if(edges == null)
                edges = new ArrayList<>();
            edges.add(new int[]{v, w});
            graph.put(u, edges);
        }

        /*
        進行戴克斯特拉算法
        */

        // PriorityQueue (以distance比大小，小的優先)
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // 將隊列放入起始節點K，以及距離0(代表還沒開始走)，開始歷遍整個圖
        pq.offer(new int[]{K, 0});

        // 利用hashmap來記錄拜訪過的節點以及從K節點到該節點的最短距離
        Map<Integer, Integer> distances = new HashMap<>();

        while(pq.isEmpty() == false) {
            // 目前節點
            int[] cur = pq.poll();
            int cur_node = cur[0];
            int distance = cur[1];

            // 若是拜訪到當前節點，則略過(不拜訪自己)
            if (distances.containsKey(cur_node)) {
                continue;
            }

            distances.put(cur_node, distance);

            // 若圖中有當前節點
            if(graph.containsKey(cur_node)) {
                // 找下一個點(鄰居)
                for(int[] neighbor : graph.get(cur_node)) {
                    // 若這個鄰居沒有被拜訪過，則將這個節點放入隊列當中
                    if(distances.containsKey(neighbor[0]) == false) {
                        pq.offer(new int[] {
                                neighbor[0],
                                neighbor[1] + distance
                        });
                    }
                }
            }
        }

        // 無法所有點都拜訪到的情況則返回-1
        if(distances.size() < N) {
            return -1;
        }

        // 找到最長的距離
        int result = 0;
        for(int distance : distances.values()) {
            result = Math.max(result, distance);
        }
        return result;
    }
}
