package src.LeetCode.Algorithms.Medium;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        // �s�x����
        List<String> result = new ArrayList<>();

        // �ҥ~���p
        if(words == null || words.length == 0 || k < 1)
            return result;

        // �Q��Map�s�x�r��X�{����
        Map<String, Integer> map = new TreeMap<>();
        for(String word : words) {
            if(map.containsKey(word) == false)
                map.put(word, 0);

            map.put(word, map.get(word) + 1);
        }

        // Comparator�i�H�ۤv��{�ƧǶ���
        Comparator<Map.Entry<String, Integer>> valueComparator =
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> e1,
                                       Map.Entry<String, Integer> e2) {
                        return e2.getValue() - e1.getValue(); // �˱�
                    }
                };

        // �s�x�Ƨǫ᪺map
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // �����i��Ƨ�
        Collections.sort(list, valueComparator);

        // ��topK
        for(Map.Entry<String, Integer> entry : list) {
            if(k <= 0)
                break;
            result.add(entry.getKey());
            k --;
        }

        return result;
    }
}
