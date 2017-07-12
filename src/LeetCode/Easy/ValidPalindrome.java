package LeetCode.Easy;
/*
這題因為有極大的字符串，故要使用前後指針的方式防止運行時間過長
*/
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;
        
        //利用指針進行字符的前後比較
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end) {
            //前面指針遇到特殊自符或是空白則跳過
            while(start < s.length() && isValid(s.charAt(start)) == false) {
                start ++;
            }
            
            if(start == s.length()) {
                return true;
            }
            
            //後面指針遇到特殊字符或是空白則跳過
            while(end >= 0 && isValid(s.charAt(end)) == false) {
                end --;
            }
            
            //進行字符比較，若當前字符不一樣則返回false
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            //一樣則前面指針往後，後面指針往前
            } else {
                start ++;
                end --;
            }
        }
        
        return true;
    }
    
    //檢查該字符是否為數字或是字母
    boolean isValid(char c) {
        if(Character.isLetter(c))
            return true;
        if(Character.isDigit(c))
            return true;
            
        return false;
    }
}