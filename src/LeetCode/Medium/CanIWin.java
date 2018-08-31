package src.LeetCode.Medium;

import java.util.Arrays;

public class CanIWin {
    int[] dp;
    boolean[] used;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if(sum < desiredTotal) {        //取完所有数，也达不到desiredTotal，无法赢得游戏
            return false;
        }
        if(desiredTotal <= maxChoosableInteger) {      //第一步就可以获得胜利
            return true;
        }
        dp = new int[1 << maxChoosableInteger];
        Arrays.fill(dp , -1);
        used = new boolean[maxChoosableInteger + 1];
        
        return helper(desiredTotal);
    }
    
    public boolean helper(int desiredTotal){
        if(desiredTotal <= 0) {
            return false;
        }
        int key = format(used);         //把used数组转为十进制表示
        if(dp[key] == -1){ 
            for(int i = 1; i < used.length; i++){    //枚举未选择的数
                if(!used[i]){
                    used[i] = true;

                    if(!helper(desiredTotal - i)){
                        dp[key] = 1;
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            dp[key] = 0;
        }
        return dp[key] == 1;
    }
   

    public int format(boolean[] used){
        int num = 0;
        for(boolean b: used){
            num <<= 1;
            if(b) {
                num |= 1;
            }
        }
        return num;
    }
}