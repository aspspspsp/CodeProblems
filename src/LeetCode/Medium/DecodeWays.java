package LeetCode.Medium;

public class DecodeWays {
    /*
    1234
    dp[0] = 1
    dp[1] = 1   1
    dp[2] = 2   1,2 12 <= dp[1] + dp[0]
    dp[3] = 3   1,2,3 12,3 1,23 <= dp[2] + dp[1]
    dp[4] = 3   1,2,3,4 12,3,4 1,23,4 <= dp[3]
    
    0123
    dp[0] = 1
    dp[1] = 0
    dp[2] = 0
    dp[3] = 0
    
    9203
    dp[0] = 1
    dp[1] = 1   9 <= dp[0]
    dp[2] = 1   9,2 <= dp[1]
    dp[3] = 1   9,20 <= dp[2]
    dp[4] = 1   9,20,3 <= dp[3]
    
    �������й��ɵģ��������ǿ��Գ��Զ�̬�滮��
    ��������dp[i]��ʾ��ͷ���ַ����ĵ�iλ��һ���ж����ֽ��뷽���Ļ�����ô��
    ���ַ����ĵ�i-1λ�͵�iλ�����һ��10��26�����֣�˵���������ڵ�i-2λ��
    ���뷽���ϼ������롣����ַ����ĵ�i-1λ�͵�iλ���������Ч��λ���֣���
    �ҵ�iλ����0�Ļ���˵���������ڵ�i-1λ�Ľ��뷽���ϼ������롣
    ���ԣ�����������������ϣ���dp[i]=dp[i-1]+dp[i-2]������dp[i]=dp[i-1]��
    */
    public int numDecodings(String s) {
        if(s.equals("") == true)
            return 0;
        
        int[] dp = new int[s.length() + 1];
        
        // ��ʼ����һ�ֽ��뷽ʽ
        dp[0] = 1;
        // �����һλ��0�����޷�����
        if(s.charAt(0) == '0')
            dp[1] = 0;
        else
            dp[1] = 1;
            
        for(int i = 2; i <= s.length(); i ++) {
            int digi_1 = Integer.parseInt(s.substring(i - 1, i));//һλ��
            int digi_2 = Integer.parseInt(s.substring(i - 2, i));//��λ��
            
            //�l��һ(��λ��10~26)
            if(digi_2 <= 26 && digi_2 >= 10)
                dp[i] += dp[i - 2];
            //�l����(һλ��1~9)
            if(digi_1 != 0)
                dp[i] += dp[i - 1];
        }
        
        return dp[s.length()];
    }
}