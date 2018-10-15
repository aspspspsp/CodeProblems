package src.LeetCode.Algorithms.Medium;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        // 存儲答案
        List<String> result = new ArrayList<>();

        // 例外情況
        if(words == null || words.length == 0 || k < 1)
            return result;

        // 利用Map存儲字串出現次數
        Map<String, Integer> map = new TreeMap<>();
        for(String word : words) {
            if(map.containsKey(word) == false)
                map.put(word, 0);

            map.put(word, map.get(word) + 1);
        }

        // Comparator可以自己實現排序順序
        Comparator<Map.Entry<String, Integer>> valueComparator =
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> e1,
                                       Map.Entry<String, Integer> e2) {
                        return e2.getValue() - e1.getValue(); // 倒排
                    }
                };

        // 存儲排序後的map
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // 正式進行排序
        Collections.sort(list, valueComparator);

        // 取topK
        for(Map.Entry<String, Integer> entry : list) {
            if(k <= 0)
                break;
            result.add(entry.getKey());
            k --;
        }

        return result;
    }
}
