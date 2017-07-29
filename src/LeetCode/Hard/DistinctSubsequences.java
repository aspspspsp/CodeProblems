package LeetCode.Hard;
/*
可以先尝试做一个二维的表int[][] results，用来记录匹配子序列的个数
（以s ="rabbbit",t = "rabbit"为例）：
    r a b b b i t
  1 1 1 1 1 1 1 1
r 0 1 1 1 1 1 1 1
a 0 0 1 1 1 1 1 1
b 0 0 0 1 2 3 3 3
b 0 0 0 0 1 3 3 3
i 0 0 0 0 0 0 3 3
t 0 0 0 0 0 0 0 3  
从这个表可以看出，无论s的字符与S的字符是否匹配，results[i][j] = results[i][j - 1].
就是说，假设s已经匹配了j - 1个字符，得到匹配个数为results[i][j - 1].
现在无论s[j]是不是和t[i]匹配，匹配的个数至少是results[i][j - 1]。
除此之外，当s[j]和t[i]相等时，我们可以让s[j]和t[i]匹配，然后让s[j - 1]和t[i - 1]去匹配。
所以递推关系为：
results[0][0] = 1; // t和s都是空串.
results[0][1 ... s.length() - 1] = 1; // t是空串，s只有一种子序列匹配。
results[1 ... t.length() - 1][0] = 0; // s是空串，t不是空串，s没有子序列匹配。
results[i][j] = 
	results[i][j - 1] + (t[i - 1] == s[j - 1] ? results[i - 1][j - 1] : 0).1 <= i <= t.length(), 1 <= j <= s.length()
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int[][] results = new int[t.length() + 1][s.length() + 1];
        results[0][0] = 1;
        
        for(int i = 1; i <= t.length(); i ++) {
            results[i][0] = 0;
        }
        
        for(int j = 1; j <= s.length(); j ++) {
            results[0][j] = 1;
        }
        
        for(int i = 1; i <= t.length(); i ++) {
            for(int j = 1; j <= s.length(); j ++) {
                results[i][j] = results[i][j - 1];
                if(t.charAt(i - 1) == s.charAt(j - 1)) {
                    results[i][j] = results[i][j] + results[i - 1][j - 1];
                }
            }
        }
        
        return results[t.length()][s.length()];
    }
}