package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        // 建立總字母表
        Map<Character, Integer> map = new HashMap<>();
        for(String b : B) {
            char[] csB = b.toCharArray();
            // 當前字母表(於b)
            Map<Character, Integer> tempMap = new HashMap<>();
            for(char c : csB) {
                if(tempMap.containsKey(c) == false)
                    tempMap.put(c, 0);
                tempMap.put(c, tempMap.get(c) + 1);
            }

            // 當前字母表與總字母表進行比較，出現次數最多則記錄於總字母表
            for(char tempC : tempMap.keySet()) {
                if(map.containsKey(tempC) == false) {
                    map.put(tempC, tempMap.get(tempC));
                } else {
                    int max_occurs = Math.max(tempMap.get(tempC), map.get(tempC));
                    map.put(tempC, max_occurs);
                }
            }
        }

        // 填入答案
        List<String> result = new ArrayList<>();
        for(String a : A) {
            char[] csA = a.toCharArray();

            // 當前字母表(於a)
            Map<Character, Integer> tempMap = new HashMap<>();
            for(char c : csA) {
                if(tempMap.containsKey(c) == false)
                    tempMap.put(c, 0);
                tempMap.put(c, tempMap.get(c) + 1);
            }

            // 判斷是否符合B字母表的條件
            boolean isVaild = true;
            for(char tempM : map.keySet()) {
                if(tempMap.containsKey(tempM) == false) {
                    isVaild = false;
                    break;
                }

                if(tempMap.get(tempM) < map.get(tempM)) {
                    isVaild = false;
                    break;
                }
            }

            // 若都符合則添加至答案內
            if(isVaild == true) {
                result.add(a);
            }
        }

        // 返回答案
        return result;
    }
}
