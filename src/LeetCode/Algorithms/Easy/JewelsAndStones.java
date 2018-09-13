package src.LeetCode.Algorithms.Easy;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if(J == null || J.length() == 0)
            return 0;

        if(S == null || S.length() == 0)
            return 0;

        char[] js = J.toCharArray();
        char[] ss = S.toCharArray();

        Set set = new HashSet<Character>();
        for(int i = 0; i < js.length; i ++) {
            set.add(js[i]);
        }

        int result = 0;
        for(int i = 0; i < ss.length; i ++) {
            if(set.contains(ss[i]))
                result ++;
        }

        return result;
    }
}
