package src.LeetCode.Algorithms.Easy;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String S, char C) {
        char[] c = S.toCharArray();

        // 紀錄每個字符與C之間的最短距離
        int[] r = new int[c.length];

        // 找到字符串中所有的C，並記錄他們的位置，若不是該位置不是C時，則記錄為無限大
        List<Integer> c_pos = new ArrayList<>();
        for(int i = 0; i < c.length; i ++) {
            if(c[i] == C) {
                r[i] = 0;
                c_pos.add(i);
            } else
                r[i] = Integer.MAX_VALUE;
        }

        // 歷遍每個字符
        int cur_c_pos = 0;
        for(int i = 0; i < r.length; i ++) {
            // 若當前字符不為C
            if(r[i] == Integer.MAX_VALUE) {
                // 從2個C之間找到最短距離(當前C位置以及上一個C位置)
                if(cur_c_pos < c_pos.size()) {
                    int tmp = Math.abs(i - c_pos.get(cur_c_pos));
                    r[i] = Math.min(r[i], tmp);
                }

                if(cur_c_pos - 1 >= 0) {
                    int tmp = Math.abs(i - c_pos.get(cur_c_pos - 1));
                    r[i] = Math.min(r[i], tmp);
                }

            // 若為C，則移動指針(針對存儲所有C位置陣列的指針)
            } else if(r[i] == 0) {
                cur_c_pos ++;
            }
        }

        return r;
    }
}
