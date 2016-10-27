package Easy;

public class PowerOfThree {
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