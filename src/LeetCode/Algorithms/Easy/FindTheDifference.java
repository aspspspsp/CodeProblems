package src.LeetCode.Algorithms.Easy;
/*
我们可以使用位操作Bit Manipulation来做，利用异或的性质，相同位返回0，
这样相同的字符都抵消了，剩下的就是后加的那个字符
*/

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char difference = 0;
        if(s == null || s == "") {
            return t.charAt(t.length() - 1);
        }
        
        for(int i = 0; i < s.length(); i ++) {
            difference ^= s.charAt(i);
        }
        
        for(int i = 0; i < t.length(); i ++) {
            difference ^= t.charAt(i);
        }
        
        return difference;
        
    }
}