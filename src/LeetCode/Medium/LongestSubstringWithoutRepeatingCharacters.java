package src.LeetCode.Medium;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxSubstringLength = 0;
        int stringLength = s.length();
        for(int i = 0; i < stringLength; i ++) {
            //�ĵ�i���ַ��_ʼ
            HashSet<Character> subString = new HashSet<>();
            subString.add(s.charAt(i));
            
            //������һ�������}�ַ�
            int j = i + 1;
            while(j < stringLength) {
            	//�������}�ַ�������
                if(subString.contains(s.charAt(j))) {
                    break;
                } else {
                    subString.add(s.charAt(j));
                    j = j + 1;
                }
            }
            
            //�z���Ƿ��������ַ���
            if(subString.size() > maxSubstringLength) {
                maxSubstringLength = subString.size();
            }
        }
        
        return maxSubstringLength;
    }
}