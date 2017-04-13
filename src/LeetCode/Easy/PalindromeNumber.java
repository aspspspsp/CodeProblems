package LeetCode.Easy;
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        char digis [] = (x + "").toCharArray();
        int size = digis.length;
        
        for(int i = 0; i < size / 2; i ++) {
            char d1 = digis[i];
            char d2 = digis[size - i - 1];
            if(d1 != d2)
                return false;
        }
        
        return true;
    }
}