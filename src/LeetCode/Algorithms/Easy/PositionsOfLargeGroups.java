package src.LeetCode.Algorithms.Easy;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {

        List<List<Integer>> result = new ArrayList<>();

        char[] cs = S.toCharArray();
        int startFrom = 0;
        int length = 1;

        // �B�z�e����Group
        for(int i = 1; i < cs.length; i ++) {
            // �J�줣�P��Group�h�B�z�A�N�e����Group��Jresult�A�ñN�᭱��Group�}�l�p��}�l��m
            if(cs[i - 1] != cs[i]) {
                // �p�⵲���Z��
                int endTo = i - 1;
                List<Integer> subRes = new ArrayList<>();
                subRes.add(startFrom);
                subRes.add(endTo);

                // ��J���G
                if(length >= 3)
                    result.add(subRes);
                // ���G�k�s
                length = 1;
                startFrom = i;
            } else {
                length ++;
            }
        }

        // �B�z�̫᪺Group
        if(cs.length >= 3 && cs[cs.length - 1] == cs[cs.length - 2] && length >= 3) {
            List<Integer> subRes = new ArrayList<>();

            int endTo = cs.length - 1;
            subRes.add(startFrom);
            subRes.add(endTo);

            result.add(subRes);
        }

        return result;
    }
}
