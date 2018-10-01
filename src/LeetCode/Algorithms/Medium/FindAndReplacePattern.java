package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        if(words == null || words.length == 0)
            return result;

        if(pattern == null || pattern.length() == 0 || pattern.equals("") == true)
            return result;

        // 將pattern建立待驗特徵
        int[] nPattern = getPattern(pattern);

        for(String word : words) {
            // 將word建立特徵
            int[] wordPattern = getPattern(word);

            // 若一樣則添加至結果
            if(isFeatureVaild(wordPattern, nPattern)) {
                result.add(word);
            }
        }

        return result;
    }

    // 比較字符串特徵與待驗特徵是否一樣
    boolean isFeatureVaild(int[] wordPattern, int[] nPattern) {
        // 若特徵大小不一樣，則略過
        if(wordPattern.length != nPattern.length)
            return false;

        // 比較特徵是否一樣
        for(int i = 0; i < wordPattern.length; i ++) {
            if(wordPattern[i] != nPattern[i])
                return false;
        }

        return true;
    }

    // 建立特徵
    int[] getPattern(String word) {
        char[] cs = word.toCharArray();

        // 建立字母表，將字母轉換為對應數字
        Map<Character, Integer> set = new HashMap<>();

        int[] pattern = new int[cs.length];
        int patternN = 0;

        for(int i = 0; i < cs.length; i ++) {
            // 若沒出現過，則最大字母數則加1，並放入字母查找表中
            if(set.containsKey(cs[i]) == false) {
                patternN ++;
                set.put(cs[i], patternN);
            }

            // 查表，找到對應數字
            int p = set.get(cs[i]);
            pattern[i] = p;
        }

        return pattern;
    }
}