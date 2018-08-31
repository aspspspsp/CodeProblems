package src.LeetCode.Algorithms.Easy;
/*
�������(XOR)���㣬�քe��s�ct�еČ�ÿ��char�M��xor���Ϳ��ҳ����һ����һ�ӵ�char
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