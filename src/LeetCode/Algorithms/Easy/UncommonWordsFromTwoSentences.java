package src.LeetCode.Algorithms.Easy;

import java.util.HashSet;
import java.util.Set;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        // �����Ҧ��X�{�L����r
        Set<String> set = new HashSet<>();
        // �u���X�{�L�@������r
        Set<String> resSet = new HashSet<>();


        String[] strA = A.split(" ");
        String[] strB = B.split(" ");

        int length = Math.max(strA.length, strB.length);

        for(int i = 0; i < length; i ++) {
            if(i < strA.length) {
                if(set.contains(strA[i]) == false) {
                    set.add(strA[i]);
                    resSet.add(strA[i]);
                } else {
                    resSet.remove(strA[i]);
                }
            }

            if(i < strB.length) {
                if(set.contains(strB[i]) == false) {
                    set.add(strB[i]);
                    resSet.add(strB[i]);
                } else {
                    resSet.remove(strB[i]);
                }
            }
        }

        String[] result = new String[resSet.size()];
        int i = 0;
        for(String res : resSet) {
            result[i] = res;
            i ++;
        }

        return result;
    }
}
