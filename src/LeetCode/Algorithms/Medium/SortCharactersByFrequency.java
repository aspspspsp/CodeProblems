package src.LeetCode.Algorithms.Medium;

import java.util.HashMap;
import java.util.Map;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        char[] cs = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        // ���M�Ҧ��r�šA�òέp�ƶq�A�M����̤j��
        int maxNum = 0;
        for(char c : cs) {
            if(map.containsKey(c) == false)
                map.put(c, 0);

            int curNum = map.get(c) + 1;

            map.put(c, curNum);

            maxNum = Math.max(maxNum, curNum);
        }

        // �إ߱�ƧǡA�r�Ŧ�m�N��X�{������
        String[] bucket = new String[maxNum + 1];
        for(char c : map.keySet()) {
            int tmp = map.get(c);
            if(bucket[tmp] == null)
                bucket[tmp] = c + "";
            else
                bucket[tmp] += c + "";
        }

        // �Q��StringBuilder�s�x���G�A�קK�W��
        StringBuilder result = new StringBuilder();

        // �إߵ��G�A�q��ƧǤj���}�l�V�e���M
        for(int i = maxNum; i >= 0; i --) {
            // �D�Ū�ܳo�Ӽƶq���r���ϥ�
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
