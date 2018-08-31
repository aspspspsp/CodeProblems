package src.LeetCode.Algorithms.Easy;

public class LongestUncommonSubsequenceI {
    /*
题目要求两个字符串的“最长非公共子序列”的长度，怎么求最长？
如果两个字符串不相等，那其实任意一个字符串本身都是非公共子序列；
所以结果也出来了，如果字符串不想等，那么“最长非公共子序列”
就是较长的那个字符串了。如果字符串相等，可想而知不可能找到
“最长非公共子序列”。
    */
    public int findLUSlength(String a, String b) {
        if(a == null || b == null)
            return -1;
        
        if(a.equals(b) == true)
            return -1;
        
        return Math.max(a.length(), b.length());
    }
}