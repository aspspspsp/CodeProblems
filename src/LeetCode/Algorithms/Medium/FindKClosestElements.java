package src.LeetCode.Algorithms.Medium;

import java.util.*;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0 || k < 1)
            return result;

        // dist, vals �Z����key�A�O���Ҧ��Px�Z����dist������
        Map<Integer, List<Integer>> map = new HashMap<>();

        // dist���u�����C
        Queue<Integer> distQueue = new PriorityQueue<Integer>();

        // ���M�Ҧ�����
        for(int num : arr) {
            // ���o�Z��
            int dist = Math.abs(x - num);

            if(map.containsKey(dist) == false) {
                map.put(dist, new ArrayList<Integer>());
                distQueue.add(dist);
            }

            List list = map.get(dist);
            list.add(num);
            map.put(dist, list);
        }

        // �N�Ҧ��Z���̷Ӥj�p���X
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

        // �Ƨǵ���
        Collections.sort(result);

        return result;
    }
}
