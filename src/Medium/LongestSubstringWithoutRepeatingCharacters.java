package Medium;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxSubstringLength = 0;
        int stringLength = s.length();
        for(int i = 0; i < stringLength; i ++) {
            //從第i個字符開始
            HashSet<Character> subString = new HashSet<>();
            subString.add(s.charAt(i));
            
            //到最後一個有重複字符
            int j = i + 1;
            while(j < stringLength) {
            	//遇到重複字符就跳出
                if(subString.contains(s.charAt(j))) {
                    break;
                } else {
                    subString.add(s.charAt(j));
                    j = j + 1;
                }
            }
            
            //檢查是否為最大子字符串
            if(subString.size() > maxSubstringLength) {
                maxSubstringLength = subString.size();
            }
        }
        
        return maxSubstringLength;
    }
}