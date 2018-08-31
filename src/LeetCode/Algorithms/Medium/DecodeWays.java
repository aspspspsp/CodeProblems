package src.LeetCode.Algorithms.Medium;

public class DecodeWays {
    /*
    12121
    dp[0] = 1 
    dp[1] = 1	1
    dp[2] = 2	1,2 12 <= dp[1] + dp[0]
    dp[3] = 3	1,2,3 12,1 1,21 <= dp[2] + dp[1]
    dp[4] = 5	1,2,1,2 12,1,2 1,21,2 1,2,12, 12,12 <= dp[3] + dp[2]
    dp[5] = 8   1,2,1,2,1 12,1,2,1 1,21,2,1 1,2,12,1
    			1,2,1,21 12,12,1 12,1,12 1,12,21 <= dp[4] + dp[3]
    
    1234
    dp[0] = 1
    dp[1] = 1   1
    dp[2] = 2   1,2 12 <= dp[1] + dp[0]
    dp[3] = 3   1,2,3 12,3 1,23 <= dp[2] + dp[1]
    dp[4] = 3   1,2,3,4 12,3,4 1,23,4 <= dp[3]
    
    12012
    dp[0] = 1
    dp[1] = 1	1
    dp[2] = 2	1,2 12 <= dp[0] + dp[1]
    dp[3] = 1	1,20 <= dp[1]
    dp[4] = 1   1,20,1 <= dp[3]
    dp[5] = 2	1,20,1,2 1,20,12 <= dp[4] + dp[3]
    
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
    
    從上面的例子可以看到，若當前的兩位數不含有0時，遞歸式則為
  dp[i] = dp[i - 1] + dp[i - 2]
  
   但還要考慮有0的情況，故我們會掃描兩次，一次掃前1位數，另一次掃前2位數
           digi_1, digi_2
   如：02 ->   2,     02(轉為int後為2)
   這時
  dp[i] += dp[i - 1]
  
            digi_1, digi_2
   如：20 ->   0,     20(轉為int後為2)
   這時
  dp[i] += dp[i - 2]
  
            digi_1, digi_2
   如：21 ->   1,     21(轉為int後為2)
   這時
  dp[i] +=  dp [i - 1] + dp[i - 2]
  
  但還要注意首字為0的情況，若首字為0時，則dp[1]設為0
  
 */
    public int numDecodings(String s) {
        if(s.equals("") == true)
            return 0;
        
        int[] dp = new int[s.length() + 1];
        
        //為方便遞歸，默認都沒有數字時，一定有一條路徑
        dp[0] = 1;
        
        //若首位數為0的話，則一開始就為0(路徑為0)
        if(s.charAt(0) == '0')
            dp[1] = 0;
        else
            dp[1] = 1;
            
        for(int i = 2; i <= s.length(); i ++) {
            //檢查從前面數一位數
        	int digi_1 = Integer.parseInt(s.substring(i - 1, i));
            //檢查從前面數兩位數
            int digi_2 = Integer.parseInt(s.substring(i - 2, i));
            
            //檢查兩位數是否在10~26之間
            if(digi_2 <= 26 && digi_2 >= 10)
                dp[i] += dp[i - 2];
            //檢查一位數是否在1~9之間
            if(digi_1 != 0)
                dp[i] += dp[i - 1];
        }
        
        return dp[s.length()];
    }
}