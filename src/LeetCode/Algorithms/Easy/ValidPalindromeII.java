package src.LeetCode.Algorithms.Easy;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0)
            return false;

        char[] cs = s.toCharArray();

        // 檢查回文，若是有無法匹配，則向左向右刪除
        int l = 0;
        int r = cs.length - 1;
        int lMiss = 0;
        while(l < r) {
            if(cs[l] != cs[r]) {
                l ++;
                lMiss ++; // 無法匹配+1(由左向右)
            } else {
                l ++;
                r --;
            }
        }

        // 檢查回文，若是有無法匹配，則向右向左刪除
        l = 0;
        r = cs.length - 1;
        int rMiss = 0;
        while(l < r) {
            if(cs[l] != cs[r]) {
                r --;
                rMiss ++; // 無法匹配+1(由右向左)
            } else {
                l ++;
                r --;
            }
        }

        // 若兩邊檢查都大於1則表示不是回文(可刪除1個字符)
        if(lMiss > 1 && rMiss > 1)
            return false;

        return true;
    }
}
