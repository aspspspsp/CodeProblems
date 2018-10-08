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

            // �ˬd�ӼƬO�_��Self Dividing Number
            if(i % 10 == 0) // ���L���Ƭ�0
                continue;

            boolean isValid = true;
            char[] cs = Integer.toString(i).toCharArray();
            for(int j = 0; j < cs.length; j ++) {
                if(cs[j] == '0') { // ���L������0
                    isValid = false;
                    break;
                }

                int csI = Character.getNumericValue(cs[j]);
                if(i % csI != 0) { // ���L�������ƵL�k�㰣�ۤv
                    isValid = false;
                    break;
                }
            }

            if(isValid == false)
                continue;

            // �OSelf Dividing Number�h�[�J���G��
            result.add(i);
        }

        return result;
    }
}
