package src.LeetCode.Algorithms.Medium;

import java.util.HashMap;
import java.util.Map;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        char[] cs = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        // 菌筂┮Τ才参璸计秖礛т程
        int maxNum = 0;
        for(char c : cs) {
            if(map.containsKey(c) == false)
                map.put(c, 0);

            int curNum = map.get(c) + 1;

            map.put(c, curNum);

            maxNum = Math.max(maxNum, curNum);
        }

        // ミ表逼才竚瞷Ω计
        String[] bucket = new String[maxNum + 1];
        for(char c : map.keySet()) {
            int tmp = map.get(c);
            if(bucket[tmp] == null)
                bucket[tmp] = c + "";
            else
                bucket[tmp] += c + "";
        }

        // ノStringBuilder纗挡狦磷禬
        StringBuilder result = new StringBuilder();

        // ミ挡狦眖表逼秨﹍玡菌筂
        for(int i = maxNum; i >= 0; i --) {
            // 獶ボ硂计秖Τじㄏノ
            if(bucket[i] != null) {
                char[] tmpC = bucket[i].toCharArray();
                for(int j = 0; j < tmpC.length; j ++) {
                    for(int k = 0; k < i; k ++) {
                        result.append(tmpC[j]);
                    }
                }

            }
        }

        return result.toString();
    }
}
