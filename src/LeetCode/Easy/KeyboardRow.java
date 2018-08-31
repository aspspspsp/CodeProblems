package src.LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        if(words == null || words.length == 0) {
            String[] result = {};
            return result;
        }
        
        //建立字母表
        Map<Character, Integer> map = new HashMap<>();
        map.put('q', 0);  map.put('a', 1);  map.put('z', 2);
        map.put('w', 0);  map.put('s', 1);  map.put('x', 2);
        map.put('e', 0);  map.put('d', 1);  map.put('c', 2);
        map.put('r', 0);  map.put('f', 1);  map.put('v', 2);
        map.put('t', 0);  map.put('g', 1);  map.put('b', 2);
        map.put('y', 0);  map.put('h', 1);  map.put('n', 2);
        map.put('u', 0);  map.put('j', 1);  map.put('m', 2);
        map.put('i', 0);  map.put('k', 1);
        map.put('o', 0);  map.put('l', 1);
        map.put('p', 0);
        
        //存儲為同一行的字符串
        List<String> res = new ArrayList<>();
        
        //歷遍每一個字符串
        for(String word : words) {
            boolean isSameRow = true;
            String _word = word.toLowerCase();
            char[] c_w = _word.toCharArray();
            
            //紀錄當前字符所位於的鍵盤行
            int row = -1;
            for(char c : c_w) {
                if(map.containsKey(c) == true) {
                    int cur_c_row = map.get(c);
                    if(row == -1) {
                        row = cur_c_row;
                    } else if(row != cur_c_row) {
                        isSameRow = false;
                        break;
                    }
                    
                } else {
                    isSameRow = false;
                    break;
                }
            }
            
            if(isSameRow == true) {
                res.add(word);
            } else {
                continue;
            }
        }
        
        //將答案轉換
        String[] result = new String[res.size()];
        for(int i = 0; i < res.size(); i ++) {
            result[i] = res.get(i);
        }
        
        return result;
    }
}