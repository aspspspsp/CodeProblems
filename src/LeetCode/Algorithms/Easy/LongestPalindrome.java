package src.LeetCode.Algorithms.Easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if(s.length() == 0 || s.equals(""))
            return 0;
        
        if(s.length() == 1)
            return 1;
        
        Map<Character, Integer> map = new HashMap<>();
        
        char[] c_s = s.toCharArray();
        for(int i = 0; i < c_s.length; i ++) {
            char c = c_s[i];
            if(map.containsKey(c) == false) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        
        boolean isHasMiddle = false;
        int result = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            int s_i = entry.getValue();
            if(s_i % 2 == 1) {
                if(isHasMiddle == false) {
                    result += s_i;
                    isHasMiddle = true;
                } else {
                    result += s_i - 1;
                }
            } else {
                result += s_i;
            }
        }
        
        return result;
    }
}