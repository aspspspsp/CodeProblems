package LeetCode.Hard;

public class RegularExpressionMatching {
    /**
        @para s: 字符串
        @para p: 正規表達式
    */
    public boolean isMatch(String s, String p) {
        // 當正規表達式長度為0時
        if(p.length() == 0) {
            if(s.length() == 0)
                return true;
            else
                return false;
        }
        
        // 當正規表達式長度為1時(special case)
        if(p.length() == 1) {
            // 字符串長度為0時返回false
            if(s.length() < 1)
                return false;
            // 當第一個字符串不符合正規表達式的時候返回false
            else if((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.'))
                return false;
            // 比較剩下的字符串與正規表達式
            else
                return isMatch(s.substring(1), p.substring(1));
        }
        
        // 當正規表達式的第二個字元不為'*'時(case 1)
        if(p.charAt(1) != '*') {
            // 字符串長度為0時返回false
            if(s.length() < 1)
                return false;
             // 當第一個字符串不符合正規表達式的時候返回false
            else if((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.'))
                return false;
            // 比較剩下的字符串與正規表達式
            else
                return isMatch(s.substring(1), p.substring(1));
        } 
        // 當正規表達式的第二個字元為'*'時(case 2)，此情況最為複雜
        else {
            // 
            if(isMatch(s, p.substring(2)) == true)
                return true;
            
            //
            int i = 0;
            while(i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
                if(isMatch(s.substring(i + 1), p.substring(2)))
                    return true;
                i ++;
            }
            
            return false;
        }
    }
}