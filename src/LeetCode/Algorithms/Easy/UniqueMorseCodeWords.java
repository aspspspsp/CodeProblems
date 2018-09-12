package src.LeetCode.Algorithms.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        if(words == null || words.length == 0)
            return 0;

        // 取得摩斯密碼的字母對應表
        Map<Character, String> morseCodeMap = getMorseMap();

        // 利用set記錄不同的摩斯密碼英文單字
        Set<String> morseCodeSet = new HashSet<>();
        for(int i = 0; i < words.length; i ++) {
            char[] cs = words[i].toCharArray();
            String morseCode = "";
            for(int j = 0; j < cs.length; j ++) {
                String m = morseCodeMap.get(cs[j]);
                morseCode += m;
            }

            morseCodeSet.add(morseCode);
        }

        // 返回不同的數量
        return morseCodeSet.size();
    }

    Map<Character, String> getMorseMap() {
        Map<Character, String> morseCodeMap = new HashMap<>();
        morseCodeMap.put('a',".-");
        morseCodeMap.put('b',"-...");
        morseCodeMap.put('c', "-.-.");
        morseCodeMap.put('d', "-..");
        morseCodeMap.put('e', ".");
        morseCodeMap.put('f', "..-.");
        morseCodeMap.put('g', "--.");
        morseCodeMap.put('h', "....");
        morseCodeMap.put('i', "..");
        morseCodeMap.put('j', ".---");
        morseCodeMap.put('k', "-.-");
        morseCodeMap.put('l', ".-..");
        morseCodeMap.put('m', "--");
        morseCodeMap.put('n', "-.");
        morseCodeMap.put('o', "---");
        morseCodeMap.put('p', ".--.");
        morseCodeMap.put('q', "--.-");
        morseCodeMap.put('r', ".-.");
        morseCodeMap.put('s', "...");
        morseCodeMap.put('t', "-");
        morseCodeMap.put('u', "..-");
        morseCodeMap.put('v', "...-");
        morseCodeMap.put('w', ".--");
        morseCodeMap.put('x', "-..-");
        morseCodeMap.put('y', "-.--");
        morseCodeMap.put('z', "--..");

        return morseCodeMap;
    }
}
