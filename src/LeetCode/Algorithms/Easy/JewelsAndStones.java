package src.LeetCode.Algorithms.Easy;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if(J == null || J.length() == 0)
            return 0;

        if(S == null || S.length() == 0)
            return 0;

        char[] js = J.toCharArray();
        char[] ss = S.toCharArray();

        int result = 0;
        for(int i = 0; i < ss.length; i ++) {
            for(int j = 0; j < js.length; j ++) {
                if(js[j] == ss[i])
                    result ++;
            }
        }

        return result;
    }
}
