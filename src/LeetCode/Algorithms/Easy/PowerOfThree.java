package src.LeetCode.Algorithms.Easy;

public class PowerOfThree {
/*
 * 可以把該整數對3取對數，如果結果為整數，說明該數是3的冪次 
 */
    public boolean isPowerOfThree(int n) {
        if(n == 0)
            return false;
        
        double log3InDouble = Math.log10(n) / Math.log10(3);
        int log3InInt = (int)log3InDouble;
        double reminder = log3InDouble - log3InInt;
        if(reminder == 0)
            return true;
        else
            return false;
    }
}