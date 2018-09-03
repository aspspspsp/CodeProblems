package src.LeetCode.Algorithms.Easy;

import java.util.HashSet;
import java.util.Set;

public class RotatedDigits {
    /*

    硂肈碞琌σ计紇(180)礛紇计璶籔セ计ぃ妓

    347紇⊿Τ计
    2紇琌5
    5紇琌2
    6紇琌9
    9紇琌6
    018紇常琌

    耴羆挡计场计ずぃΤ347礛Τ2569ヴ碞衡琌氮
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