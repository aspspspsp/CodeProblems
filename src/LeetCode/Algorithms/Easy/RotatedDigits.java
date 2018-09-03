package src.LeetCode.Algorithms.Easy;

import java.util.HashSet;
import java.util.Set;

public class RotatedDigits {
    /*

    �o�D�N�O�ҼƦr���˼v(180��)�A�M��˼v���Ʀr�n�P�쥻���Ʀr���@��

    3�B4�B7���˼v�S���Ʀr
    2���˼v�O5
    5���˼v�O2
    6���˼v�O9
    9���˼v�O6
    0�B1�B8���˼v���O�ۤv

    �k���`����A�Ʀr��������Ƥ����t��3�B4�B7�A�M��t��2�B5�B6�B9�����@�ӴN��O����
    */
    public int rotatedDigits(int N) {
        int result = 0;
        if(N < 1)
            return result;

        Set<Character> notContains = new HashSet<>();
        notContains.add('3');
        notContains.add('4');
        notContains.add('7');

        Set<Character> shouldContains = new HashSet<>();
        shouldContains.add('2');
        shouldContains.add('5');
        shouldContains.add('6');
        shouldContains.add('9');

        for(int i = 1; i <= N; i ++) {
            char[] tmp = Integer.toString(i).toCharArray();

            boolean notC = true;
            boolean shouldC = false;
            for(int j = 0; j < tmp.length; j ++) {
                if(notContains.contains(tmp[j]) == true) {
                    notC = false;
                    break;
                }

                if(shouldContains.contains(tmp[j]) == true) {
                    shouldC = true;
                }
            }

            if(notC == true && shouldC == true)
                result ++;
        }

        return result;
    }
}