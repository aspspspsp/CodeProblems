package src.LeetCode.Algorithms.Easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        if(left > right)
            return result;

        for(int i = left; i <= right; i ++) {
            if(i < 10) {
                result.add(i);
                continue;
            }

            // 檢查該數是否為Self Dividing Number
            if(i % 10 == 0) // 略過尾數為0
                continue;

            boolean isValid = true;
            char[] cs = Integer.toString(i).toCharArray();
            for(int j = 0; j < cs.length; j ++) {
                if(cs[j] == '0') { // 略過中間有0
                    isValid = false;
                    break;
                }

                int csI = Character.getNumericValue(cs[j]);
                if(i % csI != 0) { // 略過中間的數無法整除自己
                    isValid = false;
                    break;
                }
            }

            if(isValid == false)
                continue;

            // 是Self Dividing Number則加入結果當中
            result.add(i);
        }

        return result;
    }
}
