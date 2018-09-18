package src.LeetCode.Algorithms.Medium;

import java.util.*;
/*
    �o�D�����J���S�Ժ�k�����qK�`�I��C�@�Ӹ`�I���Z���A�M��A���qK�X�o���̤j���Z���Y�i
    �B�J:
    1.�إ߾F����
    2.���J���S�Ժ�k���M�Ҧ��I�A�ðO���qK��Ҧ��I���Z��
      (�Q���u����C�i�H�O�ҩҦ��I���Z�����̤p)
    3.���qK�X�o���̤j�Z��

 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times.length == 0) {
            return -1;
        }

        /* �إ߹� (������F����)
            �榡:
            (u: {v1, w1}, {v2, w2}) �qu�X�o��v���Ҧ����|
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
        �i�����J���S�Ժ�k
        */

        // PriorityQueue (�Hdistance��j�p�A�p���u��)
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // �N���C��J�_�l�`�IK�A�H�ζZ��0(�N���٨S�}�l��)�A�}�l���M��ӹ�
        pq.offer(new int[]{K, 0});

        // �Q��hashmap�ӰO�����X�L���`�I�H�αqK�`�I��Ӹ`�I���̵u�Z��
        Map<Integer, Integer> distances = new HashMap<>();

        while(pq.isEmpty() == false) {
            // �ثe�`�I
            int[] cur = pq.poll();
            int cur_node = cur[0];
            int distance = cur[1];

            // �Y�O���X���e�`�I�A�h���L(�����X�ۤv)
            if (distances.containsKey(cur_node)) {
                continue;
            }

            distances.put(cur_node, distance);

            // �Y�Ϥ�����e�`�I
            if(graph.containsKey(cur_node)) {
                // ��U�@���I(�F�~)
                for(int[] neighbor : graph.get(cur_node)) {
                    // �Y�o�ӾF�~�S���Q���X�L�A�h�N�o�Ӹ`�I��J���C��
                    if(distances.containsKey(neighbor[0]) == false) {
                        pq.offer(new int[] {
                                neighbor[0],
                                neighbor[1] + distance
                        });
                    }
                }
            }
        }

        // �L�k�Ҧ��I�����X�쪺���p�h��^-1
        if(distances.size() < N) {
            return -1;
        }

        // ���̪����Z��
        int result = 0;
        for(int distance : distances.values()) {
            result = Math.max(result, distance);
        }
        return result;
    }
}
