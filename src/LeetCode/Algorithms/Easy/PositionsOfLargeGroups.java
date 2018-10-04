package src.LeetCode.Algorithms.Easy;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {

        List<List<Integer>> result = new ArrayList<>();

        char[] cs = S.toCharArray();
        int startFrom = 0;
        int length = 1;

        // 處理前面的Group
        for(int i = 1; i < cs.length; i ++) {
            // 遇到不同的Group則處理，將前面的Group放入result，並將後面的Group開始計算開始位置
            if(cs[i - 1] != cs[i]) {
                // 計算結束距離
                int endTo = i - 1;
                List<Integer> subRes = new ArrayList<>();
                subRes.add(startFrom);
                subRes.add(endTo);

                // 放入結果
                if(length >= 3)
                    result.add(subRes);
                // 結果歸零
                length = 1;
                startFrom = i;
            } else {
                length ++;
            }
        }

        // 處理最後的Group
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
