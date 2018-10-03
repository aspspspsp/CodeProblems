package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        // �إ��`�r����
        Map<Character, Integer> map = new HashMap<>();
        for(String b : B) {
            char[] csB = b.toCharArray();
            // ��e�r����(��b)
            Map<Character, Integer> tempMap = new HashMap<>();
            for(char c : csB) {
                if(tempMap.containsKey(c) == false)
                    tempMap.put(c, 0);
                tempMap.put(c, tempMap.get(c) + 1);
            }

            // ��e�r����P�`�r����i�����A�X�{���Ƴ̦h�h�O�����`�r����
            for(char tempC : tempMap.keySet()) {
                if(map.containsKey(tempC) == false) {
                    map.put(tempC, tempMap.get(tempC));
                } else {
                    int max_occurs = Math.max(tempMap.get(tempC), map.get(tempC));
                    map.put(tempC, max_occurs);
                }
            }
        }

        // ��J����
        List<String> result = new ArrayList<>();
        for(String a : A) {
            char[] csA = a.toCharArray();

            // ��e�r����(��a)
            Map<Character, Integer> tempMap = new HashMap<>();
            for(char c : csA) {
                if(tempMap.containsKey(c) == false)
                    tempMap.put(c, 0);
                tempMap.put(c, tempMap.get(c) + 1);
            }

            // �P�_�O�_�ŦXB�r��������
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

            // �Y���ŦX�h�K�[�ܵ��פ�
            if(isVaild == true) {
                result.add(a);
            }
        }

        // ��^����
        return result;
    }
}
