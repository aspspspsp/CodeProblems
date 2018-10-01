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

        // �Npattern�إ߫���S�x
        int[] nPattern = getPattern(pattern);

        for(String word : words) {
            // �Nword�إ߯S�x
            int[] wordPattern = getPattern(word);

            // �Y�@�˫h�K�[�ܵ��G
            if(isFeatureVaild(wordPattern, nPattern)) {
                result.add(word);
            }
        }

        return result;
    }

    // ����r�Ŧ�S�x�P����S�x�O�_�@��
    boolean isFeatureVaild(int[] wordPattern, int[] nPattern) {
        // �Y�S�x�j�p���@�ˡA�h���L
        if(wordPattern.length != nPattern.length)
            return false;

        // ����S�x�O�_�@��
        for(int i = 0; i < wordPattern.length; i ++) {
            if(wordPattern[i] != nPattern[i])
                return false;
        }

        return true;
    }

    // �إ߯S�x
    int[] getPattern(String word) {
        char[] cs = word.toCharArray();

        // �إߦr����A�N�r���ഫ�������Ʀr
        Map<Character, Integer> set = new HashMap<>();

        int[] pattern = new int[cs.length];
        int patternN = 0;

        for(int i = 0; i < cs.length; i ++) {
            // �Y�S�X�{�L�A�h�̤j�r���ƫh�[1�A�é�J�r���d���
            if(set.containsKey(cs[i]) == false) {
                patternN ++;
                set.put(cs[i], patternN);
            }

            // �d��A�������Ʀr
            int p = set.get(cs[i]);
            pattern[i] = p;
        }

        return pattern;
    }
}