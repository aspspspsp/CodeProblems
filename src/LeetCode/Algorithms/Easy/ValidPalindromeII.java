package src.LeetCode.Algorithms.Easy;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0)
            return false;

        char[] cs = s.toCharArray();

        // �ˬd�^��A�Y�O���L�k�ǰt�A�h�V���V�k�R��
        int l = 0;
        int r = cs.length - 1;
        int lMiss = 0;
        while(l < r) {
            if(cs[l] != cs[r]) {
                l ++;
                lMiss ++; // �L�k�ǰt+1(�ѥ��V�k)
            } else {
                l ++;
                r --;
            }
        }

        // �ˬd�^��A�Y�O���L�k�ǰt�A�h�V�k�V���R��
        l = 0;
        r = cs.length - 1;
        int rMiss = 0;
        while(l < r) {
            if(cs[l] != cs[r]) {
                r --;
                rMiss ++; // �L�k�ǰt+1(�ѥk�V��)
            } else {
                l ++;
                r --;
            }
        }

        // �Y�����ˬd���j��1�h��ܤ��O�^��(�i�R��1�Ӧr��)
        if(lMiss > 1 && rMiss > 1)
            return false;

        return true;
    }
}
