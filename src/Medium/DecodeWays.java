package Medium;

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
    
    解码是有规律的，所以我们可以尝试动态规划。
    假设数组dp[i]表示从头到字符串的第i位，一共有多少种解码方法的话，那么如
    果字符串的第i-1位和第i位能组成一个10到26的数字，说明我们是在第i-2位的
    解码方法上继续解码。如果字符串的第i-1位和第i位不能组成有效二位数字，而
    且第i位不是0的话，说明我们是在第i-1位的解码方法上继续解码。
    所以，如果两个条件都符合，则dp[i]=dp[i-1]+dp[i-2]，否则dp[i]=dp[i-1]。
    */
    public int numDecodings(String s) {
        if(s.equals("") == true)
            return 0;
        
        int[] dp = new int[s.length() + 1];
        
        // 初始化第一种解码方式
        dp[0] = 1;
        // 如果第一位是0，则无法解码
        if(s.charAt(0) == '0')
            dp[1] = 0;
        else
            dp[1] = 1;
            
        for(int i = 2; i <= s.length(); i ++) {
            int digi_1 = Integer.parseInt(s.substring(i - 1, i));//一位數
            int digi_2 = Integer.parseInt(s.substring(i - 2, i));//二位數
            
            //條件一(兩位數10~26)
            if(digi_2 <= 26 && digi_2 >= 10)
                dp[i] += dp[i - 2];
            //條件二(一位數1~9)
            if(digi_1 != 0)
                dp[i] += dp[i - 1];
        }
        
        return dp[s.length()];
    }
}