package LeetCode.Easy;
/*
 * 可以把該整數對2取對數，如果結果為整數，說明該數是2的冪次 
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n == 0)
            return false;
        
        //取整數與對數
        double log2InDouble = Math.log10(n) / Math.log10(2);
        int log2InInt = (int)log2InDouble;
        
        //取餘數
        double reminder = log2InDouble - log2InInt;
        
        //若餘數為0則為true，否則false
        if(reminder == 0)
            return true;
        else
            return false;
    }
}
