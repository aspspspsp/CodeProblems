package LeetCode.Hard;
/*
 * 
 * 当s1到达第i个元素，s2到达第j个元素:
地图上往右一步就是s2[j-1]匹配s3[i+j-1]。
地图上往下一步就是s1[i-1]匹配s3[i+j-1]。

示例：s1=”aa”,s2=”ab”,s3=”aaba”。标1的为可行。最终返回右下角。

  0 a b
0 1 1 0
a 1 1 1
a 1 0 1
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1 == null?0 : s1.length();    
        int m = s2 == null?0 : s2.length();
        int k = s3 == null?0 : s3.length();
        
        if(n + m != k)
            return false;
        
        char[] S1 = s1.toCharArray();
        char[] S2 = s2.toCharArray();
        char[] S3 = s3.toCharArray();
        
        boolean[][] map = new boolean[n + 1][m + 1];
        
        //根據上面說的方式，判斷狀態
        for(int i = 0; i <= n; i ++) {
            for(int j = 0; j <= m; j ++) {
                if(i == 0 && j == 0) {
                    map[i][j] = true;
                } else if(i == 0) {
                    map[i][j] = map[i][j - 1] & S3[i + j - 1] == S2[j - 1];
                } else if(j == 0) {
                    map[i][j] = map[i - 1][j] & S3[i + j - 1] == S1[i - 1];
                } else {
                    map[i][j] = (map[i][j - 1] & S3[i + j - 1] == S2[j - 1])
                        | (map[i - 1][j] & S3[i + j - 1] == S1[i - 1]);
                }
            }
        }
        return map[n][m];
    }
}