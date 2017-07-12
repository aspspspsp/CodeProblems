package LeetCode.Hard;
public class EditDistance {
/*
�����㷨�����о����һ����̬�滮���⡣����dp[i-1][j-1]��ʾһ����Ϊi-1���ַ���str1��Ϊ��Ϊj-1���ַ���str2����̾��룬������Ǵ�ʱ��Ҫ��str1a����ַ������str2b����ַ��������������¼���ѡ��

�滻�� ��str1���str2�Ĳ�������ǽ�str1a�е�a�滻Ϊb���͵õ�str2b (���a��b��ȣ��Ͳ��ò���)
���ӣ� ��str1a���str2�Ĳ������������ĩβ���һ��b���͵õ�str2b (str1a�ȸ�����֪������str2���ټӸ�b)
ɾ���� ��str1���str2b�Ĳ���󣬶���str1a�����ǽ�ĩβ��aɾȥ���͵õ�str2b (str1a��aɾȥ�õ�str1����str1��str2b�ı༭������֪)
���������ֲ��������ǿ��Եõ�����ʽ��a��b��ȣ�

dp[i][j] = min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i][j])
��a��b����ȣ�

dp[i][j] = min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i][j]+1)
��Ϊ��һ���ǿ��ַ�����ɿ��ַ�������С����������ĸ������ȫɾ������֮��Ȼ�����ԣ�

dp[0][j]=j, dp[i][0]=i
�������ֻҪ����dp[m][n]���ɣ�����m��word1�ĳ��ȣ�n��word2�ĳ���
*/
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        //��ʼ�����ַ�������r
        for(int i = 1; i <= m; i ++) {
            dp[i][0] = i;
        }
        for(int i = 1; i <= n; i ++) {
            dp[0][i] = i;
        }
        
        for(int i = 1; i <= m; i ++) {
            for(int j = 1; j <= n; j ++) {
                // ���Ӳ���: str1a׃��str1�����b���õ�str2b
                int insertion = dp[i][j - 1] + 1;
                // �h������: str1a�h��a�ᣬ����str1׃��str2b
                int deletion = dp[i - 1][j] + 1;
                // ��Q����: ����str1׃��str2��Ȼ��str1a��a��Q��b���õ�str2b
                int replacement = dp[i - 1][j - 1];
                if(word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    replacement += 1;
                }
                
                //����������������ȡ��С
                dp[i][j] = Math.min(replacement, Math.min(insertion, deletion));
            }
        }
        
        return dp[m][n];
    }
}