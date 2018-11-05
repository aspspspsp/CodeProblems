package src.LeetCode.Algorithms.Medium;

import java.util.*;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0 || k < 1)
            return result;

        // dist, vals 距離為key，記錄所有與x距離為dist的元素
        Map<Integer, List<Integer>> map = new HashMap<>();

        // dist的優先隊列
        Queue<Integer> distQueue = new PriorityQueue<Integer>();

        // 歷遍所有元素
        for(int num : arr) {
            // 取得距離
            int dist = Math.abs(x - num);

            if(map.containsKey(dist) == false) {
                map.put(dist, new ArrayList<Integer>());
                distQueue.add(dist);
            }

            List list = map.get(dist);
            list.add(num);
            map.put(dist, list);
        }

        // 將所有距離依照大小取出
        while(distQueue.isEmpty() == false && k > 0) {
            int dist = distQueue.poll();

            List<Integer> list = map.get(dist);
            for(int num : list) {
                if(k <= 0)
                    break;
                result.add(num);
                k --;
            }
        }

        // 排序答案
        Collections.sort(result);

        return result;
    }
}
